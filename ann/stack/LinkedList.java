package ann.stack;
class LinkQApp {
    public static void main(String[] args) {
        LinkedList list= new LinkedList();
        list.insertFirst(1);
        list.insertFirst(22);
        list.insertFirst(5);
        list.insertFirst(8);
        list.display();
        System.out.println("getting first elem... "); list.popFirst();
        //System.out.println("sorted by insert sorting array: ");
        list.display();
        System.out.println(list.find(5));
    }
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

    public Link find(int data) {
        Link curr = first;
        while (curr.dataI!=data) {
            if (curr.next==null) {return null;}
            else {curr = curr.next;}
        } return curr;
    }

    public void delete(int data) {
        Link curr = first;
        Link prev = first;
        while (curr.dataI!=data) {
            if (curr.next==null) {System.out.println("no such data");}
            else {prev = curr; curr = curr.next;}
        }
        if (curr==first) curr.next = first.next;
        else prev.next = curr.next;
    }

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