package nik.list.iterator;

public class ListIterator {
    private LinkList list;
    private Node previous;
    private  Node current;

    public ListIterator(LinkList list) {
        this.list = list;
        reset();
    }

    public void reset() {
        current = list.getFirst();
        previous = null;
    }

    public boolean atEnd(){
        return current.next == null;
    }
    public void nextNode(){
        previous = current;
        current = current.next;
    }
    public Node getCurrent(){
        return current;
    }
    // insert after current Node
    public void insertAfter(int data){
        Node newNode = new Node(data);
        if(list.isEmpty()) {
            list.setFirst(newNode);
            current = newNode;
        } else {
            newNode.next = current.next;
            current.next = newNode;
            nextNode();
        }
    }
    public void insertBefore(int data){
        Node newNode = new Node(data);
        if(previous == null){   // first or empty
            newNode.next = current;
            list.setFirst(newNode);
            reset();
        } else {
            newNode.next = current;
            previous.next = newNode;
            current = newNode;
        }
    }
    public int deleteCurrent(){
        int val = current.data;
        if(previous == null ){
            current = current.next;
            return val;
        } else {
            previous.next = current.next;
            if(atEnd()) reset();
            else
                current = current.next;
            return val;
        }
    }


}
