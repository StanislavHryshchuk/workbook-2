package week_6.Generics;

public class Main {
    public static void main(String[] args) {
        Laptop laptop = new Laptop("Apple");
        Laptop laptop1 = new Laptop("Lenovo");
        Laptop laptop2 = new Laptop("Microsoft");

        LaptopBag laptopBag = new LaptopBag();
        laptopBag.addLaptop(laptop);
        laptopBag.addLaptop(laptop1);
        laptopBag.addLaptop(laptop2);

//        laptopBag.printContents();


        Chihuahua chihuahua = new Chihuahua("Bolita");
        Chihuahua chihuahua1 = new Chihuahua("Kosita");

        ChihuahuaBag chihuahuaBag = new ChihuahuaBag();
        chihuahuaBag.addChihuahua(chihuahua);
        chihuahuaBag.addChihuahua(chihuahua1);

//        chihuahuaBag.printContents();

        Bag<Laptop> bag = new Bag<>();
        bag.add(laptop1);
        bag.add(laptop2);
        bag.add(laptop);
        Bag<String> bag2 = new Bag<>();


        bag2.add("Stan");
        Bag<Chihuahua> bag1 = new Bag<>();
        bag1.add(chihuahua);
        bag1.add(chihuahua1);

        bag.printItem();
        bag1.printItem();
        bag2.printItem();

        System.out.println(bag.getFirst());
        System.out.println(bag1.getFirst());
    }



}
