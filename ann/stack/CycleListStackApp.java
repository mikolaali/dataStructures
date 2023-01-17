package ann.stack;

public class CycleListStackApp {
    public static void main(String[] args) {
        CycleListStack cycleListStack = new CycleListStack();
        cycleListStack.push(22);
        cycleListStack.push(77);
        cycleListStack.push(44);
        cycleListStack.push(99);
        System.out.println(cycleListStack.pop().dataI);
        // читаем вершину:
        System.out.println(cycleListStack.read().dataI);
    }
}
