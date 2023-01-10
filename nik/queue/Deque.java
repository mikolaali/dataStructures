package nik.queue;
/**
 * The type Deque based on Queue class
 *
 * @param <T> the type parameter
 *  2 метода делегируют выполнение методам из Queue
 *  а 2 removeLeft и insertRight - новые
 *           переменные необходимо сделать protected, чтобы их можно было использовать в
 *           дочернем классе
 *     protected T[] queue;
 *     protected int amount; rear;front;
 */
public class Deque<T> extends Queue<T>{
    public Deque(int size) {
        super(size);
    }

    // обычный метод вставки очереди, делегируем в родительский класс
    public void insertRight(T obj){insert(obj);}

    // вставка в начало очереди
    public void insertLeft(T obj) throws IndexOutOfBoundsException {
        if(isFull()){ throw  new IndexOutOfBoundsException("Deque is FULL"); }
        amount++;
        if (front == 0) {front = queue.length - 1; queue[front] = obj; return;}
        queue[--front] = obj;
        return;
    }

    // извлеч с начала очереди (обычный метод родительского класса)
    // removeLeft = front index = Queue.remove()
    public T removeLeft() {
        return remove();
    }
    // извлеч с конца Очереди
    public T removeRight() throws IndexOutOfBoundsException {
        if (isEmpty()){ throw new IndexOutOfBoundsException("Deque is EMPTY");}
        amount--;
        if (rear == 0) {  //перематываем указатель на конец массива
            T tmp = queue[rear];
            rear = queue.length - 1;
            return tmp;
        }
        return queue[rear--];
    }

}
