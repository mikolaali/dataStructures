package nik.arrays.strategy;

public class BubbleSortStrategy implements SortStrategy{
    @Override
    public int[] sort(int[] array, int size) {
        int rightBorderIndexIncluded,tmp;
        rightBorderIndexIncluded = size - 1;
        for(; rightBorderIndexIncluded > 0; rightBorderIndexIncluded--)
            for(int i = 0; i < rightBorderIndexIncluded; i++){
                if(array[i] > array[i+1]){
                   tmp = array[i + 1];
                   array[i + 1] = array[i];
                   array[i] = tmp;
                }
            }
        return array;
    }
}
