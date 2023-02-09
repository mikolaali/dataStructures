package ann.arrays.strategy;

import java.util.ArrayList;
import java.util.List;

public class DigitSortStrategy implements SortStrategy{
    @Override
    public void sort(int[] arr, int size) {
        digitSort(arr, size);

    }

    public void digitSort(int[] arr, int size) {
       List<Integer>[] buckets = new ArrayList[10];
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<Integer>();
        }
        boolean flag = true;
        int t;
        int divider = 1;
       while (flag) {
           flag = false;
           for (Integer a: arr) {
               t = a / divider;
               buckets[t % 10].add(a);
               if (t > 0) flag = true;
           }
           int k = 0;
           for (int i = 0; i < 10; i++) {
               for (Integer num: buckets[i] ) {
                   arr[k++] = num;
               }
               buckets[i].clear();
           }
           divider *= 10;

       }


    }
}
