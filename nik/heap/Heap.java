package nik.heap;

public class Heap {
    private int size;
    private Node[] heap;

    public Heap(int size) {
        this.size = 0;
        heap = new Node[size];
    }


    public boolean isEmpty(){ return size == 0;}


    public Node remove(){
        Node root = heap[0];
        heap[0] = heap[--size];
        trickleDown(0);
        return root;
    }

    private void trickleDown(int ind) {
        int gChildI;
        Node top = heap[ind];
        while (ind < size/2){
            int leftChildI = ind * 2 + 1;
            int rightChildI = leftChildI + 1;
            if(rightChildI < size &&
                heap[leftChildI].getData() < heap[rightChildI].getData())
                gChildI = rightChildI;
            else
                gChildI = leftChildI;
            if(top.getData() >= heap[gChildI].getData())
                break;
            heap[ind] = heap[gChildI];
            ind = gChildI;
        }
        heap[ind] = top;
    }

    public boolean insert(int key){
        if(size == heap.length)
            return false;
        Node newNode = new Node(key);
        heap[size++] = newNode;
        trickleUp(size - 1);
        return true;

    }

    private void trickleUp(int ind) {
        int parentI = ( ind - 1 ) / 2;
        Node bottom = heap[ind];
        while (ind > 0 && heap[parentI].getData() < bottom.getData()){
            heap[ind] = heap[parentI];
            ind = parentI;
            parentI = (parentI - 1)/2;
        }
        heap[ind] = bottom;
    }

    public boolean change(int ind, int newVal) {
        if(ind < 0 || ind >= size)
            return false;
        int oldVal = heap[ind].getData();
        heap[ind].setData(newVal);
        if(oldVal < newVal)
            trickleUp(ind);
        else
            trickleDown(ind);
        return true;
    }

    public void displayHeap(){
        System.out.print("heapArray: ");    // Формат массива
        for(int m=0; m < size; m++)
            if(heap[m] != null)
                System.out.print( heap[m].getData() + " ");
            else
                System.out.print( "-- ");
        System.out.println();
        // second formated output
        int nBlanks = 32;
        int itemsPerRow = 1;
        int column = 0;
        int j = 0;
        String dots = "...............................";

        while(size > 0) {
            if (column == 0)
                for (int k = 0; k < nBlanks; k++)  // Предшествующие пробелы
                    System.out.print(' ');
            System.out.print(heap[j].getData());
            if (++j == size)
                break;
            if (++column == itemsPerRow) {
                nBlanks /= 2;
                itemsPerRow *= 2;
                column = 0;
                System.out.println();
            } else
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(" ");     // Внутренние пробелы
        }
            System.out.println("\n" + dots + dots); // Нижний пунктир
        }



    public Node getTop(){return heap[0];}

}
