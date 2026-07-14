package movierecommendationsystem;

import java.util.ArrayList;

public class MaxHeap {

    // Benzer kullanıcıları similarity değerine göre tutan heap
    private ArrayList<HeapNode> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // Yeni kullanıcıyı heap'e ekler
    public void insert(HeapNode node) {

        heap.add(node);

        // Eklenen elemanı doğru konuma çıkar
        heapifyUp(heap.size() - 1);
    }

    // Similarity değeri en yüksek kullanıcıyı çıkarır
    public HeapNode extractMax() {

        if (heap.isEmpty()) {
            return null;
        }

        // MaxHeap olduğu için en büyük değer köktedir
        HeapNode max = heap.get(0);

        // Son elemanı köke taşı
        HeapNode last = heap.remove(heap.size() - 1);

        if (!heap.isEmpty()) {

            heap.set(0, last);

            // Heap düzenini tekrar sağla
            heapifyDown(0);
        }

        return max;
    }

    // Eklenen elemanı parent ile karşılaştırarak yukarı taşır
    private void heapifyUp(int index) {

        while (index > 0) {

            int parent = (index - 1) / 2;

            // Çocuğun similarity değeri parent'tan büyükse yer değiştir
            if (heap.get(index).getSimilarity()
                    >
                heap.get(parent).getSimilarity()) {

                swap(index, parent);

                index = parent;

            } else {

                break;
            }
        }
    }

    // Kökten başlayan elemanı çocuklarla karşılaştırarak aşağı taşır
    private void heapifyDown(int index) {

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int largest = index;

            // Sol çocuk daha büyükse largest sol çocuk olur
            if (left < heap.size() &&
                heap.get(left).getSimilarity()
                >
                heap.get(largest).getSimilarity()) {

                largest = left;
            }

            // Sağ çocuk daha büyükse largest sağ çocuk olur
            if (right < heap.size() &&
                heap.get(right).getSimilarity()
                >
                heap.get(largest).getSimilarity()) {

                largest = right;
            }

            // Eğer daha büyük çocuk varsa yer değiştir
            if (largest != index) {

                swap(index, largest);

                index = largest;

            } else {

                break;
            }
        }
    }

    // Heap içindeki iki elemanın yerini değiştirir
    private void swap(int i, int j) {

        HeapNode temp = heap.get(i);

        heap.set(i, heap.get(j));

        heap.set(j, temp);
    }

    // Heap boş mu kontrol eder
    public boolean isEmpty() {
        return heap.isEmpty();
    }
}