package ann.stack;
import java.util.HashMap;



class Interpreter {
    private StackA<Character> stack;
    private String in;
    private String out = "";
    private HashMap<Character, Integer> priority = new HashMap<>() {{
        put('+', 1); put('-', 1); put('*', 2); put('/', 2);
    }};

    public Interpreter(String s) {
        in = s;
        stack = new StackA(s.length());
    }

    public String translate() {
        for (int i = 0; i< in.length(); i++) {
            char ch = in.charAt(i);
            switch (ch) {
                case '+': case '-': gotOper(ch, 1); break;
                case '*': case '/': gotOper(ch, 2); break;
                case '(': stack.push(ch); break;
                case ')': gotClosingParen(); break;
                case ' ': break;
                default: out += ch; break;
            }
        } return out;
    }

    private void gotOper(Character ch, int p) {
        while (!stack.isEmpty()) {
            Character stackCh = stack.pop();
            if (stackCh =='(') {stack.push(stackCh); break;}
            if (priority.get(stackCh) >= priority.get(ch)) {
              out += stackCh;
              continue;
            }
            if (priority.get(stackCh) < priority.get(ch)) {
               break;
            }
        }
        stack.push(ch);
    }

    private void gotClosingParen() {
       while (!stack.isEmpty()) {
            Character sch = stack.pop();
            if (sch == '(') return;
            out += sch;
        }
    }

    public void setInfix(String infix) {
        in = infix;
        out = "";
    }


    public int calc() {
        boolean isDigit = false;
        StackA<Integer> stack = new StackA<>(out.length());
        String num = ""; // д многозначн чисел
        int num1, num2;
        for (int i=0; i<out.length(); i++) {
            Character ch = out.charAt(i);
            if (ch >= '0' && ch <= 9) {
                isDigit = true;
                num += ch;
            } else {
                stack.push(Integer.parseInt(num));
                num2 = stack.pop();
                num1 = stack.pop();
                switch (ch) {
                    case '-': stack.push(num1 - num2);
                    case '+': stack.push(num1 + num2);
                    case '*': stack.push(num1 * num2);
                    case '/': stack.push(num1 / num2);
                }
            }
        }
        return stack.pop();
    }

}
