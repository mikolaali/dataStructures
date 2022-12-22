package algorythms;

public class AnagramApp {
    static int size;
    static int count;
    static char[] arr = new char[100];

    public static void main(String[] args) {
        String str = "wick";
        size = str.length();
        count = 0;
        for (int i=0;i<size;i++) {
            arr[i] = str.charAt(i);
            doAnagram(size);
        }
    }

    public static void doAnagram(int size) {

    }
}
