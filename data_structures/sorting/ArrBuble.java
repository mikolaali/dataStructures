package data_structures.sorting;
class BubbleSortApp {
    public static void main(String[] args) {
    ArrBubble arrBubble= new ArrBubble(6);
    arrBubble.insert(1);
    arrBubble.insert(22);
    arrBubble.insert(5);
    arrBubble.insert(8);
    arrBubble.insert(2);
    arrBubble.insert(33);
    arrBubble.display();
        arrBubble.bubSort();
        System.out.println("sorted by bubble sorting array: ");
        arrBubble.display();

    }
}


class ArrBubble {
    private long[] arr;
    private int ElsAmount;
    public ArrBubble(int size) {arr = new long[size];}

    public void insert(long l) {arr[ElsAmount]=l;ElsAmount++;}
    public void display() {for (long l:arr) System.out.println(l);}
    public void bubSort() {
        int out;
        for (out=ElsAmount-1;out>0;out--) {
            for (int i=0;i<out;i++) {
                if(arr[i]>arr[i+1]) {long t=arr[i+1];arr[i+1]=arr[i];arr[i]=t;}}
        }
    }

    public void bubSortRightLeft() {
        int out;
        for (out=ElsAmount-1;out>0;out--) {
            for (int i=0;i<out;i++) {
                if(arr[i]>arr[i+1]) {long t=arr[i+1];arr[i+1]=arr[i];arr[i]=t;}
            }

        }
        for (out=ElsAmount-1;out>0;out--) {
            for (int k=ElsAmount-1;k<out;k--) {
                if(arr[k]<arr[k-1]) {long t=arr[k-1];arr[k-1]=arr[k];arr[k]=t;}
            }
        }

    }
}
