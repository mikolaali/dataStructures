package nik.ch4;

public class StackCycleList {
    CycleList list;
    public StackCycleList(){
        list = new CycleList();
    }
    public void push(int data){
        list.insert(data);
    }
    public int pop() throws IndexOutOfBoundsException{
        if(isEmpty()) throw new IndexOutOfBoundsException(" Stack is EMPTY");
        Node tmp = list.delete();
        return tmp.data;
    }
    public int peek(){
        Node tmp = list.current.next;
        return tmp.data;
    }
    public void display(){
        list.display();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
}
