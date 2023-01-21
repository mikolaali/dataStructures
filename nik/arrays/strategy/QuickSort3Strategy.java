package nik.arrays.strategy;

public class QuickSort3Strategy implements SortStrategy {

    @Override
    public int[] sort(int[] array, int size) {

        quickSort(array, 0, size - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        int size = right - left + 1;
        if (size < 12)
            insertionSort(array, left, right);
        else {
            int median = medianOf3(array, left, right);
            int partition = partitionIt(array, left, right, median);
            quickSort(array, left, partition - 1);
            quickSort(array, partition + 1, right);
        }
    }

    private int medianOf3(int[] array, int left, int right) {
        int median = (right + left) / 2;
        if (array[left] > array[median])
            swap(array, left, median);
        if (array[left] > array[right])
            swap(array, left, right);
        if (array[median] > array[right])
            swap(array, median, right);
        swap(array, median, right - 1);
        return array[right - 1];
    }
    public int partitionIt(int[] array, int left, int right, int median) {
        int leftPtr = left;
        int rightPtr = right - 1;
        while (true) {
            while (array[++leftPtr] < median)
                ;
            while (array[--rightPtr] > median)
                ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(array, leftPtr, rightPtr);
        }
        swap(array, leftPtr, right - 1);
        return leftPtr;
    }
    private void insertionSort(int[] array, int left, int right) {
        for (int outer = left + 1; outer <= right; outer++) {
            int inner = outer;
            int tmp = array[inner];
            while ( inner > left && array[inner - 1] > tmp ) {
                array[inner] = array[inner - 1];
                inner--;
            }
            array[inner] = tmp;
        }
    }
    private void swap(int[] array, int left, int right) {
        int tmp = array[left];
        array[left] = array[right];
        array[right] = tmp;
    }
}

