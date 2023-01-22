package nik.arrays.strategy;

import java.util.ArrayList;
import java.util.List;

public class RadixSortStrategy implements SortStrategy{

    @Override
    public int[] sort(int[] array, int size) {
        radixSort(array, size);
        return array;
    }

    public static void radixSort(int[] input, int size) {

        List<Integer>[] buckets = new ArrayList[size];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }

        // sort
        boolean flag = false;
        int tmp = -1;
        int divisor = 1;

        while (!flag) {
            flag = true;
            // split input between lists
            for (Integer i : input) {
                tmp = i / divisor;
                buckets[tmp % 10].add(i);
                if (flag && tmp > 0) {
                    flag = false;
                }
            }
            // empty lists into input array
            int a = 0;
            for (int b = 0; b < 10; b++) {
                for (Integer i : buckets[b]) {
                    input[a++] = i;
                }
                buckets[b].clear();
            }
            // move to next digit
            divisor *= 10;
        }
    }
}
