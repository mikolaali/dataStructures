package data_structures.array;
import java.lang.reflect.Array;
import java.util.Random;
class Main {
    public static void main(String[]args){
    OrderArr orderArr = new OrderArr(7);
    orderArr.insert(11);
    orderArr.insert(33);
    orderArr.insert(22);
    orderArr.insert(5);
    orderArr.insert(44);
    orderArr.displayArr();
    System.out.println("Els amount: "+orderArr.ElsAmount);
    System.out.println("Searched el is at position: "+orderArr.find(11));
        //System.out.println(orderArr.find(33));
        //System.out.println(orderArr.find(133));
        orderArr.delete(33);
        orderArr.displayArr();

        long[] arr1 = createArr(8);
        long[] arr2 = createArr(2);
        System.out.println("Merged array: ");
        orderArr.merge(arr1,arr2);
    }
    private static long[] createArr(int size) {
        long[] a = new long[size];
        Random rand = new Random();
        for (int i=0;i<size;i++) {
            a[i]=rand.nextInt((100 - 1) + 1)+1;
        }        //Сортинг
        int rBound=size;
        for (int k=1;k<size-1;k++) {
        for (int i=0;i<rBound-1;i++) {
            if (a[i]>a[i+1]) {long c=a[i+1]; a[i+1]=a[i];a[i]=c;}
        } rBound--;}
        return a;
    }

}


class OrderArr {
    private final long[] arr;
    int ElsAmount = 0;
    public OrderArr(int size) {arr=new long[size];}

                          //Вставка двоичная
    public void insert(long val) {
        int UppBound = ElsAmount-1;
        int LowBound=0;
        int CurrI=ElsAmount-1;
        if(arr[0]>val) {for (int k=ElsAmount;k>0;k--){arr[k]=arr[k-1];} arr[0]=val;}
        else if(arr[0]==0 || arr[ElsAmount-1]<val) {arr[ElsAmount]=val; }
        else {while (LowBound < UppBound) {
            CurrI = (LowBound + UppBound) / 2;
            if (arr[CurrI] <= val && val <= arr[CurrI+1]) {
                for (int k=ElsAmount;k>CurrI+1;k--){arr[k]=arr[k-1];} arr[CurrI+1]=val; ElsAmount++;
                return;
            } else if (val > arr[CurrI]) {
                LowBound = CurrI + 1;} else {
                UppBound = CurrI - 1;}
        }
       }
        //int i;
        //int k = find(val);
        //for (i=0;i<ElsAmount;i++) {if(val<arr[i]) break;}
        //for (k=ElsAmount;k>i;k--){arr[k]=arr[k-1];}
        //arr[i] = val;
    ElsAmount++;
    }
                           //Поиск
    public int find(long val) {
        int UppBound = ElsAmount-1;
        int LowBound=0;
        int CurrI;
        while (LowBound <= UppBound) {
            CurrI = (LowBound + UppBound) / 2;
            if (val == arr[CurrI]) {
                return CurrI;
            } else if (val > arr[CurrI]) {
                LowBound = CurrI + 1;} else {
                UppBound = CurrI - 1;}
            }
    return ElsAmount;}

                              //Удаление двоичное
    public void delete(long val) {
        int i=find(val);
        if (i==ElsAmount) System.out.println("no such value");
        else {for (int k=i;k<ElsAmount-1;k++) {
            arr[k]=arr[k+1];}
        arr[ElsAmount-1]=0; ElsAmount--;}
    }


                         //Слияние массивов = задание полная херня, то, как они пишут, не будет работать
    public void merge(long[] a1, long[] a2) {
    long[] mergedArr = new long[a1.length + a2.length];
    int smallerLength = Math.min(a1.length, a2.length);
    long[] bigger = (a1.length > a2.length) ? a1 : a2;
    int i;
    for (i=0;i<smallerLength;i++) {
        if (a1[i]<a2[i]) {mergedArr[i]=a1[i];}
        else {mergedArr[i]=a2[i];}
    }
    for (int k=i;k<bigger.length;k++) {mergedArr[k]=bigger[k];}
        for (long l:mergedArr) {
            System.out.println(l);
        }
    }



    public void displayArr() {for (long l:arr) {System.out.println(l);}}
}


