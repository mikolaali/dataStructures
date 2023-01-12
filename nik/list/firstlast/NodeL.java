package nik.list.firstlast;

public class NodeL {
    public long iData;
    public NodeL next;
    public NodeL(long obj){
        iData = obj;
    }
    public void displayNode(){
        System.out.println(iData);
    }
}
