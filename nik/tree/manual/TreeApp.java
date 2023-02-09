package nik.tree.manual;

import java.util.Random;

public class TreeApp {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Random rnd = new Random();
        for (int i = 0; i < 15; i++) {
            tree.insert(rnd.nextInt(100));
        }
        tree.displayTree();
    }
}
