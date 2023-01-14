package nik.ch4;

public class DequeDoublyLinkedListApp {
    public static void main(String[] args) {
        DequeDoublyLinkedList list = new DequeDoublyLinkedList();
        list.insertFirst(11);
        list.insertFirst(22);
        list.insertFirst(33);
        list.insertLast(44);
        list.insertLast(55);
        list.insertLast(66);
        list.display();
        list.removeFirst();
        list.removeLast();
        System.out.println("------");
        list.display();
    }
}
