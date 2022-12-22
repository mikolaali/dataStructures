package data_structures.queue;
class Main {
    public static void main(String[] args) {
        Queue queue= new Queue(4);
        queue.insert(1);
        queue.insert(22);
        queue.insert(5);
        queue.insert(8);
        System.out.println("reading first: "+queue.read());
        System.out.println("removing first: "+queue.pop());
        //System.out.println("sorted by insert sorting array: ");
        System.out.println("reading first: "+queue.read());
        queue.insert(34);
        //queue.insert(35);
        System.out.println("Displaying the whole queue: ");
        queue.display();
    }
}



class Queue {               //Цикличная очередь
    int size;
    long[] queue;
    int ElsAmount;
    int front;
    int rear;
    public Queue(int q) {
        size = q;
        queue = new long[q];
        ElsAmount = 0;
        front = 0;
        rear = -1;
    }

    public void insert(long l) {
        if (rear==size-1) {rear=-1;}
        queue[++rear]=l;
        ElsAmount++;
    }

    public long pop() {
        long t = queue[front++]; if (front==size) {front=0;}
        ElsAmount--;
        return t;}

    public long read() {
        return queue[front];
    }
    public boolean isFull() {
        return size == ElsAmount;
    }
    public boolean isEmpty() {
        return ElsAmount == 0;
    }

    public int size() {
        return ElsAmount;
    }

    public void display() {
        if (ElsAmount == 0) {
            System.out.println("its empty");
        }
        else if (front==rear) {
            System.out.println(queue[front]);
        }
        else if (front > rear) {    //Для цикличного
            for (int i=front;i<ElsAmount;i++) {
                System.out.println(queue[i]);
            }
            for (int k=0;k<front;k++) {
                System.out.println(queue[k]);
            }
        }
        else {int t = front; for (int i=front;i<ElsAmount+t;i++) {
            System.out.println(queue[i]);
        }}
    }


}
