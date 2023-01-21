package nik.arrays;

import nik.arrays.strategy.ShellSortStrategy;

public class ShellSortApp {
    public static void main(String[] args) {
        OrdArray arr = new OrdArray(20, new ShellSortStrategy());
//        arr.init();
//        arr.sort();
//        arr.display();
//        arr.init();
//        arr.sort();
//        arr.display();

        arr.init();
        arr.display();
        arr.shellSort();
        arr.display();
    }



}