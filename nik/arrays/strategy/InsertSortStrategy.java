package nik.arrays.strategy;

/**
 * The type Insert sort strategy.
 * Из всех видов сортировки со сложностью O(N 2), описанных в этой главе,
 * чаще всего используется сортировка методом вставки.
 */
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
