package nik.ch4;

public class CycleList {
    Node current;
//    Node previous;

    public void next(){
        if(isEmpty() || current == current.next) return;
        current.flagOff();
        current = current.next;
        current.flagOn();
    }
    public Node getCurrent() {
        return current;
    }
    public void insert(int data){
        Node newNode = new Node(data);
        if(current == null){
            current = newNode;
            current.next = newNode; // self referenced
            return;
        }
        newNode.next = current.next;
        current.next = newNode;
        current.flagOff();
//        current = newNode;
        current.flagOn();
    }
    public Node find(int data){
        /* проверяем 1й элемент, если он совпадает, делаем возврат, иначе
        * переходим к следующему элементу и проверяем flag,
        * если flag == true значит мы обошли все элементы в круг*/
        if(isEmpty()) return null;
        Node tmp = current;
        if(tmp.data == data) return current;
        else tmp = tmp.next;
        while (!tmp.curFlag){  // если флаг true значит обошли все элементы или всего 1 элемент
            if(tmp.data == data) return tmp;
            else tmp = tmp.next;
        }
        return null;  // если дошли сюда , значит не нашли элемент
    }
    public Node delete(){
        if(isEmpty()) return null;
        if(current == current.next) { // один элемент в списке
            Node tmp = current;
            current = null;
            return tmp;
        }

        Node tmp = current.next;
        current.next = current.next.next;
        return tmp;
    }

    public boolean isEmpty(){
        return current == null;
    }
    public void display(){
        if(isEmpty())return;
        Node tmp = current;
        tmp.displayNode();
        tmp = tmp.next;
        while (!tmp.curFlag){
            tmp.displayNode();
            tmp = tmp.next;
        }
        System.out.println("");
    }
}
