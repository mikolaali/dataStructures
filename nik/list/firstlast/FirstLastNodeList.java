package nik.list.firstlast;


public class FirstLastNodeList {
    private NodeL first;
    private NodeL last;
    private long lData;

    public boolean isEmpty(){
        return first == null;
    }
    public void insertFirst(int dd){
        NodeL newNodeL = new NodeL(dd);
        if(first == null)
            last = newNodeL;
        newNodeL.next = first;
        first = newNodeL;
    }
    public void insertLast(int dd){
        NodeL newNodeL = new NodeL(dd);
        if(first == null)
            first = newNodeL;
        else
            last.next = newNodeL;
        last = newNodeL;
    }
    public long deleteFirst(){ // list must be NOT EMPTY
        long iData = first.iData;
        if(first.next == null) last = null;
        first = first.next;
        return iData;
    }
    public void displayList(){
        if(isEmpty()) return;
        NodeL current = first;
        while (current != null){
            current.displayNode();
            current = current.next;
        }
        System.out.println("");
    }
}
