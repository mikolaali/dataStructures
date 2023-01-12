package nik.list.firstlast;

public class FirstLastNodeListApp {
    public static void main(String[] args) {
        FirstLastNodeList nodeList = new FirstLastNodeList();
        // insert from HEAD
        nodeList.insertFirst(11);
        nodeList.insertFirst(22);
        nodeList.insertFirst(33);
        // insert from TAIL
        nodeList.insertLast(44);
        nodeList.insertLast(55);
        nodeList.insertLast(66);

        nodeList.displayList();
        // delete from HEAD
        nodeList.deleteFirst();
        nodeList.deleteFirst();
        nodeList.deleteFirst();

        nodeList.displayList();
    }
}
