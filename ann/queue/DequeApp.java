package ann.queue;
import java.util.Random;


public class DequeApp {
    public static void main(String[] args) {
        Deque<Integer> deQ = new Deque<>(10);

        fill(deQ, 5);
        // выводим с конца
        System.out.println("\nRemoving from Right:");
        while (!deQ.isEmpty()) {
            System.out.print(deQ.removeRight()+" -- ");
        }

        System.out.println("\nFilling again:");
        fill(deQ, 5);
        // выводим с головы
        System.out.println("\nRemoving from Left:");
        while (!deQ.isEmpty()) {
            System.out.print(deQ.removeLeft()+" -- ");
        }
        // добавляем неск элементов в начало очереди
        System.out.println("\nFilling again:");
        fill(deQ, 5);
        deQ.insertLeft(33);
        deQ.insertLeft(34);
        deQ.insertLeft(35);
        //deQ.display();
        System.out.println("\nRemoving 8 nums:");
        while (!deQ.isEmpty()) {
            System.out.print(deQ.removeLeft() + " --- ");
        }
    }

    public static void fill(Deque deQ, int size){
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            int t = rand.nextInt(10);
            deQ.insert(t);
            System.out.print(t + " -- ");
        }
    }
}
