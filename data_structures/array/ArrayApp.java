package data_structures.array;

public class ArrayApp {
    public static void main(String[] args) {
        HighArray arr = new HighArray(6);
        arr.insertEl(77);
        arr.insertEl(22);
        arr.insertEl(11);
        arr.insertEl(11);
        arr.insertEl(55);
        arr.insertEl(55);

        System.out.println("deleted 22: ");
        arr.deleteEl(22);
        arr.displayArr();


        System.out.println("Dis is max: "+arr.getMax());
        //System.out.println("Removing max: "+arr.removeMax());

        arr.noDups(); System.out.println("Removed duplicates, now array is: ");
        arr.displayArr();
        long[] sortedArr= new long[arr.ElsAmount];
        for (int i= arr.ElsAmount-1;i>=0;i--) {
            sortedArr[i]=arr.removeMax();
        }

        System.out.println("Sorted array: ");
        for (long l:sortedArr) {
            System.out.println(l);
        }

    }
}


class HighArray {
    private long[] a; int ElsAmount = 0;
    public HighArray(int size) {a = new long[size];}

    public void displayArr() {for (long l:a) {System.out.println(l);}}

                        //Поиск
    public boolean findEl(long val) {
        for (long lo:a) {
            if(lo==val){return true;}
        }
        return false;}

    public void insertEl(long val) {a[ElsAmount]=val;ElsAmount++;}

                           //Удаление
    public boolean deleteEl(long val) {
        int j; for (j=0; j<ElsAmount;j++) {
            if (a[j]==val)
                break;}
        if(j==ElsAmount) {return false;}
        else {int k; for (k=j;k<ElsAmount-1;k++) {a[k]=a[k+1];} a[ElsAmount-1]=0; ElsAmount--;return true;}
    }
                  //Найти максимальное значение
    public long getMax() {
        long max=a[0]; if(max==0) {return -1;}
        for (int i=1;i<ElsAmount;i++) {
            if(a[i]>max){max=a[i];}
        }
        return max;
    }

                //Удалить максимальное значение
    public long removeMax() {
        long max = getMax();
        deleteEl(max);
        return max;
    }


    public void noDups() {
        for (int i=0;i<ElsAmount;i++) {
            long l=a[i]; for (int k=i+1;k<ElsAmount;k++) {
                if(l==a[k]) {deleteEl(l);}
            }
        }
    }

    }
