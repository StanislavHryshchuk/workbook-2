package week_7.WorkinWithInterfaces;

public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String lastName;

    public Person(String name, int age, String lastName) {
        this.name = name;
        this.age = age;
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Override
    public int compareTo(Person o) {
        if (this.getLastName().equalsIgnoreCase(o.getLastName()) && this.getName().equalsIgnoreCase(o.getName())){
           return this.getAge() - o.getAge();
        } else if (this.getLastName().equalsIgnoreCase(o.getLastName())) {
            return this.getName().compareTo(o.getName());
        }

        return this.getLastName().compareTo(o.getLastName());
    }

}
