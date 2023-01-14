package nik.ch4;

public class StackCycleListApp {
    public static void main(String[] args) {
        StackCycleList stack = new StackCycleList();
        stack.push(10);
        stack.push(11);
        stack.push(22);
        stack.push(33);
        stack.display();
        System.out.println("1: " + stack.pop());
        stack.display();
        System.out.println("2: " + stack.peek());
        System.out.println("2: " + stack.pop());
        stack.display();
        System.out.println("3: " + stack.pop());
        stack.display();
        System.out.println("4: " + stack.pop());
        stack.display();
        System.out.println("5: " + stack.pop());
        stack.display();

    }
}
