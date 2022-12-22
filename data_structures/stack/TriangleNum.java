package data_structures.stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TriangleNum {
    static StackT stackT;
    static int num;
    static int answer;
    public static void main(String[] args) throws IOException {
        System.out.println("enter a numbah");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        num= Integer.parseInt(s);
    getTriangleNum();
        System.out.println(answer);
    }
public static void getTriangleNum() {
        stackT = new StackT(10000);
        answer = 0;
        while (num>0) {stackT.push(num); num--;}
        while (!stackT.isEmpty()) {int n = stackT.pop(); answer+=n;}

    }

    public static boolean step() {
        return false;
    }
}




class StackT {
    private int[] stack;
    private int size;
    private int top;

    public StackT(int s) {
        size = s;
        top = -1;
    }
    public void push(int num) {
        stack[++top] = num;
    }
    public int pop() {
        return stack[top--];
    }
    public int read() {
        return stack[top];
    }
    public boolean isEmpty() {return (top==-1);}


}
