package nik.tree;

import java.util.Random;

public class TreeApp {
    public static void main(String[] args) {
        BinTree tree = new BinTree();
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            tree.insert(rnd.nextInt(100));
        }
        tree.displayTree1();
//        tree.order();
    }
}
