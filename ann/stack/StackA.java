package ann.stack;

import java.lang.reflect.Array;

public class StackA<T> {
    private T[] stack;
    private int top;

    public StackA(int max){
        stack = (T[]) new Object[max];
        top = -1;
    }

    public void push(T val) {
        if(top<stack.length-1) {stack[++top] = val;}
        else System.out.println("Stack is full");
    }

    public T pop() {return stack[top--];}

    public T read() {return stack[top];}

    public boolean isEmpty() {return (top == -1);}

    public boolean isFull() {return top == stack.length-1;}

}
