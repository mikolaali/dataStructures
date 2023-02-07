package nik.heap;

public class HeapApp {
    public static void main(String[] args) {
        int val, val2;
        Heap heap = new Heap(31);
        boolean success;

        heap.insert(70);
        heap.insert(40);
        heap.insert(50);
        heap.insert(20);
        heap.insert(60);
        heap.insert(100);
        heap.insert(80);
        heap.insert(30);
        heap.insert(10);
        heap.insert(90);

        heap.insert(110);
        heap.insert(5);
        heap.insert(130);
        heap.insert(3);
        heap.insert(14);
        heap.displayHeap();
    }
}
