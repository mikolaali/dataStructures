package nik.arrays.test;

public class TestLib {
    static public boolean compare(int[] tmp){
        int i = 0; boolean result = true;
        while (i < tmp.length - 1 && result){
            if(tmp[i] <= tmp[++i]) {continue;}
            else result = false;
        }
        return result;
    }
}
