package nik.tree.manual;

import nik.stack.Stack;

public class Tree {
    private Node root;

    public Tree() {
        root = null;
    }

    public Node find(int key) {
        Node current = root;
        while (key != current.data) {
            Node parent = current;
            if (key < current.data)
                current = current.left;
            if (key > current.data)
                current = current.right;
            if (current == null)
                return null;
        }
        return current;
    }

    public void insert(int key) {
        Node current = root;
        Node parrent = current;
        Node newNode = new Node(key);
        if (root == null) {
            root = newNode;
        }
        else {
            while (current != null) {
                parrent = current;
                if (key > current.data) {
                    current = current.right;
                    if (current == null)
                        parrent.right = newNode;
                }else if (key <= current.data) {
                    current = current.left;
                    if (current == null)
                        parrent.left = newNode;
                }
            }
            return;
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parrent = current;
        boolean isLeft = false;
        while (key != current.data) {
            parrent = current;
            if (key > current.data) {
                isLeft = false;
                current = current.right;
            } else if (key < current.data) {
                isLeft = true;
                current = current.left;
            }
            if (current == null) return false;
        }
        // 1st - null    childs
        if (current.left == null && current.right == null) {   // 2 variants - root or leaf
            if (current == root) {
                root = null;
                return true;
            }  //root delete
            if (isLeft)
                parrent.left = null;
            else
                parrent.right = null;
        }
        // one child
        else if (current.left != null && current.right == null) {  // left child
            if (current == root) {
                root = current.left;
            } else if (isLeft)
                parrent.left = current.left;
            else
                parrent.right = current.left;

        } else if (current.left == null && current.right != null) {  // right child
            if (current == root)
                root = current.right;
            else if (isLeft)
                parrent.left = current.right;
            else
                parrent.right = current.right;
        } else if (current.left != null && current.right != null) {  // 2 childs
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
                successor.left = root.left;
            } else if (isLeft) {
                parrent.left = successor;
                successor.left = current.left;
            } else {
                parrent.right = successor;
                successor.left = current.left;
            }

        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode.right;
        Node current = successor;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.left;
        }
        if (successor != delNode.right) {
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    public Node getRoot(){return root;}

    public void displayTree() {
        Stack<Node> globStack = new Stack<>(500);
        Stack<Node> localStack = new Stack<>(500);
        boolean rowIsEmpty = false;
        int nBlanks = 32;
        globStack.push(root);
        while (rowIsEmpty == false) {
            rowIsEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }
            while (!globStack.isEmpty()) {
                Node tmp = globStack.pop();
                if (tmp != null) {
                    System.out.print(tmp.data);
                    localStack.push(tmp.left);
                    localStack.push(tmp.right);
                    if (tmp.left != null || tmp.right != null)
                        rowIsEmpty = false;
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < nBlanks * 2 - 2; i++)
                    System.out.print(" ");
                }
                System.out.println("");
                while (!localStack.isEmpty())
                    globStack.push(localStack.pop());
                nBlanks /= 2;

        }
    }

}
