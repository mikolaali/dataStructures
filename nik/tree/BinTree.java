package nik.tree;

import nik.stack.Stack;

public class BinTree {
    Node root;

    public Node find(int val) {
        Node current = root;
        if (current == null) return null;
        while (current.data != val) {
            if (current == null)
                return null;
            if (val > current.data)
                current = current.right;
            else
                current = current.left;
        }
        return current;
    }

    public void insert(int val) {
        Node current = root;
        Node previous;
        if (current == null) {
            root = new Node(val);
            return;
        }
        while (true) {
            previous = current;
            if (val < current.data) {
                current = current.left;
                if (current == null) {
                    previous.left = new Node(val);
                    return;
                }
            } else {
                current = current.right;
                if (current == null) {
                    previous.right = new Node(val);
                    return;
                }
            }
        }
    }

    public boolean delete(int val) {
        Node current = root;
        if (current == null) return false;
        Node parent = current;
        boolean isLeft = true;
        while (current.data != val) {
            if (val > current.data) {   // detour TREE
                isLeft = false;
                parent = current;
                current = current.right;
            } else if (val < current.data) {
                isLeft = true;
                parent = current;
                current = current.left;
            }

            if(current == null) return false;  // ELEMENT NOT FOUND

            if (val == current.data) {
                if (current == root) {  // CURRENT = root  CASE
                    if (current.right == null && current.left == null)  // no childs
                        root = null;
                    else if (current.left == null && current.right != null)   // if one(1) right child
                        root = current.right;
                    else if ( current. left != null && current.right == null)
                        root = current.left;
                    else {
                        root = getSuccessor(root);
                        root.left = current.left;
                    }
                    // DONE
                    return true;
                }

                if (isLeft) { // if CURRENT from LEFT brunch
                    if (current.right == null && current.left == null)  // no childs
                        parent.left = null;
                    else if (current.left == null && current.right != null)    // if one(1) right child
                        parent.left = current.right;
                    else if(current.left != null && current.right == null)    // if one(1) left child
                        parent.left = current.left;
                    else {
                        Node successor = getSuccessor(current);
                        parent.left = successor;
                        successor.left = current.left;
                    }
                } else {    // if CURRENT from RIGHT brunch
                    if (current.right == null && current.left == null)  // no childs
                        parent.right = null;
                    else if (current.left == null && current.right != null)   // if one(1) right child
                        parent.right = current.right;
                    else if (current.left != null && current.right == null)  // if one(1) left child
                        parent.right = current.left;
                    else {
                        Node successor = getSuccessor(current);
                        parent.right = successor;
                        successor.left = current.left;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public Node getSuccessor(Node delNode){
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = successor;
        while (current != null){
            successorParent = successor;
            successor = current;
            current = current.left;
        }

        if(successor != delNode.right){
            successorParent.left = successor.right;
            successor.right = delNode.right;
        }
        return successor;
    }

    public void order(){
        inOrder(root);
    }
    public void preOrder(Node localRoot){
        if(localRoot != null){
            System.out.println(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }
    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.println(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    public void postOrder(Node localRoot){
        postOrder(localRoot.left);
        postOrder(localRoot.right);
        System.out.println(localRoot.data + " ");
    }

    public void displayTree(){
        Stack<Node> globStack = new Stack<>(500);
//        System.out.println(root.data);
        globStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("................................");
        while(isRowEmpty == false)
        {
            Stack<Node> localStack = new Stack<>(500);
            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globStack.isEmpty())
            {
                Node tmp = (Node) globStack.pop();
                if(tmp != null){
                    System.out.print(tmp.data);
                    localStack.push(tmp.left);
                    localStack.push(tmp.right);

                    if(tmp.left != null || tmp.right != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int i = 0; i < nBlanks*2-2; i++)
                    System.out.print(" ");
                }
                System.out.println();
                nBlanks /= 2;
                while (localStack.isEmpty() == false) {
                    globStack.push(localStack.pop());
                }
            }
        }


    public void displayTree1()

    {
        Stack<Node> globalStack = new Stack(500);
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while(isRowEmpty==false)
        {
            Stack<Node> localStack = new Stack(500);
            isRowEmpty = true;
            for(int j=0; j<nBlanks; j++)
                System.out.print(' ');
            while(globalStack.isEmpty()==false)
            {
                Node temp = (Node)globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.data);
                    localStack.push(temp.left);
                    localStack.push(temp.right);
                    if(temp.left != null ||
                            temp.right != null)
                        isRowEmpty = false;
                }
                else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++)
                    System.out.print(' ');
            }
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() );
        }
        System.out.println(
                "......................................................");
    }

    public Node min() {
        if (root == null) return null;
        Node current = root;
        while (current.left != null)
            current = current.left;
        return current;
    }

    public Node max() {
        if (root == null) return null;
        Node current = root;
        while (current.right != null)
            current = current.right;
        return current;
    }
}

