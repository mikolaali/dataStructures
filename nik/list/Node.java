package nik.list;

public class Node {
    public int iData;
    public double dData;
    public Node next = null;
    public Node(int id, double dd){
        iData = id;
        dData = dd;
    }
    public void displayNode(){
        System.out.println( "{ " + iData + ", " + dData + "}" );
    }
}
