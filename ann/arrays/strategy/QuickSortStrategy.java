package ann.arrays.strategy;

public class QuickSortStrategy implements SortStrategy{
    @Override
    public void sort(int[] arr, int size) {
        quickSort(arr, 0, size-1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (right-left <=0) return;
        int pivotKey = arr[right];
        int partition = partition(arr, left, right, pivotKey);
        quickSort(arr, left, partition-1);
        quickSort(arr, partition+1, right);
    }

    private int partition(int[] arr, int left, int right, int pivot) {
        int leftP = left-1;
        int rightP = right;
        while (true) {
            while (arr[++leftP] < pivot);  //   [ 7, 4, 2, 8, 1 ]    pivot = 1
            while (right > 0 && arr[--rightP] > pivot);
            if (leftP>=rightP) break;
            else swap(arr, leftP, rightP);
        }
        swap(arr, leftP, right);
        return leftP;
    }

    private void swap(int[] arr, int dex1, int dex2) {
        int temp;
        temp = arr[dex1];
        arr[dex1] = arr[dex2];
        arr[dex2] = temp;
    }
}

// p. 330