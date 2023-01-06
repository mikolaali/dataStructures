package nik.lib;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class InitRandArr {
    /**
     * Init array via rand lib and using external file "randomArr.txt" for temp serving of integers
     *
     * @return the int [ ]
     * @throws IOException the io exception
     */
    public static int[] initArray()  {
        // 1. create file with random values
        final String DIR = "src/nik/tmp/";
        PrintWriter fileForRandom = null;
        try {
            fileForRandom = new PrintWriter(new FileWriter(DIR + "randomArr.txt"));
            Random rand = new Random();

            for (int i = 0; i < 50; i++) {
                fileForRandom.println(rand.nextInt(100));
            }
        } catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        } finally {
            fileForRandom.close();
        }

        // 2. Read values from file
        Scanner arrayRandFile = null;
        int[] randomArray = {};
        try {
            // считаем размерность массива в файле
            arrayRandFile = new Scanner(new File(DIR + "randomArr.txt"));
            int i = 0;
            while (arrayRandFile.hasNext()) {
                i++;
                System.out.print("-" + i + "-" + arrayRandFile.next() + " ");
            }
            // 3. create Array with generated values which saved in file "randomArr.txt"
            arrayRandFile.reset();
            randomArray = new int[i];
            while (arrayRandFile.hasNext()) {
                for (int j = 0; j < i; j++) {
                    randomArray[j] = Integer.parseInt(arrayRandFile.next());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return randomArray;
    }
}
