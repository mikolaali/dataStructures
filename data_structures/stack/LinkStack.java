package data_structures.stack;
class LinkQApp {
    public static void main(String[] args) {
        LinkStack stack= new LinkStack();
        stack.insert(1);
        stack.insert(22);
        stack.insert(5);
        stack.insert(8);
        stack.display();
        System.out.println("getting first elem... "); stack.pop();
        //System.out.println("sorted by insert sorting array: ");
        stack.display();

    }
}

public class LinkStack {
    LinkedList linkedList;
    public LinkStack() {linkedList = new LinkedList();}
    public void insert(int i) {linkedList.insertFirst(i);}
    public Link pop() {return linkedList.popFirst();}
    public void display() {linkedList.display();}
}

class LinkedList {
    Link first;
    public LinkedList() {first = null;}

    public void insertFirst(int i) {
        Link newLink = new Link(i);
        newLink.next = first;
        first = newLink;
    }
    public Link popFirst() {Link t = first; first = first.next; return t;}
    public boolean isEmpty() {return first==null;}
    public void display() {
        if (first==null) {System.out.println("empty"); return;}
        Link curr= first;
        while (curr!=null) {curr.displayLink();curr=curr.next;}
    }
}



class Link {
    Link next;
    int dataI;
    public Link(int dataI) {
        this.dataI = dataI;
    }
    public void displayLink() {
        System.out.println(dataI);
    }
}