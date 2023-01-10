package nik.queue;

public class PriorityQueueApp {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue(10);
        queue.init(10);
        queue.insert(13);
        while(!queue.isEmpty()) {
            System.out.print(queue.remove() + " --- ");
        }
    }
}

