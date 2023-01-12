package nik.list;

public class NodeListApp {
    public static void main(String[] args) {
        NodeList list = new NodeList();
        list.insertFirst(3, 32.23);
        list.insertFirst(4, 32.243);
        list.insertFirst(5, 32.554);
        list.displayList();
        while (!list.isEmpty()){
            Node node = list.deleteFirst();
            node.displayNode();
        }
        list.displayList();

        System.out.println("==================");
        NodeList theList = new NodeList();  // Создание нового списка
        theList.insertFirst(22, 2.99);
        theList.insertFirst(44, 4.99);
        theList.insertFirst(66, 6.99);
        theList.insertFirst(88, 8.99);
        theList.displayList();
        Node f = theList.find(44);
        if( f != null)
// Вставка 4 элементов
// Вывод содержимого списка
// Поиск элемента
            System.out.println("Found link with key " + f.iData);
        else
            System.out.println("Can’t find link");
        Node d = theList.delete(66);        // Удаление элемента
        if( d != null )
            System.out.println("Deleted link with key " + d.iData);
        else
            System.out.println("Can’t delete link");
        theList.displayList();              // Вывод содержимого списка
    }

}
