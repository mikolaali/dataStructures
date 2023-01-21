package ann.recursion;

public class TowerApp {
    public static void main(String[] args) {
        tower(4, 1, 2, 3);
    }

    public static void tower(int amount, int first, int mid, int third) {
        if (amount==1) {
            System.out.println("Smallest disk from "+ first +" to " + third);
        }
        else {
            tower(amount-1, first, third, mid);  //перекладываем пирамиду на свободный (2 пин)
            System.out.println("Disk №"+amount+ " from "+ first +" to " + third); //нижний диск на нужный пин (3 пин)
            tower(amount-1, mid, first, third);  //переклад на нужный (3)
        }
    }
}
// before recursion call
// push in stack (Retuern adress : tower(int amount, int first, int mid, int third))

