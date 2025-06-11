package week_7.StreamsEx;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Person> yearUpFamily = new ArrayList<>();

        Person p1 = new Person("Stan", "Hryshchuk", 29);
        Person p2 = new Person("Linda", "Lazy", 15);
        Person p3 = new Person("Kabrea", "Missing", 12);
        Person p4 = new Person("Josh", "Nightshift", 45);
        Person p5 = new Person("Ridwan", "Gym", 85);

        yearUpFamily.add(p1);
        yearUpFamily.add(p2);
        yearUpFamily.add(p3);
        yearUpFamily.add(p4);
        yearUpFamily.add(p5);

        List<Person> sortedList = yearUpFamily.stream()
                .sorted((person,person1) -> person.getName().compareTo(person1.getName()))
                .peek(p -> System.out.println(p))
                .toList();

        System.out.println("********");

        yearUpFamily.stream()
                .sorted((person,person1) -> person.getAge() - (person1.getAge()))
                .peek(p -> System.out.println(p))
                .findFirst().orElse(null);

        System.out.println("********");

        List<Integer> intList = new ArrayList<>();
        intList.add(2);
        intList.add(12);
        intList.add(13);
        intList.add(16);
        intList.add(17);

        intList.stream()
                .filter(a -> a % 2 == 0)
                .map(a -> (int) Math.pow(a,2))
                .peek(a -> System.out.println(a))
                .toList();

        long count = intList.stream()
                .filter(a -> a % 2 == 0)
                .count();
        System.out.println(count);

        List<String> stringList = new ArrayList<>();
        stringList.add("Stan");
        stringList.add("Linda");
        stringList.add("Kabrea");
        stringList.add("Josh");
        stringList.add("Ridwan");

        stringList.stream()
                .filter(s -> s.length() < 6)
                .peek(s -> System.out.println(s.toUpperCase()))
                .toList();

        stringList.stream()
                .forEach(s -> System.out.println(s));

        int[] numbers = {2, 5, 10, 13, 20};

        NumberTester nr = a -> a % 2 == 0;

        for(int num: numbers){
            System.out.println(nr.test(num));
        }
    }
}
