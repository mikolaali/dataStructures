package nik.stack;

import java.lang.reflect.Array;

public class Stack<T> {
    private T[] stack;
    private int top;
    public Stack(Class<T> clazz,int max){
        stack = (T[]) Array.newInstance(clazz, max);
        top = -1;
    }
    public void push(T val){
        if(top < stack.length - 1){
            stack[++top] = val;
        } else System.out.println("Not enough memory in stack");
    }
    public T pop(){
        return stack[top--];
    }
    public T peek(){
        return stack[top];
    }
    public boolean isEmpty(){
       return (top == -1);
    }
    public boolean isFull(){
        return ( top == stack.length - 1);
    }

}
