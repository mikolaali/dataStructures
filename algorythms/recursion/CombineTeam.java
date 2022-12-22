package algorythms.recursion;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CombineTeam {
    static int num;
    static char[] letters = {'A', 'B', 'C', 'D', 'E', 'F'};
    public static void main(String[] args) throws IOException {
        System.out.println("enter a numbah of team members");
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        num= Integer.parseInt(s);
        System.out.println(getTeams(num));
    }

    public static int getTeams(int n) {
        if (num==1) {return n;}
        else {return n * getTeams(num-1);}
    }
}
