package nik.list.listinsertionsort;

public class SortedList {
    private Node first;

    public SortedList(Node[] arr){
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }
    public void insert(Node node){
        Node current = first;
        Node privious = null;
        while (current != null && node.data > current.data){
            privious = current;
            current = current.next;
        }
        if(privious == null){
            first = node;
        } else
            privious.next = node;
        node.next = current;
    }
    public Node remove(){
        Node tmp = first;
        first = first.next;
        return tmp;
    }
    public void display(){
        Node current = first;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return first == null;
    }
}
