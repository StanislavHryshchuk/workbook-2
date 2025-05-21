package week_7.FeedingTime;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog("Monster");
        Cat cat = new Cat("Little Monster");

        List<Eater> eaters = new ArrayList<>();
        eaters.add(dog);
        eaters.add(cat);

        for(Eater e:eaters){
            e.eat();
        }
    }


}
