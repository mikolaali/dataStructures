package nik.arrays;

import nik.arrays.strategy.MergeSortStrategy;

public class MergeApp {
    public static void main(String[] args) {
        OrdArray array = new OrdArray(33, new MergeSortStrategy());
        array.display();
    }
}
