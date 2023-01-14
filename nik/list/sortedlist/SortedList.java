package nik.list.sortedlist;

public class SortedList {
    private Node first;

    public void insert(int dd){
        Node newNode = new Node(dd);
        Node current = first;
        Node previous = null;
        while (current != null && dd > current.data){
            previous = current;
            current = current.next;
        }
        if(previous == null)
            first = newNode;
        else
            previous.next = newNode;
        newNode.next = current;
    }

    public Node remove(){
        Node tmp = first;
        first = first.next;
        return tmp;
    }

    public boolean isEmpty(){
        return first == null;
    }

    public void display(){
        Node node = first;
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }
    }
}
