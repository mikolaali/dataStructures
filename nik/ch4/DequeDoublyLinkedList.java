package nik.ch4;

import nik.list.doublyList.DoublyLinkedList;

public class DequeDoublyLinkedList {
    DoublyLinkedList list;

    public DequeDoublyLinkedList() {
        list = new DoublyLinkedList();
    }

    public void insertFirst(int data){
        list.insertFirst(data);
    }
    public void insertLast(int data){
        list.insertLast(data);
    }
    public int removeFirst(){
        return list.deleteFirst().data;
    }
    public int removeLast(){
        return list.deleteLast().data;
    }
    public void display(){
        list.displayForward();
    }
}
