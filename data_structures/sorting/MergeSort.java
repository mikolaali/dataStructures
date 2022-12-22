package data_structures.sorting;
class MergeSort {
    public static void main(String[] args) {
    ArrayX arr = new ArrayX(100);
        arr.insert(64); // Вставка элементов
        arr.insert(21);
        arr.insert(33);
        arr.insert(70);
        arr.insert(12);
        arr.insert(85);
        arr.insert(44);
        arr.insert(3);
        arr.insert(99);
        arr.insert(0);
        arr.insert(108);
        arr.insert(36);
        arr.display(); // Вывод массива
        arr.mergeSort(); // Сортировка слиянием
        arr.display();
    }
}


class ArrayX {
    private long[] arr;
    private int ElsAmount;

    public ArrayX(int size) {
        arr = new long[size];
        ElsAmount = 0;
    }

    public void insert(long n) {arr[ElsAmount] = n; ElsAmount++;}

    public void display() {
        for (int i=0;i<ElsAmount;i++) {
            System.out.println(arr[i]);
        }
    }

    public void  mergeSort() {
        long[] tempArr = new long[ElsAmount];
        recursMergeSort(tempArr, 0, ElsAmount-1);
    }

    private void recursMergeSort(long[] tempArr, int LowerBound, int UpperBound) {
        if (LowerBound==UpperBound) {return;}
        else {
            int mid = (LowerBound + UpperBound)/2;
            recursMergeSort(tempArr, LowerBound, mid);
            recursMergeSort(tempArr, mid+1, UpperBound);
            merge(tempArr, LowerBound, mid+1, UpperBound);
        }
    }

    private void merge(long[] tempArr, int lowPtr, int highPtr, int upperBound) {
        int i = 0;
        int lBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound-lBound+1;

        while (lowPtr<=mid && highPtr<=upperBound) {
            if(arr[lowPtr] < arr[highPtr]) {
                tempArr[i++] = arr[lowPtr++];
            } else {
                tempArr[i++] = arr[highPtr];
            }
        }
        while (lowPtr<=mid) {
            tempArr[i++] = arr[lowPtr++];
        }
        while (highPtr<=upperBound) {
            tempArr[i++] = arr[highPtr++];
        }
        for (i=0;i<n;i++) {arr[lBound+i] = tempArr[i];}
    }
}