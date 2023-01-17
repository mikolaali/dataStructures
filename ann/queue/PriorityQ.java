package ann.queue;
//Суть: при вставке упорядочиваем, но берем всегда с начала (или конца)


class PriorQApp {
    public static void main(String[] args) {
        PriorityQ queue= new PriorityQ(6);
        queue.insert(1);
        queue.insert(22);
        queue.insert(5);
        queue.insert(8);
        System.out.println("reading front: "+queue.read());
        System.out.println("getting prior (smallest) elem: "+queue.pop());
        //System.out.println("sorted by insert sorting array: ");
        System.out.println("reading smallest after popping: "+queue.read());

    }
}



public class PriorityQ {
    private long[] priorQ;
    private int size;
    int amount;

    public PriorityQ(int s) {
        priorQ = new long[s];
        size = s;
        amount = 0;
    }

    public void insert(long l) {
        int i;
        if (amount == 0) {priorQ[0] = l;}
        else {
            for (i=amount-1; i>=0; i--) {
                if (l>priorQ[i]) {priorQ[i+1] = priorQ[i];}
                else break;
            }
            priorQ[i+1] = l;
        }
        amount++;
    }

    public long pop() {
        return  priorQ[--amount];
        }  //берём с конца

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
