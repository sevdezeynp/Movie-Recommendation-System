package movierecommendationsystem;

import java.util.HashMap;

public class UserVector {

    // Kullanıcı numarası
    private String userId;

    // Film ID ve puan bilgisini tutar
    private HashMap<Integer, Integer> ratings;

    public UserVector(String userId) {

        this.userId = userId;

        // Kullanıcının puanları burada tutulur
        this.ratings = new HashMap<>();
    }

    // Filme verilen puanı ekler
    public void addRating(int movieId, int rating) {

        ratings.put(movieId, rating);
    }

    // Kullanıcı numarasını döndürür
    public String getUserId() {

        return userId;
    }

    // Kullanıcının tüm puanlarını döndürür
    public HashMap<Integer, Integer> getRatings() {

        return ratings;
    }
}