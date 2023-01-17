package ann.stack;

public class CycleListApp {
    public static void main(String[] args) {
        CycleList cycleList = new CycleList();
        cycleList.insert(77);
        cycleList.insert(88);
        cycleList.insert(55);
        cycleList.insert(11);
        cycleList.display();
        System.out.println(cycleList.find(88));
        cycleList.delete(77);
        cycleList.delete(22);
        cycleList.display();
    }
}
