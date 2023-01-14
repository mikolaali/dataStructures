package nik.ch4;

public class IosifFlaviy {
    private int count;
    private int start;
    public CycleList list;

    public IosifFlaviy(int peoples, int count, int start) {
        this.count = count;
        this.start = start;
        list = new CycleList();
        list.insert(1);
        for (int i = peoples; i > 1 ; i--) {
            list.insert(i);
        }
    }

    public void flaviyCalc(){
        while (!list.isEmpty()){
            for (int i = 1; i < count; i++) {
                list.next();
            }
            System.out.print(list.delete().data + " ");
            list.next();
        }
    }
    public void next(){
        for (int i = 0; i < count - 1; i++) {
            list.next();
        }
        list.current.displayNode();
    }
}
