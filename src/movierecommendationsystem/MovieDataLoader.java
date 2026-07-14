package movierecommendationsystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class MovieDataLoader {

    // main_data.csv ve target_user.csv dosyalarını okur
    public static ArrayList<UserVector> loadUsers(String filePath) {

        // Okunan kullanıcıları burada tutuyorum
        ArrayList<UserVector> users = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));

            // İlk satır film ID'lerini içeriyor
            String headerLine = br.readLine();

            String[] headers = headerLine.split(",");

            String line;

            // Dosyadaki kullanıcı satırlarını tek tek oku
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                // İlk sütun kullanıcı ID
                UserVector user = new UserVector(parts[0]);

                // Diğer sütunlar film puanları
                for (int i = 1; i < parts.length; i++) {

                    int rating = Integer.parseInt(parts[i]);

                    // 0 olan değerleri eklemiyorum, çünkü kullanıcı filmi puanlamamış
                    if (rating > 0) {

                        int movieId = Integer.parseInt(headers[i]);

                        // Film ID ve rating bilgisini kullanıcıya ekle
                        user.addRating(movieId, rating);
                    }
                }

                users.add(user);
            }

            br.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return users;
    }

    // movies.csv dosyasından film ID ve film adlarını okur
    public static HashMap<Integer,String> loadMovies(String filePath) {

        // Film ID -> Film adı şeklinde tutuyorum
        HashMap<Integer,String> movies = new HashMap<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(filePath));

            // İlk satır başlık olduğu için geçiyorum
            String line = br.readLine();

            while ((line = br.readLine()) != null) {

                /*
                 * Film isimlerinde virgül olabildiği için direkt split(",")
                 * kullanmadım. İlk virgülden önce movieId, son virgülden önce
                 * film adı var.
                 */
                int firstComma = line.indexOf(",");
                int lastComma = line.lastIndexOf(",");

                int movieId = Integer.parseInt(line.substring(0, firstComma).trim());

                String movieName = line.substring(firstComma + 1, lastComma)
                                .replace("\"", "")
                                .trim();

                movies.put(movieId, movieName);
            }

            br.close();

        } catch (Exception e) {

            e.printStackTrace();
        }

        return movies;
    }
}