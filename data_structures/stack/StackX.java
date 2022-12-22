package data_structures.stack;
class Main {
    public static void main(String[] args) {
        System.out.println(reverseStr("gnirts nruteR"));
    }

public static String reverseStr(String s) {
        String s2 = "";
        StackX stackX = new StackX(s.length());
    for (int i=0;i<s.length();i++) {
        stackX.push(s.charAt(i));
    }
    for (int i=0;i<s.length();i++) {
        s2+=stackX.pop();
    }
    return s2;
}
}




public class StackX {
    private final int maxSize;
    private char[] stack;
    private int pointer;
    public StackX(int s) {maxSize = s; stack = new char[s]; pointer = -1;}
    public void push(char l) {stack[++pointer] = l;}
    public char pop() {return stack[pointer--];}
    public char read() {return stack[pointer];}
    public boolean isEmpty() {return pointer == -1;}
    public boolean isFull() {return pointer == maxSize-1;}
}


class Reverser {
    private String s;

}