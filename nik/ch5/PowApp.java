package nik.ch5;

public class PowApp {
    public static void main(String[] args) {
        System.out.println(pow(3,3));
    }
    public static int pow(int x, int y){
        int res;
        if(y == 1 ) return x;
        res = pow(x * x, y/2);
        if(y % 2 == 1) {
            res = res * x;
        }
        return res;
    }
}
