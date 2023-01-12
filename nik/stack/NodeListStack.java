package nik.stack;

import nik.list.firstlast.FirstLastNodeList;

public class NodeListStack {
    FirstLastNodeList nodeList;
    public NodeListStack(){
        nodeList = new FirstLastNodeList();
    }
    public void push(int dd){
        nodeList.insertFirst(dd);
    }
    public long pop(){
        return nodeList.deleteFirst();
    }
    public boolean isEmpty(){
        return nodeList.isEmpty();
    }
    public void display(){
        nodeList.displayList();
    }
}
