package data.people;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A class defining the Person object.
 */
public class Person implements Comparable<Person> {

    /** Person's name attribute. */
    private String mName;

    /** Person's age attribute. */
    private int mAge;

    /**
     * Person constructor.
     * @param name The name of the Person.
     * @param age The age of the Person.
     */
    public Person(String name, int age) {
        mName = name;
        mAge = age;
    }

    /**
     * Empty Person constructor.
     */
    public Person() {

    }

    /** Print person information in a single string. */
    public void printPersonInfo() {
        System.out.print(mName);
        System.out.print(" (");
        System.out.print(mAge);
        System.out.print(") ");

    }

    /** Default comparator. Sorts by name. */
    public int compareTo(Person that) {
        return this.getName().compareTo(that.getName());
    }

    /** Additional comparator. Sorts by age in descending order. */
    public static class ByAge implements Comparator<Person> {

        @Override
        public int compare(Person p1, Person p2) {
            if (p1.getAge() < p2.getAge()) return -1;
            if (p1.getAge() > p2.getAge()) return +1;
            return 0;
        }
    }

    /** Getters and Setters */

    /** Gets name. */
    public String getName() {
        return mName;
    }

    /** Sets name. */
    public void setName(String mName) {
        this.mName = mName;
    }

    /** Gets age. */
    public int getAge() {
        return mAge;
    }

    /** Sets age. */
    public void setAge(int age) {
        this.mAge = age;
    }

    public static void main(String[] args) {

        Person p1 = new Person("Bill", 52);
        Person p2 = new Person("Jill", 17);
        Person p3 = new Person("Anthony", 23);

        //p1.printPersonInfo();
        //p2.printPersonInfo();
        //p3.printPersonInfo();

        ArrayList<Person> people = new ArrayList<Person>();

        people.add(p1);
        people.add(p2);
        people.add(p3);

        for (Person p : people) {
            p.printPersonInfo();
        }
        System.out.println();

        Collections.sort(people);

        for (Person p : people) {
            p.printPersonInfo();
        }
        System.out.println();

        Collections.sort(people, new ByAge());

        for (Person p : people) {
            p.printPersonInfo();
        }
        System.out.println();

    }
}
