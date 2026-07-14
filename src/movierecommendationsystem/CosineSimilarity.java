package movierecommendationsystem;

import java.util.HashMap;
import java.util.Map;

public class CosineSimilarity {

    // İki kullanıcı arasındaki cosine similarity değerini hesaplar
    public static double calculate(UserVector u1, UserVector u2) {

        // Skaler çarpım değeri
        double dotProduct = 0;

        // Birinci kullanıcının vektör uzunluğu
        double norm1 = 0;

        // İkinci kullanıcının vektör uzunluğu
        double norm2 = 0;

        HashMap<Integer, Integer> r1 = u1.getRatings();
        HashMap<Integer, Integer> r2 = u2.getRatings();

        // Birinci kullanıcının puanlarını dolaş
        for (Map.Entry<Integer, Integer> entry : r1.entrySet()) {

            int movieId = entry.getKey();
            int rating1 = entry.getValue();

            // Vektör uzunluğu için karelerin toplamı
            norm1 += rating1 * rating1;

            // Aynı filmi ikinci kullanıcı da puanladıysa
            if (r2.containsKey(movieId)) {

                int rating2 = r2.get(movieId);

                // Skaler çarpım hesabı
                dotProduct += rating1 * rating2;
            }
        }

        // İkinci kullanıcının vektör uzunluğu hesabı
        for (int rating : r2.values()) {

            norm2 += rating * rating;
        }

        // Sıfıra bölme hatasını önlemek için kontrol
        if (norm1 == 0 || norm2 == 0) {
            return 0;
        }

        // Cosine similarity formülü
        return dotProduct / (Math.sqrt(norm1) * Math.sqrt(norm2));
    }
}