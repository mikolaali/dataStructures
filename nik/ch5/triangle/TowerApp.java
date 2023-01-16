package nik.ch5.triangle;

import nik.stack.Stack;

public class TowerApp {
  //  static int nDisk = 3;
    public static void main(String[] args) {
       // doTowers(nDisk, 'A', 'B', 'C');
        Pin A = new Pin("A", 3, true);
        Pin B = new Pin("B", 3, false);
        Pin C = new Pin("C", 3, false);
        A.setNext(B);
        B.setNext(C); B.setPrevious(A);
        C.setPrevious(B);

        tower(3, A, B, C);
    }


    static class Pin{
        private Stack<Integer> pin;
        private String name;
        private Pin next;
        private Pin previous;

        public Pin(String name, int size, boolean first) {
            this.name = name;
            pin = new Stack<>(size);
            next = null;
            previous = null;
            if(first){
                for (int i = size; i > 0; i--) {
                    pin.push(i);
                }
            }
        }

        public void setNext(Pin next) {
            this.next = next;
        }

        public void setPrevious(Pin previous) {
            this.previous = previous;
        }

        public String getName(){return name;}
        public void push(int val){ pin.push(val);}
        public int pop(){ return pin.pop();}
        public int peek(){return pin.peek();}
        public void moveRingTo(Pin pinTo){
            int ring = pin.pop();
            pinTo.push(ring);
            System.out.println("Disk " + ring + " from " + getName() + " moved to " + pinTo.getName());
            displayAll();
        }
        public void displayAll(){
            if(previous == null) {
                System.out.print(name + ": ");
                pin.displayStack();
                System.out.print(next.name + ": ");
                next.pin.displayStack();
                System.out.print(next.next.name + ": ");
                next.next.pin.displayStack();
            }
            if(previous != null && next != null){
                System.out.print(previous.name + ": ");
                previous.pin.displayStack();
                System.out.print(name + ": ");
                pin.displayStack();
                System.out.print(next.name + ": ");
                next.pin.displayStack();
            }
            if(previous != null && next == null){
                System.out.print(previous.previous.name + ": ");
                previous.previous.pin.displayStack();
                System.out.print(previous.name + ": ");
                previous.pin.displayStack();
                System.out.print(name + ": ");
                pin.displayStack();
            }
        }
        }


    public static void tower(int top, Pin A, Pin B, Pin C){
        if(top == 1 ) {
            System.out.println("Top = " + top + " | " + A.getName() + " " + B.getName() + " " + C.getName());
            A.moveRingTo(C);
            System.out.println("return top = " + top);
        } else {
            System.out.println("Top = " + top + " | " + A.getName() + " " + B.getName() + " " + C.getName());
            tower(top - 1, A, C, B); // From -> Inter
            System.out.println("Top = " + top + " | " + A.getName() + " " + B.getName() + " " + C.getName());
            A.moveRingTo(C);
            tower(top - 1, B, A, C); // Inter -> To
            System.out.println("return top = " + top);
        }

    }


    private static void doTowers(int topN, char from, char inter, char to) {
        if(topN == 1)
            System.out.println("Disk 1 from " + from + " to " + to);
        else {
            doTowers(topN - 1, from, to, inter);
            System.out.println("Disk " + topN +
                    " from " + from + " to " + to);
            doTowers(topN - 1, inter, from, to);
        }
    }

}
