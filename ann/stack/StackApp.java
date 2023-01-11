package ann.stack;

import nik.stack.Stack;

import java.util.Random;

public class StackApp {
    public static void main(String[] args) {
        //ЗАПОЛНЕНИЕ СТЕКА И ВЫВОД
        StackA<Integer> stackA = new StackA<>(10);
        Random rand = new Random();
        for (int i=0; i<10; i++) {
            stackA.push(rand.nextInt(99));
        }
        while (!stackA.isEmpty()){
            System.out.print(stackA.pop() + " - ");
        }
        System.out.println("");
        stackA = null;



    }

}
