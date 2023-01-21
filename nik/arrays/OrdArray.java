package nik.arrays;

import nik.arrays.strategy.SortStrategy;

import java.util.Arrays;
import java.util.Random;

/**
 * The type Ord array.
 * Реализует паттерн СТРАТЕГИЯ И КЛОН
 */
public class OrdArray implements Clonable {
    private int size;
    private int[] array;
    private SortStrategy sortStrategy;

    public OrdArray(int max, SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
        size = 0;
        array = new int[max];
        init();
        sort();
    }

    public OrdArray(OrdArray array){
        this.size = array.size();
        this.array = array.getArray();
        this.sortStrategy = array.getSortStrategy();
    }

    public void init(){
        size = 0;
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(100);
            size++;
        }
    }

    public int[] getArray() {
        return Arrays.copyOfRange(array, 0, size );
    }
    public SortStrategy getSortStrategy(){return sortStrategy;}
    public void setSortStrategy(SortStrategy sortStrategy) {
        this.sortStrategy = sortStrategy;
    }

    /**
     * Boble sort.
     */
    public void sort(){ array = sortStrategy.sort(array, size);}

    public  void shellSort() {
        int i, indexToSort;
        int elemToSort;
        int h = 1;
        while (h * 3 < size)
            h = h * 3 + 1;
        while (h > 0) {
            for (indexToSort = h; indexToSort < size; indexToSort++) {
                elemToSort = array[indexToSort];
                i = indexToSort;
                // Первый подмассив (0, 4, 8)
                while (i >= h && array[i - h] >= elemToSort) {
                    array[i] = array[i - h];
                    i -= h;
                }
                array[i] = elemToSort;
            }
            h = (h - 1) / 3;
        }
    }

    /**
     *Binary search
     */
    public int find(int val) {
        int lowerBound = 0;
        int upperBound = size - 1;
        int middle = (lowerBound + upperBound) / 2;
        while (lowerBound <= upperBound) {
            if (array[middle] == val) {
                return middle;
            }  else if (array[middle] > val) {
                upperBound = middle - 1;
            } else if (array[middle] < val) {
                lowerBound = middle + 1;
            }
            middle = (lowerBound + upperBound) / 2;
        }
        return size;
    }

    /**
     * Insert.
     * using binary search
     *
     */
    public void insert(int val) {
        int indexForInsert = find(val);
        if (indexForInsert != size) {
            System.out.println("such element already exist");
            return;
        }
//        int indToInsert; находим индекс для вставки в упорядоченный массив
        for (indexForInsert = 0; indexForInsert < size; indexForInsert++) {
            if (array[indexForInsert] > val) break;
        }
        // Если элемент больше максимального в массиве, то вставляем его справа и дело в шляпе
        if (indexForInsert == size) {
            array[indexForInsert] = val;
            size++;
            return;
        }
//      смещаем все элементы начиная с индекса для вставки в право. смещение начинается с конца массива.
//      size - это фактический размер виртуального массива
        for (int indMove = size; indMove > indexForInsert; indMove--) {
            array[indMove] = array[indMove - 1];
            //System.out.println("huynya " + indMove + " " + indexForInsert);
        }
        array[indexForInsert] = val;
        size++;
    }


    /**
     * Delete boolean.
     * with binary search
     */
    public boolean delete(int val) {
        int indForDel = find(val);

        if (indForDel == size) {
            return false;
        } else {
            for (int i = indForDel; i < size - 1; i++) {
                array[i] = array[i + 1];
            }
            size--;
            return true;
        }
    }

    /**
     * Get elem by INDEX.
     *
     * @param ind the index
     * @return the int value of element
     */
    public int getElem(int ind) {
        if (ind >= size) return size;
        else return array[ind];
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        System.out.println(size);
        return size;
    }

    /**
     * Display.
     */
    public void display() {
        System.out.println("Current values: ");
        for (int i = 0; i < size; i++) {
            System.out.print(" i[" + i + "]: " + array[i]);
        }
        System.out.println("");
    }

    /**
     * Reset.
     */
    public void reset() {
        for (; size > 0; size--) {
            array[size - 1] = 0;
            //System.out.println("huynya " + i + " size: " + size );
        }
        //size = 0;
    }

    /**
     * Gets max.
     *
     * @return the max
     */
    public int getMax() {
        int max = 0;
        if (array.length == 0) return -1;
        for (int i = 0; i < size; i++) {
            if (max < array[i]) max = array[i];
        }
        return max;
    }

    /**
     * Remove max int.
     *
     * @return the int
     */
    public int removeMax() {
        int elementToRemove = getMax();
        delete(elementToRemove);
        return elementToRemove;
    }

    @Override
    public Object clone() {
        return new OrdArray(this);
    }
}
