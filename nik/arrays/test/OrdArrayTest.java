package nik.arrays.test;

import nik.arrays.OrdArray;
import nik.arrays.strategy.BubbleSortStrategy;
import nik.arrays.strategy.SelectSortStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrdArrayTest {
    OrdArray array = new OrdArray(6, new BubbleSortStrategy());
    int[] tmp = array.getArray();

    @Test
    // СРАВНИВАЕМ СОДЕРЖИМОЕ МАССИВА И ЕГО ДЛИНУ, Т.К. ЭТО ССЫЛОЧНЫЙ ТИП
    void test_equals_getArray() {
        assertArrayEquals(tmp, array.getArray());
    }

    @Test
    void test_type_of_sortStrategy_getSortStrategy() {
        assertInstanceOf(BubbleSortStrategy.class, array.getSortStrategy());
    }

    @Test
    void test_setSortStrategy() {
        array.setSortStrategy(new SelectSortStrategy());
        assertInstanceOf(SelectSortStrategy.class, array.getSortStrategy());
        array.setSortStrategy(new BubbleSortStrategy());
    }


    /**
     * ФУНКЦИЯ ДЛЯ СРАВНЕНИЯ ЭЛЕМЕНТОВ МАССИВА УПОРЯДОЧЕННОГО ПО ВОЗРАСТАНИЮ
     * ИСПОЛЬЗУЕТСЯ В assertTrue ниже
     * тест сортировок в отдельном файле
     */


    @Test
    void test_find_method() {
        array.sort();
        int desired = tmp[3];
        int found = array.getElem(array.find(desired));
        assertEquals(desired, found);

    }

    public boolean compare(int[] tmp){
        int i = 0; boolean result = true;
        while (i < array.size() - 1 && result){
            if(tmp[i] <= tmp[++i]) {continue;}
            else result = false;
        }
        return result;
        }
    @Test
    void test_insert() {
        array.insert(15);
        int[] tmp = array.getArray();
        array.display();
        assertTrue(compare(tmp));
        assertEquals(6, array.size());
    }


    @Test
    void test_delete() {
        array.delete(15);
        assertEquals(5, array.size());
    }

    @Test
    void test_getElem() {
        int elem = array.getElem(0);
        assertEquals(elem, array.getElem(0));
    }

    @Test
    void test_size() {
        int size = 5;
        assertEquals(size, array.size());
    }

    @Test
    void test_reset() {
        array.reset();
        assertEquals(0, array.getElem(0));
        assertEquals(0, array.size());
        assertEquals(0, array.getElem(4));

    }

    @Test
    void test_getMax() {
        int max = array.getMax();
        assertEquals(max, array.getMax());
        assertEquals(max, array.getElem(array.size() - 1));
    }

    @Test
    void test_removeMax() {
        array.removeMax();
        assertEquals(4, array.size());
    }
}