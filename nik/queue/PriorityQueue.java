package nik.queue;

import java.util.Random;

public class PriorityQueue {
    private int[] queue;
    private int amount;
    private int front;
    public PriorityQueue(int size){
        queue = new int[size];
        amount = 0; front = 0;
    }
    public void init(int amount){
        Random rnd = new Random();
        for (int i = 0; i < amount; i++) {
            if(isFull()) {
                System.out.println("Priority queue is FULL");
                return;
            }
            insert2(rnd.nextInt(30));
        }
    }

    public void insert(int obj){
        if(isFull()) {
            System.out.println("Priority queue is FULL");
            return;
        }
        if(amount == 0) {
            queue[front] = obj;
            amount++;
            return;
        }
//        int tmp = queue[front];
        int j;
        for(j = amount - 1; j >= 0 ; j-- ){
            if(obj > queue[j]){
                queue[j+1] = queue[j];
            } else break;
        }
        queue[j+1] = obj; // j+1 т.к. в цикле перед break выполнится j--, хотя это уже лишнее.
        front++; amount++;
    }

    public void insert2(int obj){
        if(isFull()) {
            System.out.println("Queue is FULL");
            return;
        }
        if(amount == 0 )
        {
            queue[amount++] = obj;
        }
        else {
            int j;
            for(j = amount - 1; j >= 0; j--){
                if(obj > queue[j]){
                    queue[j+1] = queue[j];
                }else break;
            }
            queue[j+1] = obj;
            amount++;
        }

    }
    public int remove2() throws NegativeArraySizeException {
        if(amount == 0) throw new NegativeArraySizeException("Array is EMPTY");
        return queue[--amount];
    }
    public int remove() throws IndexOutOfBoundsException {
        if(isEmpty()) throw new IndexOutOfBoundsException("Priority queue is EMPTY");
        amount--;
        return queue[front--];
    }

    public boolean isFull() {
        return (amount == queue.length );
    }
    public boolean isEmpty() {
        return (amount == 0);
    }
}
