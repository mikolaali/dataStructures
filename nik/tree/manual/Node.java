package nik.tree.manual;

public class Node {
    public int data;
    public int amount;
    public Node left;
    public Node right;
    public Node(int key){
        data = key;
        amount = 1;
    }
    public void display(){
        System.out.print("{ " + data + " }" );
    }
}
