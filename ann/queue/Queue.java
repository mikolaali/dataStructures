package ann.queue;

public class Queue<T> {
    protected T[] Q;
    protected int amount;
    protected int rear;
    protected int front;

    public Queue(int size) {
        Q = (T[]) new Object[size];
        amount = 0;
        rear = -1;
        front = 0;
    }

    public void insert(T obj) throws IndexOutOfBoundsException{
        if(isFull()) throw new IndexOutOfBoundsException("Q is full");
        if(rear == Q.length - 1) rear = -1;
        Q[++rear] = obj;
        amount++;
    }

    public T pop() {
        if(isEmpty()) throw new IndexOutOfBoundsException("Queue is EMPTY");
        T t = Q[front];
        amount--;
        if(front == Q.length - 1) {front = 0; return t;}
        front++;
        return t;
    }

    public boolean isEmpty() {return amount == 0;}

    public boolean isFull() {return amount == Q.length - 1;}

    public int size() {return amount;}

}
