package data_structures.linkedlist;
class LLApp {
    public static void main(String[] args) {
      LinkedList ll = new LinkedList();
      ll.insertFirst(7, 88);
      ll.insertFirst(5, 85);
      ll.insertFirst(3, 93);
      ll.display();
        System.out.println("Deleting by key: "); ll.delete(5).displayLink();
        System.out.println("Searching by key, found: "); ll.find(7).displayLink();

        while (!ll.isEmpty()) {Link t = ll.popFirst(); System.out.print("Deleted: ");  t.displayLink();}
        ll.display();

    }
}



public class LinkedList {
    private Link first;

    public ListIterator getIterator() {return new ListIterator(this);}

    public void setFirst(Link f) {
        first = f;
    }

    public Link getFirst() {
        return first;
    }

    public void insertFirst(int i, long l) {
        if (first==null) {
            first = new Link(i,l);
        }
        else {
            Link t = first;
            first= new Link(i,l);
            first.next = t;
        }
    }
    public Link popFirst() {
        Link t = first;
        if (first.next==null) {first = null;}
        else {first = first.next;}
        return t;
    }
    //Удаление по ключу

    public Link delete(int key) {
        if (isEmpty()) {return null;}
        Link curr = first;
        Link prev = first;
        while (curr.dataI!=key) {
            curr = curr.next; prev = curr;
        }
        if (curr==first) {first = first.next;}
        else {prev.next = curr.next;}
        return curr;
    }

    public void display() {
        System.out.println("Displaying Linked List: ");
        if(first==null) {System.out.println("empty"); return;}
        Link curr = first;
        while (curr!=null) {
            curr.displayLink();
            curr = curr.next;
        }
    }

    public Link find(int key) {
        Link curr = first;
        while (curr.dataI!=key) {
            if (curr==null) {return null;}
            curr = curr.next;
        }
        return curr;}

    public boolean isEmpty() {
        return first==null;
    }
}




class Link {
    int dataI;
    long dataL;
    Link next;

    public Link(int dataI, long dataL) {
        this.dataI = dataI;
        this.dataL = dataL;
    }

    public void displayLink() {
        System.out.println(dataI+" "+dataL);
    }
}


