package nik.arrays.strategy;

public class SelectSortStrategy implements SortStrategy{
    @Override
    public int[] sort(int[] array, int size1) {
        int minInd, searchInd, sortedInd;
        int lastElement = size1 - 1;
        int size = lastElement + 1;
        for (sortedInd = 0; sortedInd < lastElement; sortedInd++) {
            minInd = sortedInd;
            for (searchInd = minInd + 1; searchInd < size; searchInd++){
                if(array[minInd] > array[searchInd])
                    minInd = searchInd;
            }
            int tmp = array[sortedInd];
            array[sortedInd] = array[minInd];
            array[minInd] = tmp;
        }
        return array;
    }
}
