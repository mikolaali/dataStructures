package nik.list.doublyList;

public class Node {
    public int data;
    Node next;
    Node previous;
    public Node(int data){
        this.data = data;
    }
    public void display(){
        System.out.print(data + " ");
    }
}
