package nik.tree.hafman;

public class Node {
    public char data;
    public int amount;
    public Node left;
    public Node right;

    public Node(char data) {
        this.data = data;
        amount = 1;
    }
    public Node(){
        amount = 0;
        data = 0;
    }
    public void incAmount(){
        ++amount;
    }
    public void display(){
        System.out.print(data + " ");
    }
}
