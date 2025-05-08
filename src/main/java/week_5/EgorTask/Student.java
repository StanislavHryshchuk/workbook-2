package week_5.EgorTask;

public class Student {
    String age;
    String name;

    public Student(String age, String name){
        this.age = age;
        this.name =name;
    }

    public void details(){

         System.out.println("Student age is: " + age + " and name: " + name);
    }


}
