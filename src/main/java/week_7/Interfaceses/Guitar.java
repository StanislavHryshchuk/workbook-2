package week_7.Interfaceses;

public class Guitar implements Playble{
    private String name;

    public Guitar(){}

    public Guitar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("Guitar is playing");
    }
}
