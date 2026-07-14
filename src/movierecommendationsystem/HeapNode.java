package movierecommendationsystem;

public class HeapNode {

    // Heap içinde tutulacak kullanıcı
    private UserVector user;

    // Kullanıcının similarity değeri
    private double similarity;

    public HeapNode(UserVector user, double similarity) {

        this.user = user;
        this.similarity = similarity;
    }

    // Kullanıcı bilgisini döndürür
    public UserVector getUser() {
        return user;
    }

    // Similarity değerini döndürür
    public double getSimilarity() {
        return similarity;
    }
}