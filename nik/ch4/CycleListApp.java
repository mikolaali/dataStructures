package nik.ch4;

public class CycleListApp {
    public static void main(String[] args) {
        CycleList list = new CycleList();
        list.display();
        list.insert(11);
        list.insert(22);
        list.insert(33);
        list.insert(44);
        list.display();

        list.delete();
        list.display();

        System.out.println(list.find(33).data);
        list.current.displayNode();
        System.out.println("");
        list.next();
        System.out.println(list.getCurrent().data);
        list.next();
        System.out.println(list.getCurrent().data);
    }
}
