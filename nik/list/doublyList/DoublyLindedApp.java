package nik.list.doublyList;

public class DoublyLindedApp {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insertFirst(22);
        list.insertFirst(33);
        list.insertFirst(44);

        list.insertLast(11);
        list.insertLast(33);
        list.insertLast(55);
        list.displayForward();
        System.out.println("");
        list.displayBackward();

        list.deleteFirst();
        list.deleteLast();
        list.deleteKey(11);
        System.out.println("");
        list.displayForward();

        list.insertAfter(22,77);
        list.insertAfter(33,88);
        System.out.println("");
        list.displayForward();
    }
}
