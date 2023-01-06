package nik.arrays;

/**
 * The type Data array.
 */
public class DataArrayPerson {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        DataArr dataArr = new DataArr(20);
        dataArr.insertPerson("ivan", "petrov",33);
        dataArr.insertPerson("vlad", "sidorov",36);
        dataArr.insertPerson("sasa", "kozlov",45);
        System.out.println(dataArr.size());
        System.out.println(dataArr.getPersonByFirst("ivan"));
        System.out.println("================");
        dataArr.display();
        dataArr.deleteByNameOrLast("vlad");
        System.out.println(dataArr.size());
        dataArr.display();
    }
}


/**
 * The type Data arr.
 */
class DataArr{
    private Person[] persons;
    private int size;

    /**
     * Instantiates a new Data arr.
     *
     * @param max the max
     */
    DataArr(int max){
        persons = new Person[max];
        size = 0;
    }

    /**
     * Delete by name or last.
     *
     * @param firstOrLast the first or last
     */
    public void deleteByNameOrLast(String firstOrLast){
        for (int ind = 0; ind < size; ind++ ) {
            if(persons[ind].getFirst().equals(firstOrLast) || persons[ind].getLast().equals(firstOrLast)){
                size--;
                for( int j = ind; j < size ; j++){
                    persons[ind] = persons[ind + 1];
                }
                return;
            }
        }
        System.out.println("no such Person with firstOrLast: " + firstOrLast);
    }

    /**
     * Insert person.
     *
     * @param name the name
     * @param last the last
     * @param a    the a
     */
    public void insertPerson(String name, String last, int a){
        persons[size] = new Person(name,last,a);
        size++;
    }

    /**
     * Get person by first person.
     *
     * @param name the name
     * @return the person
     */
    public Person getPersonByFirst(String name){
        for ( Person person : persons ) {
            if( person.getFirst().equals(name)) {return person;}
        }
        return null;
    }

    /**
     * Get person by last person.
     *
     * @param last the last
     * @return the person
     */
    public Person getPersonByLast(String last){
        for ( Person person: persons ) {
            if(person.getLast().equals(last)){
                return person;
            }
        }
        return null;
    }

    /**
     * Size int.
     *
     * @return the int
     */
    public int size() {
        return size;
    }

    /**
     * Display.
     */
    public void display(){
        for ( int i = 0; i < size; i++ ) {
            System.out.println(persons[i]);
        }
    }
}

/**
 * The type Person.
 */
class Person{
    private String firstName;
    private String lastName;
    private int age;

    /**
     * Instantiates a new Person.
     *
     * @param first the first
     * @param last  the last
     * @param a     the a
     */
    Person(String first, String last, int a){
        firstName = first;
        lastName = last;
        age = a;
    }

    /**
     * Get last string.
     *
     * @return the string
     */
    public String getLast(){return lastName;}

    /**
     * Get first string.
     *
     * @return the string
     */
    public String getFirst(){return firstName;}

    /**
     * Get age int.
     *
     * @return the int
     */
    public int getAge(){return age;}

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}