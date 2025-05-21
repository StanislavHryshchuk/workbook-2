package week_7.WorkinWithInterfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("Stan", 29,"Hryshchuk");
        Person p1 = new Person("Maaike", 28, "Putten");
        Person p2 = new Person("Stan", 26, "Hryshchuk");
        Person p3 = new Person("Paulo", 30, "Chuna");
        Person p4 = new Person("Stan", 28, "Hryshchuk");

        List<Person> personList = new ArrayList<>();
        personList.add(p);
        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);


        for (Person person: personList){
            System.out.println(person.getLastName() + " " +  person.getName() + " " + person.getAge());
        }

        Collections.sort(personList);

        for (Person person:personList){
            System.out.println(person.getLastName() + " " +  person.getName()+ " " + person.getAge() );
        }
    }
}
