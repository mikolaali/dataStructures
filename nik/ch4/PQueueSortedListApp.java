package nik.ch4;

public class PQueueSortedListApp {
    public static void main(String[] args) {
        PQueueSortedList queue = new PQueueSortedList();
        queue.insert(11);
        queue.insert(22);
        queue.insert(33);
        queue.insert(44);
        queue.display();
        System.out.println(queue.remove());
        System.out.println("-----------");

    }
}
