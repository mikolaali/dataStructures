package nik.tree.hafman;

import nik.stack.Stack;

import java.util.HashMap;

public class Tree {
    private HashMap<Character, String> haffmanCodes = new HashMap<>();
    public Node root = null;

    public void add(char ch) {
        root = new Node(ch);
    }

    public Tree(char ch) {
        root = new Node(ch);
    }

    public Tree() {
        root = new Node();
    }

    public void displayTree() {
        Stack<Node> globStack = new Stack<>(500);
        Stack<Node> localStack = new Stack<>(500);
        boolean isRowEmpty = false;
        int nBlanks = 32;

        globStack.push(root);
        while (!isRowEmpty) {
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globStack.isEmpty()) {
                isRowEmpty = true;
                Node tmpNode = globStack.pop();
                if (tmpNode == null){
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                else if (tmpNode.data != 0 && tmpNode.amount > 0) {
                    System.out.print(tmpNode.data + " " + tmpNode.amount);
                    localStack.push(tmpNode.left);
                    localStack.push(tmpNode.right);
                    isRowEmpty = false;
                } else if (tmpNode.data == 0 && tmpNode.amount > 0) {
                    System.out.print("-" + tmpNode.amount + "-");
                    localStack.push(tmpNode.left);
                    localStack.push(tmpNode.right);
                    isRowEmpty = false;
                } else {
                    System.out.print("00");
                    localStack.push(new Node());
                    localStack.push(new Node());
                }
                for (int i = 0; i < nBlanks * 2 - 2; i++)
                    System.out.print(" ");
            }
            for (int i = 0; i < nBlanks; i++)
                System.out.print(" ");
            System.out.println();
            nBlanks /= 2;
            while (!localStack.isEmpty())
                globStack.push(localStack.pop());

        }
    }

    public void haffmanCodes(){
        haffmanCodes.clear();
        displayHaffmanCodes(root, "");
    }
    private void displayHaffmanCodes(Node localRoot, String code){
        if (localRoot == null) return;

        displayHaffmanCodes(localRoot.left, code + "0");
        if (localRoot.data != 0) {
            System.out.println(localRoot.data + " code: " + code);
            haffmanCodes.put(localRoot.data, code);
        }
        displayHaffmanCodes(localRoot.right, code + "1");
    }
    public String archivedMsg(String str){
        String msg = "";
        for (int i = 0; i < str.length(); i++)
            msg += haffmanCodes.get(str.charAt(i));

        return msg;
    }

    public String decodeMsg(String str){
        Node current = root;
        String msg = "";
        for (int i = 0; i < str.length(); i++) {
            int ch = Character.getNumericValue(str.charAt(i));
            if (ch == 0)
                current = current.left;
            else current = current.right;

            if (current.data != 0) {
                msg += current.data;
                current = root;
            }

        }
        return msg;
    }
}
