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
        T t = Q[front++];
        if(front == Q.length) {front = 0;}
        amount--;
        return t;
    }

    public boolean isEmpty() {return amount == 0;}

    public boolean isFull() {return amount == Q.length - 1;}

    public int size() {return amount;}

    //нужен метод??
    public void display() {
        if (amount == 0) {
            System.out.println("dat shit is empty");
        }
        else if (front==rear) {
            System.out.println(Q[front]);
        }
        else if (front > rear) {    //Для цикличного
            for (int i=front;i<amount;i++) {
                System.out.println(Q[i]);
            }
            for (int k=0;k<front;k++) {
                System.out.println(Q[k]);
            }
        }
        else {int t = front; for (int i=front;i<amount+t;i++) {
            System.out.println(Q[i]);
        }}
    }
//??
    public T read() {
        return Q[front];
    }
}
