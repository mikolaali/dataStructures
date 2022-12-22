// not working
package algorythms.recursion;  //todo
public class RucksacPack {
    public static void main(String[] args) {

    }
public static int[] weights = {11, 8, 7, 6, 5};


public static void pack(int aim, int i) {
    if (i<weights.length) {pack(aim+weights[i],i+1);}
    else if (weights[i]==aim) {System.out.println(weights[i]);return;}
    else {pack(aim-weights[i],i+1);}
}
}



