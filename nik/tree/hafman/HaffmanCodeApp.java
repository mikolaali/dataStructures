package nik.tree.hafman;

import java.util.HashMap;
import java.util.PriorityQueue;

public class HaffmanCodeApp {
    public static void main(String[] args) {
        PriorityQueue<Tree> pQueue = new PriorityQueue<>(25, new TreeComparator());
        HashMap<Character, Tree> hashOfChar = new HashMap<>();
        String str = "BBBB SUSIE SAYS IT IS EASY TTTTT ZZZZ";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Tree tree = hashOfChar.get(ch);
            if(tree == null){
                hashOfChar.put(ch, new Tree(ch));
            }
            else
                hashOfChar.get(ch).root.incAmount();
        }

        for (Tree tree: hashOfChar.values()) {
            pQueue.add(tree);
        }

        Tree[] a = new Tree[50];
//        pQueue.comparator();
        pQueue.toArray(a);
        for (int i = 0; i < pQueue.size(); i++)
            System.out.print(a[i].root.data + " " + a[i].root.amount + " ");


        System.out.println();
        while (pQueue.size() != 1){
            Tree tmpTree = new Tree();
            tmpTree.root.left = pQueue.poll().root;
            tmpTree.root.right = pQueue.poll().root;
            tmpTree.root.amount = tmpTree.root.left.amount + tmpTree.root.right.amount;
            pQueue.add(tmpTree);
//            pQueue.toArray(a);
//            for (int i = 0; i < pQueue.size(); i++)
//                System.out.print(a[i].root.data + " " + a[i].root.amount + " ");
//            pQueue.comparator();
        }

        Tree result = pQueue.poll();
        result.displayTree();
        result.haffmanCodes(); // помимо печати, создаёт таблицу хафмана в классе tree
        // которая используется в методе archiveMsg
        String arcMsg = result.archivedMsg(str);
        System.out.println(arcMsg);
        System.out.println(result.decodeMsg(arcMsg));

    }
}
