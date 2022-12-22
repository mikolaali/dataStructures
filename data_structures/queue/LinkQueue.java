package data_structures.queue;
class LinkQApp {
    public static void main(String[] args) {
        LinkQueue queue= new LinkQueue();
        queue.insert(1);
        queue.insert(22);
        queue.insert(5);
        queue.insert(8);
        queue.displayQ();
        System.out.println("getting first elem... "); queue.pop();
        //System.out.println("sorted by insert sorting array: ");
        queue.displayQ();

    }
}



public class LinkQueue {
    FirstLastList list;
    public LinkQueue() {
        list = new FirstLastList();
    }
    public void insert(int i) {
        list.insertLast(i);
    }
    public Link pop() {
        return list.popFirst();
    }
    public void displayQ() {
        System.out.println("The Queue (front-->rear): ");list.display();
    }
    public boolean isEmpty() {return list.isEmpty();}
}


class FirstLastList {
    Link first;
    Link last;

    public FirstLastList() {
        first = null;
        last = null;
    }

    public void insertLast(int i) {
        Link newLink = new Link(i);
        if (isEmpty()) {
            first = newLink; last = newLink;
        } else {
            last.next = newLink;
            last = newLink;
        }
    }

    public Link popFirst() {
        if (first.next == null) {Link t = first; first = null; last = null; return t;}
        else {Link t = first; first = first.next; return t;}
    }

    public void display() {
        Link curr = first;
        while (curr!=null) {curr.displayLink(); curr = curr.next;}
    }
    public boolean isEmpty() {return first==null;}
}


class Link {
    int dataI;
    Link next;
    public Link(int dataI) {
        this.dataI = dataI;
    }
    public void displayLink() {
        System.out.println(dataI);
    }
}