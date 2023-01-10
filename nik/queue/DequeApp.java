package nik.queue;

import java.util.Random;

public class DequeApp {
    public static void main(String[] args) {
        Random rnd = new Random();
        Deque<Integer> deque = new Deque<Integer>(10);

        // 1. выводим с конца очереди - получаем реверс
        System.out.println("выводим с конца очереди - получаем реверс");
        init(deque, 5);
        System.out.print(" - это последовательность при init()\n");
        while (!deque.isEmpty()) {
            System.out.print(deque.removeRight() + " --- ");
        }
        System.out.println("");

        // 2. выводим с головы очереди - получаем такую же последовательность - FIFO
        System.out.println("выводим с головы очереди - получаем такую же последовательность - FIFO");
        init(deque,5);
        System.out.print(" - это последовательность при init()\n");
        while (!deque.isEmpty()) {
            System.out.print(deque.removeLeft() + " --- ");
        }

        // 3. добавляем несколько элементов в начало очереди(по принципу стэка работает)
        //  соответственно эти три элемента должны появиться первыми
        System.out.println("\n выводим - FIFO");
        init(deque,5);
        System.out.print("\nInserted: ");
        for (int i = 0; i < 3; i++) {
            int a = rnd.nextInt(20);
            deque.insertLeft(a);
            System.out.print(a + " ");
        }
        System.out.println("");
        while (!deque.isEmpty()) {
            System.out.print(deque.removeLeft() + " --- ");
        }




    }

    /**
     * Init. принимает экзэмпляр Deque и количество элементов для инициализации
     * инициализирует Integer
     * @param deque  the deque
     * @param amount the amount
     */
    public static void init(Deque deque, int amount){
        Random rnd = new Random();
//            Deque<Integer> deque = new Deque<Integer>(10);
        for (int i = 0; i < amount; i++) {
            int a = rnd.nextInt(10);
            deque.insert(a);
            System.out.print(a + " --- ");
        }
//        System.out.println("");
    }

}
