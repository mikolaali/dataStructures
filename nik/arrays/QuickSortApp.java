package nik.arrays;

import nik.arrays.strategy.QuickSort3Strategy;
import nik.arrays.strategy.QuickSortStrategy;

public class QuickSortApp {
    public static void main(String[] args) {
        OrdArray arr = new OrdArray(50, new QuickSortStrategy());
        arr.init();
//        arr.display();
//        arr.sort();
//        arr.display();
        arr.setSortStrategy(new QuickSort3Strategy());
        arr.init();
        arr.sort();
        arr.display();
    }
}
