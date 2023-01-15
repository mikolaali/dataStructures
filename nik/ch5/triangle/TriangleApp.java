package nik.ch5.triangle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TriangleApp {
    public static void main(String[] args) throws IOException {
        System.out.println(triangle(3));
        System.out.println(triangle(5));
        System.out.println(triangle(10));
        System.out.println(triangle(1000));
        System.out.println((1000*1000 + 1000)/2);

    }

    public static int triangle(int num){
        if(num == 1 ) return 1;
        return num + triangle(num - 1);
    }

    public static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }

    private static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;

    }
}
