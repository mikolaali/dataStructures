package data_structures.queue;
class PriorQFastInsertApp {
    public static void main(String[] args) {
        PriorQFastInsert queue= new PriorQFastInsert(6);
        queue.insert(1);
        queue.insert(22);
        queue.insert(5);
        queue.insert(8);
        System.out.println("reading front: "+queue.read());
        System.out.println("getting prior: "+queue.pop());
        //System.out.println("sorted by insert sorting array: ");
        System.out.println("reading front: "+queue.read());

    }
}


public class PriorQFastInsert {
    private long[] priorQ;
    private int size;
    int amount;

    public PriorQFastInsert(int s) {
        priorQ = new long[s];
        size = s;
        amount = 0;
    }

    public void insert(long l) {
        priorQ[amount++] = l;
    }

    public long pop() {
        long t = priorQ[0];
        int ind = 0;
        for (int i=1;i<amount;i++) {
            if (priorQ[i]<t) {t = priorQ[i]; ind=i;}
        }
        for (int k=ind;k<amount;k++) {priorQ[k]=priorQ[k+1];}
        amount--;
        return t;
    }

    public long read() {
        return priorQ[amount-1];
    }
    public boolean isFull() {
        return amount==size;
    }
    public boolean isEmpty() {
        return amount==0;
    }


}
