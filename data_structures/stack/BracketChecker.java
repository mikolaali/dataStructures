package data_structures.stack;
class BracketsApp {
    public static void main(String[] args) {
        BracketChecker bracketChecker=new BracketChecker(
                "{InputS(Sys; new B(isr); ine(); return s;}");
        bracketChecker.checkBrackets();
    }
}


public class BracketChecker {
    String string;
    public BracketChecker(String string) {
        this.string = string;
    }
    public void checkBrackets() {
        StackX stackX = new StackX(string.length());
        for (int i=0;i<string.length();i++) {
            char t = string.charAt(i);
            switch (t) {
                case '[': case '{': case '(':
                stackX.push(t); break;
                case ']': case '}': case ')':
                    if (!stackX.isEmpty()) {
                        char charX = stackX.pop();
                        if (t==']' && charX!='[' || t=='}' && charX!='{' || t==')' && charX!='(')
                        {
                            System.out.println("error "+t+" at "+i);
                        }
                    } break;
                default: break;
            }
        }
        if (!stackX.isEmpty()) System.out.println("missing the right bracket");
    }

}


