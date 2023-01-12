package nik.queue;

public class FirstLastNodeListQueueApp {
    public static void main(String[] args) {
        FirstLastNodeListQueue queue = new FirstLastNodeListQueue();
        queue.insert(32);
        queue.insert(12);
        queue.insert(43);
        queue.display();

        queue.delete();
        queue.delete();
        queue.delete();
        queue.insert(333);
        queue.display();
    }
}
