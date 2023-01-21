package nik.arrays.strategy;

public class QuickSort2Strategy implements SortStrategy{
    @Override
    public int[] sort(int[] array, int size) {
        quickSort(array, 0, size - 1);
        return array;
    }

    public void quickSort(int[] arr, int left, int right){
        int size = right - left + 1;
        if(size <= 3) {
            manualSort(arr, left, right);
            return;
        }
        int median = median3(arr, left, right);
        int partition = partitionIt(arr, left, right, median);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition + 1, right );
    }

    public int partitionIt(int[] arr, int left, int right, int pivot){
        int leftPtr = left;
        int rightPtr = right - 1;
        while (true){
            while (arr[++leftPtr] < pivot)
                ;
            while (arr[--rightPtr] > pivot)
                ;
            if(leftPtr >= rightPtr)
                break;
            else
                swap(arr, leftPtr, rightPtr);
        }
        swap(arr, leftPtr, right - 1);
        return leftPtr;
    }

    public int median3(int[] arr, int left, int right){
        int median = (left + right)/2;
        if (arr[left] > arr[median])
            swap(arr, left, median);
        if (arr[left] > arr[right])
            swap(arr,left, right);
        if (arr[median] > arr[right])
            swap(arr, median, right);
        swap(arr, median, right - 1);
        return arr[right - 1];
    }

    public void manualSort(int[] arr, int left, int right){
        int size = right - left + 1;
        if( size <= 1) return;
        else if (size <= 2)
            if (arr[left] > arr[right])
                swap(arr, left, right);
        else {
            int center = left + 1;
            if (arr[left] > arr[center])
                swap(arr, left, center);
            if (arr[left] > arr[right])
                swap(arr,left, right);
            if (arr[center] > arr[right])
                swap(arr, center, right);
        }
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

}
