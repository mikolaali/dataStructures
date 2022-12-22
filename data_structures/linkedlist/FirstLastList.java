package data_structures.linkedlist;
class FLLApp {
    public static void main(String[] args) {
        FirstLastList fll = new FirstLastList();
        fll.insertFirst(7, 88);
        fll.insertFirst(5, 85);
        fll.insertFirst(3, 93);
        fll.display();
        System.out.println("Deleting: "); fll.deleteFirst().displayLink();
        //System.out.println("Searching by key, found: "); fll.find(7).displayLink();

        while (!fll.isEmpty()) {Link t = fll.popFirst(); System.out.print("Deleted: ");  t.displayLink();}
        fll.display();

    }
}




public class FirstLastList {
    Link first;
    Link last;

    public void insertFirst(int i, long l) {
       Link newL = new Link(i,l);
        if (first==null) {
            last = newL;
        }
        else {
            newL.next = first;
        }
        first = newL;
    }

    public void insertLast(int i, long l) {
        Link newL = new Link(i,l);
        if (first==null) {first=newL;}
        else {last.next = newL;}
        last = newL;
    }

    public Link popFirst() {
        Link t = first;
        if (first.next==null) {last = null; first = null;}
        else {first = first.next;}
        return t;
    }


    public Link deleteFirst() {
        Link t = first;
        if (first.next==null) {last = null;}
        else {first = first.next;}
        return t;
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
