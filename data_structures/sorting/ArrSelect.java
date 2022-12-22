package data_structures.sorting;
class SelectSortApp {
    public static void main(String[] args) {
        ArrSelect arr= new ArrSelect(6);
        arr.insert(1);
        arr.insert(22);
        arr.insert(5);
        arr.insert(8);
        arr.insert(2);
        arr.insert(33);
        arr.display();
        arr.selectSort();
        System.out.println("sorted by select sorting array: ");
        arr.display();

    }
}



class ArrSelect {
    private long[] arr;
    private int ElsAmount;
    public ArrSelect(int size) {arr = new long[size];}

    public void insert(long l) {arr[ElsAmount]=l;ElsAmount++;}
    public void display() {for (long l:arr) System.out.println(l);}

    public void selectSort() {
        //int out;
        for (int out=0;out<ElsAmount-1;out++) {
            long min = arr[out];
            int minI = out;
            for (int i=out+1;i<ElsAmount;i++) {
                if(min>arr[i]) {min=arr[i]; minI=i;}
            }
            long t = arr[out];
            arr[out] = min;
            arr[minI] = t;
        }
    }
}
