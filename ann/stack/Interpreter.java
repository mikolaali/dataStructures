package ann.stack;
import java.util.HashMap;



class Interpreter {
    private StackA<Character> stack;
    private String in;
    private String out = "";
    private HashMap<Character, Integer> priority = new HashMap<>() {{
        put('+', 1); put('-', 1); put('*', 2); put('/', 2);
    }};
    public String getPostfix() {
        return out;
    }
    public Interpreter(String s) {
        in = s;
        stack = new StackA(s.length());
    }

    public String translate() {
        boolean num = false;
        for (int i = 0; i< in.length(); i++) {
            char ch = in.charAt(i);
            switch (ch) {
                case '+': case '-': gotOper(ch, 1); out += " "; break;
                case '*': case '/': gotOper(ch, 2); out += " ";break;
                case '(': stack.push(ch); out += " "; break;
                case ')': gotClosingParen(); break;
                case ' ': break;
                default: out += ch;
                    break;
            }
        }
        while (!stack.isEmpty()) {
            out += stack.pop();
        }
        return out;
    }

    private void gotOper(Character ch, int p) {
        while (!stack.isEmpty()) {
            Character stackCh = stack.pop();
            if (stackCh =='(') {
                stack.push(stackCh); break;
            }
            if (priority.get(ch) <= priority.get(stackCh)) {
                out += stackCh;
                continue;
            }
            if (priority.get(stackCh) < priority.get(ch)) {
                stack.push(stackCh);
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
        String num = "";
        int num1, num2;
        for (int i=0; i<out.length(); i++) {
            Character ch = out.charAt(i);
            if (ch >= '0' && ch <= '9') {
                isDigit = true;
                num += ch;
                continue;
            }
            else if (ch == ' ') {
                if (!isDigit) {continue;}
                stack.push(Integer.parseInt(num));
                num = "";
                isDigit = false;
            }
            else {
                if (isDigit) {stack.push(Integer.parseInt(num)); num = ""; isDigit = false;}
                num2 = stack.pop();
                num1 = stack.pop();
                switch (ch) {
                    case '-': stack.push(num1 - num2); break;
                    case '+': stack.push(num1 + num2); break;
                    case '*': stack.push(num1 * num2); break;
                    case '/': stack.push(num1 / num2); break;
                }
            }
        }
        return stack.pop();
    }

}

