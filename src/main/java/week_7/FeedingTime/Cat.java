package week_7.FeedingTime;

public class Cat implements Eater{
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void eat() {
        System.out.println(getName() + " the cat is eating");
    }
}
