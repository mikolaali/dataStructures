package nik.lib;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IOlib {
    public static int getInt() throws IOException {
        return Integer.parseInt(getString());
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;

    }
}
