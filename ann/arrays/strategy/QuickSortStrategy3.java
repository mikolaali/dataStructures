package ann.arrays.strategy;

public class QuickSortStrategy3 implements SortStrategy{
    @Override
    public void sort(int[] arr, int size) {
        quickSort(arr, 0, size-1);
    }

    private void quickSort(int[] arr, int left, int right) {
        int size = right - left + 1;
        if (size < 10) {     // разбиение с медианой требует минимум 4х ячеек
           insertionSort(arr, left, right); //return;
        }
        else {
            int pivotKey = medianOf3(arr, left, right);
            int partition = partition(arr, left, right, pivotKey);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    private int medianOf3(int[] arr, int left, int right) {
        int mid = (left + right)/2;
        if (arr[left] > arr[mid]) swap(arr, left, mid);
        if (arr[left] > arr[right]) swap(arr, left, right);
        if (arr[mid] > arr[right]) swap(arr, mid, right);
        swap(arr, mid, right-1);
        return arr[right-1];
    }

    private int partition(int[] arr, int left, int right, int pivot) {
        int leftP = left;
        int rightP = right-1;
        while (true) {
            while (arr[++leftP] < pivot);  //   [ 2, 6, 5, 8, 7, 9 ]    pivot = 7
            while (right > 0 && arr[--rightP] > pivot);
            if (leftP>=rightP) break;
            else swap(arr, leftP, rightP);
        }
        swap(arr, leftP, right-1);
        return leftP;
    }

    private void swap(int[] arr, int dex1, int dex2) {
        int temp;
        temp = arr[dex1];
        arr[dex1] = arr[dex2];
        arr[dex2] = temp;
    }

    private void insertionSort(int[] arr, int left, int right) {
        for (int k=left+1; k<=right; k++) {
            int t = arr[k];
            int i = k;
            while (i>left && arr[i-1]>=t) {
                arr[i] = arr[i-1];
                --i;
            }
            arr[i] = t;
        }
    }
}

// p. 337