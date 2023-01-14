package nik.ch4;

public class Node {
    public boolean curFlag;
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        curFlag = false;
    }
    public void displayNode(){
        System.out.print(data + " ");
    }
    public void flagOff(){
        curFlag = false;
    }
    public void flagOn(){curFlag = true;}

}
