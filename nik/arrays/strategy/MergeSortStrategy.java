package nik.arrays.strategy;

public class MergeSortStrategy implements SortStrategy{
    @Override
    public int[] sort(int[] array, int size) {
        int[] tmp = new int[size];
        recursionMerge(tmp, array, 0, size - 1);
        return array;
    }
    private void recursionMerge(int[] tmp, int[] arr, int lowBound, int upperBound){
        if(lowBound == upperBound) return;
        int mid = (lowBound + upperBound)/2;
        recursionMerge(tmp, arr, lowBound,mid);
        recursionMerge(tmp, arr,mid + 1, upperBound);
        merge(tmp, arr, lowBound, mid + 1, upperBound);
    }
        /* используем вспомогательный массив , копируем в него упорядоченно элементы из
        * из основного массива в конце , обратно копируем в основной массив
        *  */
    private void merge(int[] tmp, int[] arr,int leftHalfLptr, int rightHalfLptr, int rightHalfRptr){ // Lptr = LeftPtr; Rptr = rightPtr
        int j = 0;
        int lowBound = leftHalfLptr;
        int leftHalfRptr = rightHalfLptr - 1;
        while(leftHalfLptr <= leftHalfRptr && rightHalfLptr <= rightHalfRptr){
            if (arr[leftHalfLptr] <= arr[rightHalfLptr])
                tmp[j++] = arr[leftHalfLptr++];
            else
                tmp[j++] = arr[rightHalfLptr++];
        }
        while(leftHalfLptr <= leftHalfRptr)
            tmp[j++] = arr[leftHalfLptr++];

        while(rightHalfLptr <= rightHalfRptr)
            tmp[j++] = arr[rightHalfLptr++];
        for (j = 0; j < rightHalfRptr - lowBound + 1; j++) {
            arr[lowBound + j] = tmp[j];
        }
    }
}
