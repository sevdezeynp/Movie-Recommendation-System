package movierecommendationsystem;

import java.util.ArrayList;
import java.util.HashMap;

public class MovieDataSet {

    // Ana veri setindeki kullanıcılar
    private ArrayList<UserVector> mainUsers;

    // target_user.csv içindeki kullanıcılar
    private ArrayList<UserVector> targetUsers;

    // Film ID ve film adı bilgileri
    private HashMap<Integer,String> movies;

    public MovieDataSet() {

        mainUsers = new ArrayList<>();
        targetUsers = new ArrayList<>();
        movies = new HashMap<>();
    }

    // Ana kullanıcı listesini döndürür
    public ArrayList<UserVector> getMainUsers() {
        return mainUsers;
    }

    // Target kullanıcı listesini döndürür
    public ArrayList<UserVector> getTargetUsers() {
        return targetUsers;
    }

    // Film listesini döndürür
    public HashMap<Integer,String> getMovies() {
        return movies;
    }

    // Ana kullanıcı listesini günceller
    public void setMainUsers(ArrayList<UserVector> mainUsers) {
        this.mainUsers = mainUsers;
    }

    // Target kullanıcı listesini günceller
    public void setTargetUsers(ArrayList<UserVector> targetUsers) {
        this.targetUsers = targetUsers;
    }

    // Film listesini günceller
    public void setMovies(HashMap<Integer,String> movies) {
        this.movies = movies;
    }
}