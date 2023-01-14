package ann.queue;
/**
 * Is based on Queue
 * 2 метода делегируют выполнение Queue, а removeLeft и insertRight - новые
 *           переменные protected, чтобы их можно было использовать в дочернем кл
 *     protected T[] queue; protected int amount; rear;front;
 */


public class Deque<T> extends Queue<T>{
    public Deque(int size) {super(size);}

    public T removeLeft() {return pop();}

    public T removeRight()  throws IndexOutOfBoundsException {
        if(isEmpty()) throw new IndexOutOfBoundsException("Queue is EMPTY");
        T t = Q[rear--];
        if(rear == -1) {rear = Q.length-1;}
        amount--;
        return t;
    }

    public void insertLeft(T obj)  throws IndexOutOfBoundsException {
        if(isFull()) throw new IndexOutOfBoundsException("Q is full");
        if(front == 0) front = Q.length;
        Q[--front] = obj;
        amount++;
    }

    public void insertRight(T obj) {insert(obj);}

}
