package nik.list.listinsertionsort;

import java.util.Random;

public class ListInsertionSortApp {
    public static void main(String[] args) {
        Random rnd = new Random();
        Node[] arr = new Node[10];
        for (int i = 0; i < 10; i++) {
            arr[i] = new Node(rnd.nextInt(99));
            System.out.print(arr[i].data + " ");
        }
        System.out.println("");

        SortedList list = new SortedList(arr);
        for (int i = 0; i < 10; i++){
            arr[i] = list.remove();
            System.out.print(arr[i].data + " ");
        }
    }
}
