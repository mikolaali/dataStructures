package algorythms.recursion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberDegree {

    static int num;
    static int deg;
    public static void main(String[] args) throws IOException {
        System.out.println("enter a numbah");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        num= Integer.parseInt(s);
        System.out.println("enter a degree");
        String s2 = br.readLine();
        deg= Integer.parseInt(s2);
        System.out.println(getDegree(num, deg));
    }

    public static int getDegree(int n, int deg) {
           if (deg==1) {return n;}
           else {return n * getDegree(n,deg-1);}
    }

}
