package nik.stack;

public class NodeListStackApp {
    public static void main(String[] args) {
        NodeListStack stack = new NodeListStack();
        stack.push(32);
        stack.push(13);
        stack.push(41);
        stack.push(23);

        stack.display();

        stack.pop();
        stack.pop();

        stack.display();
    }
}
