package nik.arrays.strategy;
/*for each (unsorted) partition

set first element as pivot
  storeIndex = pivotIndex+1
  for i = pivotIndex+1 to rightmostIndex
    if ((a[i] < a[pivot]) or (equal but 50% lucky))
      swap(i, storeIndex); ++storeIndex
  swap(pivot, storeIndex-1) // return storeIndex - 1 -
  */

public class QuickSortStrategy implements SortStrategy{
    @Override
    public int[] sort(int[] array, int size) {
        quickSort(array, 0, size - 1);
        return array;
    }

    public void quickSort(int[] arr, int left, int right){
        if(right - left <= 0 ) return;

        int pivot = arr[(left + right )/2];
        int partition = partitionIt(arr, left, right);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition + 1, right);
    }

    public int partitionIt(int[] arr, int left, int right){
        int leftPtr = left - 1;
        int rightPtr = right;
        int pivot = arr[right];
        while(true){
            while(leftPtr < right && arr[++leftPtr] < pivot)
                ;
            while (rightPtr > left && arr[--rightPtr] > pivot)
                ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(arr, leftPtr, rightPtr);
        }
        swap(arr, leftPtr, right);
        return leftPtr;
    }

    private void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
