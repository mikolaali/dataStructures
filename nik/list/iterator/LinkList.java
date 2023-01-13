package nik.list.iterator;

public class LinkList {
    private Node first;

    public Node getFirst(){
        return first;
    }
    public void setFirst(Node node){
        first = node;
    }
    public boolean isEmpty(){
        return first == null;
    }
    public ListIterator getIterator(){
        return new ListIterator(this);
    }
    public void displayList(){
        if(first == null) return;
        Node current = first;
        while (current != null){
            current.display();
            current  = current.next;
        }
        System.out.println("");
    }
}
