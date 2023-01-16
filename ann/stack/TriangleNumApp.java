package ann.stack;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TriangleNumApp {
    public static void main(String[] args) throws IOException {
        StackA<Integer> stack = new StackA(10000);
        int num;
        int answer = 0;

            System.out.println("enter a numbah");
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            String s = br.readLine();
            num = Integer.parseInt(s);

        //собственно вычисление треуг числа:
            while (num>0) {stack.push(num); num--;}
            while (!stack.isEmpty()) {int n = stack.pop(); answer+=n;}

        System.out.println(answer);


    }}





