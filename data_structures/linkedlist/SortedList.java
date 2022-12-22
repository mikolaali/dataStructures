package data_structures.linkedlist;
class SortedListApp {
    public static void main(String[] args) {
        SortedList fll = new SortedList();
        fll.insert(88);
        fll.insert(85);
        fll.insert(3);
        fll.display();
        System.out.println("Deleting: "); fll.popFirst().displayLink();
        fll.display();
    }
}




public class SortedList {
    Link1 first;
    public SortedList() {first = null;}

    public void insert(int i) {
        Link1 newLink = new Link1(i);
        if (isEmpty()) {first = newLink; return;}
        Link1 curr = first;
        Link1 prev = null;
        while (curr!=null && curr.dataI < i) {
            prev = curr;
            curr = curr.next;
        }
        if (prev==null) {first = newLink;}
        else {prev.next = newLink;}
        newLink.next = curr;
    }

    public Link1 popFirst() {
        if(isEmpty()) {return null;}
        else {Link1 t = first; first = first.next; return t;}
    }


    public void display() {
        if (isEmpty()) {System.out.println("SortedList is empty now");}
        else {
        System.out.println("Displaying a whole SortedList: ");
        Link1 curr = first;
        while (curr!=null) { curr.displayLink(); curr=curr.next; }
    }}

    public boolean isEmpty() {return first==null;}
}


class Link1 {
    int dataI;
    Link1 next;
    Link1 prev;

    public Link1(int dataI) {
        this.dataI = dataI;
    }

    public void displayLink() {
        System.out.println(dataI);
    }
}