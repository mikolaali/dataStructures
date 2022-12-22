package data_structures.array;
class PersonArrApp {
    public static void main(String[] args) {
        PersonArr arr = new PersonArr(5);
        arr.insertEl("Pete","Pupkin",33 );
        arr.insertEl("Tyler","Durden",33 );
        arr.insertEl("Ali","Sagir",20 );
        arr.insertEl("John","Wick",58 );
        arr.insertEl("Pppp","Ffff",90 );
        arr.displayArr();
        System.out.println(arr.findEl("Wick"));
        System.out.println(arr.findEl("Rick"));
        System.out.println("Deleted person: "+arr.deleteEl("Sagir"));
        arr.displayArr();
        arr.insertSort();
        System.out.println("sorted by Last name");
        arr.displayArr();
    }
}


class Person {
    String FirstName;
    String LastName;
    int age;

    public Person(String firstName, String lastName, int age) {
        FirstName = firstName;
        LastName = lastName;
        this.age = age;
    }

    public String getLastName() {
        return LastName;
    }
}


class PersonArr {
    private Person[] a;
    int ElsAmount = 0;
    public PersonArr(int size) {a = new Person[size];}
    public void displayArr() {for (int i=0;i<ElsAmount;i++) {System.out.println(a[i].getLastName());}}

                   //Поиск
    public boolean findEl(String lastName) {
        for (Person p:a) {
            if(p.getLastName()==lastName){System.out.print(p.getLastName()+" is there: "); return true;}
        }
        System.out.print(lastName+" is not there: "); return false;}

                   //Вставка
    public void insertEl(String first, String last, int age) {
        a[ElsAmount]=new Person(first,last,age);
        ElsAmount++;
    }

                  //Удаление
    public boolean deleteEl(String lastName) {
        int j;
        for (j=0; j<ElsAmount;j++) {
            if (a[j].getLastName()==lastName)
                break;
        }
        if(j==ElsAmount) {return false;}
        else {int k; for (k=j;k<ElsAmount-1;k++) {a[k]=a[k+1];} a[ElsAmount-1]=null; ElsAmount--;return true;}
    }


                 //Сортировка вставкой по Фамилии
    public void insertSort() {
        for (int out=1;out<ElsAmount;out++) {
            Person t= a[out];
            int i = out;
            while (i>0 && a[i-1].getLastName().compareTo(t.getLastName())>0) {
                a[i] = a[i-1]; i--;
            } a[i] = t;
        }
    }


}