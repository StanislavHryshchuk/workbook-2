package week_7.Interfaceses;

public class Main {
    public static void main(String[] args) {
        Bird bird = new Bird();
        bird.fly();

        Guitar guitar = new Guitar();
        Piano piano = new Piano();
        guitar.play();
        piano.play();


        Document document = new Document();
        printAnything(document);
        document.print();

        Car car = new Car();
        Bicycle b = new Bicycle();
        Movable[] move = {car,b};
        for (Movable m : move){
            m.move();
        }
    }
    static void printAnything(Printable printable){
        System.out.println("Printing");
    }
}
