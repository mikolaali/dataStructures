package nik.list;

public class NodeList {
    private Node first;

    public boolean isEmpty(){
        return (first == null);
    }

    public void insertFirst(int id, double dd){
        Node newNode = new Node(id, dd);
        newNode.next = first;
        first = newNode;
    }
    //list != null, check before call
    public Node deleteFirst(){
//        if(isEmpty()) return null;
        Node tmp = first;
        first = first.next;
        return tmp;
    }
    public void displayList(){
        Node current = first;
        while(current != null) {
            current.displayNode();
            current = current.next;
        }
    }
    public Node find(int key){
        Node node = first;
        while (node.iData != key){
            if(node.next == null) return null;
            else node = node.next;
        }
        return node;
    }
    public Node delete(int key){
        Node current = first;
        Node previous = first;
        while (current.iData != key){
            if(current.next == null) return null;
            else {
                previous = current;
                current = current.next;
            }
        }
        if(current == first) first = first.next;
        else previous.next = current.next;
        return current;
    }
}
