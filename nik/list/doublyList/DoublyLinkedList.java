package nik.list.doublyList;

public class DoublyLinkedList {
    private Node first;
    private Node last;

    public boolean isEmpty(){
        return first == null;
    }

    public void insertFirst(int data){
        Node newNode = new Node(data);
        if(last == null)
            last = newNode;
        else
            first.previous = newNode;
        newNode.next = first;
        first = newNode;
    }

    public void insertLast(int data){
        Node newNode = new Node(data);
        if(first == null)
            first = newNode;
        else {
            last.next = newNode;
            newNode.previous = last;
        }
        last = newNode;
    }

    public Node deleteFirst(){
        Node tmp = first;
        if(first.next == null)
            last = null;
        else
            first.next.previous = null;
        first = first.next;
        return tmp;
    }

    public Node deleteLast(){
        Node tmp = last;
        if(first.next == null)
            first = null;
        else
            last.previous.next = null;
        last = last.previous;
        return tmp;
    }
    // dd after key
    public boolean insertAfter(int key, int dd){
        Node current = first;
        while (current.data != key){
            if(current == null) return false;
            current = current.next;
        }
        // элемент найден
        Node newNode = new Node(dd);
        if(current == last){
            newNode.next = null;
            last = newNode;
        }else {
            newNode.next = current.next;
            current.next.previous = newNode;
        }
        newNode.previous = current;
        current.next = newNode;
        return true;
    }

    public Node deleteKey(int key){
        Node current = first;
        while (current.data != key){
            if(current == null) return null;
            current = current.next;
        }
        if(current == first) {
            first = first.next;
            first.previous = null;
        } else
            current.previous.next = current.next;


        if (current == last) {
            last.previous.next = null;
            last = last.previous;
        } else {
            current.next.previous = current.previous;
        }
        return current;
    }

    void displayForward(){
        Node current = first;
        while (current != null){
            current.display();
            current = current.next;
        }
    }

    void displayBackward(){
        Node current = last;
        while (current != null){
            current.display();
            current = current.previous;
        }
    }


}
