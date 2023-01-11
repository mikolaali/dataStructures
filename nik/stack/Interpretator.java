package nik.stack;

import java.util.HashMap;

public class Interpretator {
    private String infix;
    private String postfix = "";
    private Stack<Character> stack;
    private Stack<Integer> stackForCalc;
    private HashMap<Character, Integer> priority = new HashMap<>() {{
        put('+', 1);
        put('-', 1);
        put('*', 2);
        put('/', 2);
    }};

    public Interpretator(String str) {
        infix = str;
        stack = new Stack(str.length());
    }

    public String transform() throws RuntimeException {
        boolean number = true;
        for (int i = 0; i < infix.length(); i++) {
            char ch = infix.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    number = false;
                    gotOperator(ch, 1);
                    break;
                case '*':
                case '/':
                    number = false;
                    gotOperator(ch, 2);
                    break;
                case '(':
                    number = false;
                    stack.push(ch);
                    break;
                case ')':
                    number = false;
                    gotParenthesis();
                    break;
                case ' ':
                    number = false;
                    break;
                default:
                    if (number == false) {
                        number = true;
                        postfix += ' ';
                        postfix += ch;
                        break;
                    } else {
                        postfix += ch;
                        break;
                    }
            }
        }
        while (!stack.isEmpty()) {
            postfix += stack.pop();
        }
        return postfix;
    }

    private void gotParenthesis() {
        while (!stack.isEmpty()) {
            Character chS = stack.pop();
            if (chS == '(') {
                return;
            } else postfix += chS;
        }
    }

    private void gotOperator(Character character, int i) {
        while (!stack.isEmpty()) {
            //1. stack NOT EMPTY and poped char == '('
            Character charFromStack = stack.pop();
            if (charFromStack == '(') {
                stack.push(charFromStack);
                break;
            }
            // 3. stack NOT EMPTY and char == some OPERATION
            if (priority.get(character) <= priority.get(charFromStack)) {
                postfix += charFromStack;
                continue;
            }

            // 4. stack NOT EMPTY and char == some OPERATION
            if (priority.get(character) > priority.get(charFromStack)) {
                stack.push(charFromStack);
                break;
            }
        }
        stack.push(character);
    }

    public String getPostfix() {
        return postfix;
    }

    public void setInfix(String infix) {
        this.infix = infix;
        this.postfix = "";
    }

    public int calculate() {
        stackForCalc = new Stack<>(postfix.length());
        Character ch;
        String num = "";        // собираем цифры в число для сохранения в стэк stackForCalc
        boolean digit = false;  // предыдущий знак цифра?
        int num1, num2;         // для вычисления
        for (int j = 0; j < postfix.length(); j++) {
            ch = postfix.charAt(j);
            if (ch >= '0' && ch <= '9') {
                digit = true;
                num += ch;
                continue;
            } else if (ch == ' ' && digit) {    // для ситуации num'_'
                stackForCalc.push(Integer.parseInt(num));
                num = "";
            } else if (ch == ' ') {  // это пробел после арифметического знака - пропускаем: (3- 2)
                continue;
            } else {
                if(digit){
                    digit = false;
                    stackForCalc.push(Integer.parseInt(num));
                    num = "";
                }
                num2 = stackForCalc.pop();
                num1 = stackForCalc.pop();
                switch (ch) {
                    case '+':
                        stackForCalc.push(num1 + num2); break;
                    case '-':
                        stackForCalc.push(num1 - num2); break;
                    case '*':
                        stackForCalc.push(num1 * num2); break;
                    case '/':
                        stackForCalc.push(num1 / num2); break;
                }
            }
        }
        return stackForCalc.pop();
    }
}
