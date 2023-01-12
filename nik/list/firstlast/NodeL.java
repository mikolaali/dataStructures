package nik.list.firstlast;

public class NodeL {
    private long iData;
    private NodeL next;
    public NodeL(long obj){
        iData = obj;
    }
    public void displayNode(){
        System.out.println(iData);
    }
}
