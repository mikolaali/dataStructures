package nik.arrays.strategy;

public class ShellSortStrategy implements SortStrategy{
    @Override
    public int[] sort(int[] array, int size) {
        int h = 1;
        while (3 * h < size)
            h = 3 + h + 1;
        while (h >= 1){
            shellSort(array, h);
            h /= 3;
        }
        return array;
    }

    private void shellSort(int[] arr, int h){
        for (int i = h; i < arr.length; i++) {
            for (int j = i; j >= h ; j -= h) {
                if(arr[j] < arr[j - h])
                    swap(arr, j, j - h );
                else break;
            }

        }
    }
    private void swap(int[] array, int left, int right){
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}
