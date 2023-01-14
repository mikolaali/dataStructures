package nik.ch4;

import nik.list.sortedlist.SortedList;

public class PQueueSortedList {
    private SortedList list;

    public PQueueSortedList() {
        list = new SortedList();
    }

    public void insert(int data){
        list.insert(data);
    }
    public int remove(){
        return list.remove().data;
    }
    public void display(){
        list.display();
    }

}
