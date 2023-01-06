package nik.arrays;

import nik.arrays.strategy.SelectSortStrategy;

import java.util.Arrays;

public class SortApp {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        System.out.println("===============  Ord Array like in book variant =============");
        OrdArray ordBubbleSorted = new OrdArray(25);
        OrdArray ordSelectSorted = (OrdArray) ordBubbleSorted.clone();
        // SORT arrays with diff stategy -----------------------------------------
        ordSelectSorted.setSortStrategy(new SelectSortStrategy());
        ordBubbleSorted.sort();
        ordSelectSorted.sort();
        // DISPLAY SORYED ARRAYS -------------------------------------------------
        System.out.println("BUBBLE sorted ARRAY 1:");
        ordBubbleSorted.display();
        System.out.println("SELECT sorted ARRAY 1:");
        ordSelectSorted.display();
        // COMPARE 2 ARRAYS
        OrdArray array = new OrdArray(5);
        int[] tmp = array.getArray();
        if (array.getArray() == tmp) {
            System.out.println("Equal");
        }
        else System.out.println("False");
        if(Arrays.equals(tmp, array.getArray())){
            System.out.println("Equals");
        };
    }
}
