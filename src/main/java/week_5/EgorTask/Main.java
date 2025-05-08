package week_5.EgorTask;

public class Main {
    public static void main(String[] args) {
        Student s1 = new Student("22","Stas");
        s1.details();

        School school = new School();
        school.admitStudent(s1);
    }
}
