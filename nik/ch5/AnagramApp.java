package nik.ch5;

import java.io.IOException;

import static nik.lib.IOlib.getString;

public class AnagramApp {
    static int size;
    static int count;
    static char[] arrChar = new char[100];

    public static void main(String[] args) throws IOException {
        String str = getString();
        for (int i = 0; i < str.length(); i++) {
            arrChar[i] = str.charAt(i);
        }
        count = 0;
        size = str.length();
        System.out.println(str);
        doAnagram(size);
    }

    public static void doAnagram(int newSize){
        if(newSize == 1 ) return;
        for (int i = 0; i < newSize; i++) {
            doAnagram(newSize - 1);
            if (newSize == 2)
                display();
            rotate(newSize);
        }
    }

    public static void rotate(int newSize){
        int position = size - newSize;
        char tmp = arrChar[position];
        int j;
        for( j = position + 1; j < size; j++){
            arrChar[j - 1] = arrChar[j];
        }
        arrChar[j - 1] = tmp;
    }
    public static void display(){
        System.out.print(++count + " ");
        for (int i = 0; i < size; i++) {
            System.out.print(arrChar[i]);
        }
        System.out.print(" ");
        if (count % 6 == 0 )
            System.out.println("");
    }

}
