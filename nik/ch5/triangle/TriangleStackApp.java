package nik.ch5.triangle;

import nik.stack.Stack;

import java.io.IOException;

import static nik.lib.IOlib.getInt;
public class TriangleStackApp {
    static int num;
    static int triangle;
    static int codePart;
    static Stack<Params> stack;

    public static void main(String[] args) throws IOException {
        num = getInt();
        stack = new Stack<>(num);
        triangle();
        System.out.println(triangle);
    }

    private static void triangle() {
        codePart = 1;
        while (!step())
            ;
        }

    private static boolean step() {

        switch (codePart) {
            case 1:
                stack.push(new Params(num, 6));
                codePart = 2;
                break;
            case 2:
                if (stack.peek().n == 1) {
                    triangle = 1;
                    codePart = 5;
                } else {
                    codePart = 3;
                }
                break;
            case 3:
                stack.push(new Params(--num, 4));
                codePart = 2;
                break;
            case 4:
                triangle += stack.peek().n;
                codePart = 5;
                break;
            case 5:
                codePart = stack.peek().ra;
                stack.pop();
                break;
            case 6:
                return true;
            default:
                break;

        }
        return false;
    }

}
