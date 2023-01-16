package ann.stack;

public class CycleList {
    Link curr;
    public CycleList() {
        curr = null;}

    public void insert(int i) {
        Link newLink = new Link(i);
        if (isEmpty()) {curr=newLink; curr.next = curr; return;}
        newLink.next = curr.next;
        curr.next = newLink;
        curr = newLink;
    }

    public Link popFirst() {Link t = curr; curr = curr.next; return t;}

    public boolean isEmpty() {return curr == null;}

    public Link find(int data) {
        Link stop = curr;
        while (curr.next.dataI!=data) {
            if (curr.next==stop) {return null;}
            else {curr = curr.next;}
        }
        return curr.next;
        }


    public void delete(int data) {
        if (isEmpty()) {System.out.println("No such data in List"); return;}
        Link toDelete = find(data);
        if (toDelete == null) {
            System.out.println("No such num in List"); return;
        }
        curr.next = toDelete.next;

    }

    public void display() {
        if (curr ==null) {System.out.println("empty"); return;}
        Link stop = curr;
        curr.displayLink();
        curr = curr.next;
        while (curr!=stop) {curr.displayLink(); curr = curr.next;}
    }

}
