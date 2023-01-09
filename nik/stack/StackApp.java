package nik.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class StackApp {
    public static void main(String[] args) throws IOException {

        /* 1. Заполнение стэка и вывод его содержимого   */
        Stack<Integer> stack = new Stack(Integer.class, 10);
        Random rnd = new Random();
        for (int i = 0; i < 10; i++) {
            stack.push(rnd.nextInt(99));
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop() + " -- ");
        }
        System.out.println("");
        stack = null;

        /* 2. Делаем реверс строки */
//        String str = getString();
        String str = "asdfgh";
        Stack<Character> stk = new Stack(Character.class, str.length());
        for (int i = 0; i < str.length(); i++) {
            stk.push(str.charAt(i));
        }
        while (!stk.isEmpty()){
            System.out.print(stk.pop());
        }
        System.out.println("");

        /* 3 TASK проверка наличия парных скобок*/
        System.out.println("Enter data to reverse: ");
//        str = getString();
        String[] strings = {"((009)){}[]", "[{(())}]", "{[({)}}]", "(((]]}", "(())}}", "((())"};
        for (String string:strings) {
            System.out.println("--------- " + string + " -------------");
            if (checkBracket(string)) {
                System.out.println("all OK");
            } else {
                System.out.println("ERR no pair for bracket =============");
            }
        }


    }

    /*  вспомогательный метод для ПОЛУЧЕНИЯ строки с консоли */
    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    /* 3 TASK метод для ПРОВЕРКИ ПАРНОСТИ СКОБОК */
    public static boolean checkBracket(String str){
        if(str.isEmpty()) {
            System.out.println("Enter some string");
            return false;
        }
        Stack<Character> stack = new Stack<>(Character.class, str.length());
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            switch (ch){
                case '(':
                case '[':
                case '{':
                    stack.push(ch);
                    break;
                case ')':
                case ']':
                case '}':
                    if(!stack.isEmpty()){
                        Character chS = stack.pop();
                        if( chS == '(' && ch == ')' ||
                        chS == '[' && ch == ']' ||
                        chS == '{' && ch == '}') {
                            break;
                        } else {
                            System.out.println("WRONG right bracket");
                            return false; // кончились элементы в стэке, нет парной скобки
                        }
                    } else {
                        System.out.println("No LEFT bracket");
                        return false;
                    }
                default:
                    break;
            }
        }
        if(!stack.isEmpty()) {
            System.out.println("No RIGHT bracket");
            return false;
        } else {
            System.out.println("ALL bracket has pair");
            return true;
        }
    }
}
