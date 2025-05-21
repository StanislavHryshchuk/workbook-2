package week_7.LetThemSpeak;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        Robot robot = new Robot();
        Parrot parrot = new Parrot();
        List<Speakable> speak = new ArrayList<>();

        speak.add(human);
        speak.add(robot);
        speak.add(parrot);

        for (Speakable s: speak){
            s.speak();
            LocalDateTime dateTime = LocalDateTime.now();

            System.out.println(dateTime.getHour());
            LocalDate date = LocalDate.now();

            System.out.println(date.getDayOfMonth());
        }
        System.out.println(speak.get(0));
    }
}
