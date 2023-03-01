package ann.linkedlist;
class ListIteratorApp {
    public static void main(String[] args) {
        LinkedList list = new LinkedList(); // Создание списка
        ListIterator iter1 = list.getIterator(); // Создание итератора
        int val;
        iter1.insertAfter(20, 90);
        iter1.insertAfter(40, 91);
        iter1.insertAfter(80, 92);
        iter1.insertBefore(60, 93);

    }
}

public class ListIterator {
    private Link curr;
    private Link prev;
    private LinkedList list;
    public ListIterator(LinkedList l) {
        list = l;
        reset();
    }

    public Link getCurr() {return curr;}
    public void insertAfter(int i, long l) {
        Link newLink = new Link(i,l);
        if (atEnd()) {curr.next = newLink; reset();}
        else {
            newLink.next = curr.next;
            curr.next = newLink;
            next();
        }
    }
    public void insertBefore(int i,  long l) {
        Link newLink = new Link(i,l);
        if (prev==null) {newLink.next = curr; list.setFirst(newLink); reset();}
        else {
            prev.next = newLink;
            newLink.next = curr;
        }
    }
    public int deleteCurr() {
        int i = curr.dataI;
        if(prev == null) {
            list.setFirst(curr.next);
            reset();
        }
        else {
            prev.next = curr.next;
            if( atEnd() )
                reset();
            else
                curr = curr.next;
        }
        return i;}
    public void next() {prev = curr; curr = curr.next;}
    public boolean atEnd() {return curr.next==null;}
    public void reset() {curr = list.getFirst(); prev = null;}
}
