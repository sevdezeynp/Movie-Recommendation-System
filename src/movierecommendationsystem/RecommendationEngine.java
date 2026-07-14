package movierecommendationsystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RecommendationEngine {

    // Target user ile diğer kullanıcıları karşılaştırıp heap oluşturur
    public static MaxHeap buildSimilarityHeap( UserVector targetUser,
            ArrayList<UserVector> users) {

        MaxHeap heap = new MaxHeap();

        // Ana veri setindeki bütün kullanıcıları dolaş
        for (UserVector user : users) {

            // Target user ile mevcut kullanıcı arasındaki benzerlik
            double similarity = CosineSimilarity.calculate(targetUser, user);

            // Kullanıcıyı similarity değeriyle birlikte heap'e ekle
            heap.insert(new HeapNode(user, similarity));
        }

        return heap;
    }

    // En benzer X kullanıcıdan, her biri için K tane film önerir
    public static ArrayList<String> recommendMovies(
            UserVector targetUser,
            ArrayList<UserVector> users,
            HashMap<Integer, String> movies,
            int x,
            int k) {

        ArrayList<String> recommendations = new ArrayList<>();

        // Aynı filmi tekrar önermemek için film ID'lerini tutar
        ArrayList<Integer> addedMovieIds = new ArrayList<>();

        // Benzer kullanıcıları similarity değerine göre heap içinde tut
        MaxHeap heap = buildSimilarityHeap(targetUser, users);

        // Heap'ten en benzer X kullanıcıyı al
        for (int i = 0; i < x; i++) {

            HeapNode node = heap.extractMax();

            if (node == null) {
                break;
            }

            UserVector similarUser = node.getUser();
            double similarity = node.getSimilarity();

            // Benzer kullanıcının puanladığı filmleri listeye al
            ArrayList<Map.Entry<Integer, Integer>> ratedMovies =
                    new ArrayList<>(similarUser.getRatings().entrySet());

            // Filmleri puana göre büyükten küçüğe sırala
            ratedMovies.sort((a, b) -> b.getValue().compareTo(a.getValue()));

            int count = 0;

            // Bu kullanıcıdan en yüksek puanlı K filmi seç
            for (Map.Entry<Integer, Integer> entry : ratedMovies) {

                int movieId = entry.getKey();
                int rating = entry.getValue();

                /*
                 * Target user zaten bu filmi puanladıysa önerme.
                 * Ayrıca aynı film daha önce önerildiyse tekrar ekleme.
                 */
                if (!targetUser.getRatings().containsKey(movieId)
                        && !addedMovieIds.contains(movieId)) {

                    String movieName = movies.get(movieId);

                    // Film adı movies.csv içinde yoksa None yaz
                    if (movieName == null || movieName.trim().isEmpty()) {
                        movieName = "None";
                    }

                    recommendations.add(
                            "Similar User: User_" + similarUser.getUserId()
                            + " | Movie: " + movieName
                            + " | Rating: " + rating
                            + " | Similarity: " + String.format("%.4f", similarity)
                    );

                    // Bu film önerildiği için listeye ekle
                    addedMovieIds.add(movieId);

                    count++;
                }

                if (count >= k) {
                    break;
                }
            }
        }

        if (recommendations.isEmpty()) {
            recommendations.add("None");
        }

        return recommendations;
    }
}