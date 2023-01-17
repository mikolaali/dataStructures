package ann.stack;


class BracketChecker {
    public static void main(String[] args) {
        String str = "{InputS(Sys; new B(isr); ine(); return s;}";
        StackA<Character> stackA = new StackA<>(str.length());
        for (int i=0;i<str.length();i++) {
            char t = str.charAt(i);
            switch (t) {
                case '[': case '{': case '(':
                    stackA.push(t); break;
                case ']': case '}': case ')':
                    if (!stackA.isEmpty()) {
                        char charX = stackA.pop();
                        if (t==']' && charX!='[' || t=='}' && charX!='{' || t==')' && charX!='(')
                        {
                            System.out.println("U ave an error "+t+" at symbol "+i);
                        }
                    } break;
                default: break;
            }
        }
        if (!stackA.isEmpty()) {System.out.println("Missing the right bracket");}
        else {System.out.println("OK");}

    }
}




