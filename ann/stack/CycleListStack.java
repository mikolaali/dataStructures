package ann.stack;

public class CycleListStack {
    Link curr;

    public CycleListStack() {
        curr = null;
    }

    public void push(int data) {
        Link newL = new Link(data);
        if (isEmpty()) {curr = newL; curr.next = curr;}
        else {newL.next = curr.next; curr.next = newL;}
    }

    public Link pop() {Link t = curr.next; curr.next = t.next; return t;}

    public Link read() {return curr.next;}

    public boolean isEmpty() {return curr==null;}

}
