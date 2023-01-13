package nik.list.sortedlist;

public class SortedListApp {
    public static void main(String[] args) {
        SortedList list = new SortedList();
        // вставка в начале / середине и конце списка
        list.insert(1);
        list.insert(32);
        list.insert(12);
        list.insert(75);
        list.insert(80);
        list.display();
        System.out.println("");
        list.remove();
        list.display();
    }
}
