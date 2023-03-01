package ann.linkedlist;
class DLLApp {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertFirst(6);
        dll.insertFirst(5);
        dll.insertFirst(2);
        dll.insertFirst(8);
        dll.insertLast(11);
        dll.displayForw();
        System.out.println("inserting...");
        dll.insertAfter(5, 88);
        System.out.println("Displaying...");
        dll.displayForw();
    }
}




public class DoublyLinkedList {
    Link1 first;
    Link1 last;
    public DoublyLinkedList() {
        first = null;
        last = null;
    }

    public void insertFirst(int i) {
        Link1 newLink = new Link1(i);
        if (isEmpty()) {last = newLink;}
        else {newLink.next = first; first.prev = newLink;}
        first = newLink;
    }

    public void insertLast(int i) {
        Link1 newLink = new Link1(i);
        newLink.prev = last;
        last.next = newLink;
        last = newLink;
    }

    public boolean insertAfter(int key, int i) {
        Link1 newLink = new Link1(i);
        Link1 curr = first;
        while (curr!=null && curr.dataI!=key) {
            curr = curr.next;
        }
        if (curr==null) {return false;}
        if (curr==last) {last = newLink;}
        else {newLink.next = curr.next; curr.next.prev = newLink;}
        newLink.prev = curr;
        curr.next = newLink;
        return true;
    }

    public Link1 popFirst() {
        Link1 t = first; first = first.next; return t;
    }

    public Link1 popLast() {
        Link1 t = last; last = last.prev; return t;
    }

    public Link1 popKey(int key) {
        Link1 curr = first;
        Link1 prev = null;
        while (curr!=null && curr.dataI!=key) {
            prev = curr;
            curr = curr.next;
        }
        if (curr==null) {return null;}
        if (curr==first) {first = first.next; first.prev = null;}
        if (curr==last) {last = last.prev; last.next = null;}
        else {curr.prev.next = curr.next; curr.next.prev = curr.prev;}
        return curr;
    }

    public void displayForw() {
        Link1 curr = first;
        while (curr!=null) {
            curr.displayLink();
            curr = curr.next;
        }
    }
    public void displayBackw() {
        Link1 curr = last;
        while (curr!=null) {
            curr.displayLink();
            curr = curr.prev;
        }
    }

    public boolean isEmpty() {return first==null;}
}
