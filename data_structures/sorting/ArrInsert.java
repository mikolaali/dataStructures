package data_structures.sorting;
class InsertSortApp {
    public static void main(String[] args) {
        ArrInsert arr= new ArrInsert(6);
        arr.insert(1);
        arr.insert(22);
        arr.insert(5);
        arr.insert(8);
        arr.insert(2);
        arr.insert(33);
        arr.display();
        arr.insertSort();
        System.out.println("sorted by insert sorting array: ");
        arr.display();

    }
}


public class ArrInsert {
    private long[] arr;
    private int ElsAmount;
    public ArrInsert(int size) {arr = new long[size];}

    public void insert(long l) {arr[ElsAmount]=l;ElsAmount++;}
    public void display() {for (long l:arr) System.out.println(l);}

    public void insertSort() {
        for (int out=1;out<ElsAmount;out++) {
            long temp = arr[out];
            int i = out;
           while (i>0 && temp<=arr[i-1]) {
               arr[i] = arr[i-1]; i--;
           }
            arr[i] = temp;

        }
    }
                        //Медиана массива
    public long median() {
        insertSort(); if (ElsAmount % 2 == 1)
        return (arr[ElsAmount/2 - 1] + arr[ElsAmount/2]) / 2;
    else
        return arr[(int)ElsAmount/2];
    }

}
