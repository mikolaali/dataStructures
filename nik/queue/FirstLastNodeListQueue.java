package nik.queue;

import nik.list.firstlast.FirstLastNodeList;

public class FirstLastNodeListQueue {
    private FirstLastNodeList nodeList;
    public FirstLastNodeListQueue(){
        nodeList = new FirstLastNodeList();
    }
    public void insert(int val){
        nodeList.insertLast(val);
    }
    public int delete(){return (int) nodeList.deleteFirst();}
    public boolean isEmpty(){ return nodeList.isEmpty();}
    public void display(){nodeList.displayList();}

}
