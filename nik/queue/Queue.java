package nik.queue;

public class Queue<T> {
    protected T[] queue;
    protected int amount;
    protected int rear;
    protected int front;
    public Queue(int size) {
        queue = (T[]) new Object[size];
        amount = 0;
        rear = -1;
        front = 0;
    }
    public void insert(T obj) throws IndexOutOfBoundsException {
        if(isFull()) throw new IndexOutOfBoundsException("Queue is FULL");

        if(rear == queue.length - 1) rear = -1;
        queue[++rear] = obj;
        amount++;
    }
    public T remove(){
        if(isEmpty()) throw new IndexOutOfBoundsException("Queue is EMPTY");

        T tmp = queue[front];
        if(front == queue.length - 1) {front = 0; return tmp;}
        front++;
        amount--;
        return tmp;
    }
    public int size(){ return amount; }
//    public int limit(){return queue.length;}
    public boolean isEmpty(){
        if(amount == 0 ) return true;
        else return false;
    }
    public boolean isFull(){
        if( amount == queue.length ) return true;
        else return false;
    }

}
