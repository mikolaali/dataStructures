package nik.queue;

import java.util.Random;

public class QueueApp {
    public static void main(String[] args) throws Exception{
    Random rnd = new Random();
    Queue<Integer> queue = new Queue(10);
    int val;
    for (int i = 0; i < 11; i++) {
        val =  rnd.nextInt(100);
        System.out.print( val + " --- ");
        queue.insert(val);
    }
    System.out.println("");
    while (!queue.isEmpty()){
        System.out.print(queue.remove() + " === ");
    }
        System.out.println(queue.remove());
    }
}
