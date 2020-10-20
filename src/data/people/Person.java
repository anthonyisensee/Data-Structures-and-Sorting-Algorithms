package data.people;

/**
 * A class defining the Person object.
 */
public class Person {

    /** Person's name attribute. */
    public String mName;

    /** Person's age attribute. */
    public int age;

    /**
     * Person constructor.
     * @param name The name of the Person.
     * @param age The age of the Person.
     */
    public Person(String name, int age) {
        mName = name;
        age = age;
    }

    public Person() {

    }

    /** Print person information in a single string. */
    public void printPersonInfo() {
        System.out.print(mName);
        System.out.print(" (");
        System.out.print(age);
        System.out.print(") ");

    }

    public static void main(String[] args) {

        Person p1 = new Person("Bill", 52);
        Person p2 = new Person("Jill", 17);
        Person p3 = new Person("Anthony", 23);

        p1.printPersonInfo();
        p2.printPersonInfo();
        p3.printPersonInfo();

    }
}
