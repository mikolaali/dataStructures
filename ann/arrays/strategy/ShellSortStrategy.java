package ann.arrays.strategy;

public class ShellSortStrategy implements SortStrategy{
    @Override
    public void sort(int[] arr, int size) {
        int h = 1;
        while (h*3 < size) {
            h = h*3 + 1;
        }
        while (h > 1) {
            shellSort(arr, h);
            h /= 3;
        }
    }

    private void shellSort(int[] arr, int h){
        for (int i = h; i < arr.length; i++) {
            for (int j = i; j >= h; j-=h) {
                if (arr[j] < arr[j-h])
                    swap(arr, j-h, j);
                else break;
            }
        }
    }

    private void swap(int[] arr, int left, int right){
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }

}
