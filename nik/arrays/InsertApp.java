package nik.arrays;

import nik.arrays.strategy.InsertSortStrategy;

public class InsertApp {
    public static void main(String[] args) {
        OrdArray array = new OrdArray(20, new InsertSortStrategy());
        array.display();
    }
}
