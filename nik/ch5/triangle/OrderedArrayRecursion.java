package nik.ch5.triangle;

public class OrderedArrayRecursion {
    private int amount;
    private int[] arr;

    public OrderedArrayRecursion(int size) {
        amount = 0;
        arr = new int[size];
    }

    public void insert(int val){
        int i;
        for ( i = 0; i < amount; i++) {
            if(arr[i] > val) break;
        }
        if (i == arr.length) {
            System.out.println("array is FULL");
            return;
        }
        for (int j = amount; j > i ; j--) {
            arr[j] = arr[j - 1];
        }
        arr[i] = val;
        amount ++;
    }

    public int find(int val){
        return recursionFind(val, 0, amount - 1);
    }

    // returned INDEX of element
    private int recursionFind(int val, int lowerBound, int upperBound) {
        int mid = (upperBound + lowerBound)/2;
        if(arr[mid] == val) return mid;
        if(lowerBound > upperBound) return arr.length;
        if(arr[mid] < val)
            return recursionFind(val, mid + 1, upperBound);
        else
            return recursionFind(val, lowerBound, mid - 1);
    }

    public boolean isEmpty(){
        return amount == 0;
    }

    public int size(){
        return arr.length;
    }

    public void display(){
        if(isEmpty()) return;
        for (int i = 0; i < amount; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

}
