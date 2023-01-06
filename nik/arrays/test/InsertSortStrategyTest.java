package nik.arrays.test;

import nik.arrays.strategy.InsertSortStrategy;
import org.junit.jupiter.api.Test;

import static nik.arrays.test.TestLib.compare;
import static org.junit.jupiter.api.Assertions.*;

class InsertSortStrategyTest {
    InsertSortStrategy strategy = new InsertSortStrategy();
    int[] array = {13,2,43,19,75,11,47,73,25,8};

    @Test
    void test_sort() {
        array = strategy.sort(array, array.length);
        assertTrue(compare(array));
    }

    @Test
    public void display() {
        array = strategy.sort(array, 10);
        System.out.println("----------");
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("------");
        System.out.println(array[0] + " " + array.length);
    }
    @Test
    void sort() {
    }
}