package ann.recursion;

public class AnagramApp {
    static int size;
    static int count;
    static char[] arr = new char[100];

    public static void main(String[] args) {
        String str = "wick";
        size = str.length();
        count = 0;
        for (int i=0; i<size; i++) {
            arr[i] = str.charAt(i);

        } doAnagram(size);
    }

//todo
    public static void doAnagram(int newSize) {
        if (newSize==1) return;
        int idx = size - newSize;
        for (int i=0; i<newSize; i++) {
            doAnagram(newSize-1);
            if (newSize==2) {displayWord();}
            rotate(idx);
        }
    }

    public static void rotate(int idx) {
        char t = arr[idx];
        for (int k=idx; k<size-1; k++) {
            arr[k] = arr[k+1];
        }
        arr[size-1] = t;
    }

    public static void displayWord() {
        for (int i=0; i<size; i++) {
            System.out.print(arr[i]);
        }
        System.out.println(" :: ");
    }
}
