package ann.stack;

public class ReverseStrApp {
    public static void main(String[] args) {
        //РЕВЕРС СТРОКИ
        String s = "gnirts nruteR";
        String sOut = "";
        StackA<Character> stck = new StackA(s.length());
        for (int i=0;i<s.length();i++) {
            stck.push(s.charAt(i));
        }
        for (int i=0;i<s.length();i++) {
            sOut+=stck.pop();
        }
        System.out.println(sOut);
    }
}
