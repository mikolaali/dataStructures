package nik.tree;

public class Node {
    public Node(int data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    int data;
    Node left;
    Node right;
}
