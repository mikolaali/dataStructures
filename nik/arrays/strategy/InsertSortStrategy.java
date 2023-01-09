package nik.arrays.strategy;

public class InsertSortStrategy implements SortStrategy{
    @Override
    public int[] sort(int[] array, int size) {
        int in, out, tmp;
        for(out = 1; out < size; out++){
            tmp = array[out];
            in = out;
            while( in > 0 && array[in - 1] > tmp){
                array[in] = array[in - 1];
                --in;
            }
            array[in] = tmp;
        }
        return array;
    }
}
