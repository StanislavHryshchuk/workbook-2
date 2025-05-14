package week_6.CarInheritance;

public class Car extends Vehicle {
    private int numOfAxel;

    public Car (){
        super();
    }

    public Car(String make, String model, String color, int numWheels, String typeOfLicense, int numOfPeople, int numOfAxel) {
        super(make, model, color, numWheels, typeOfLicense, numOfPeople);
        this.numOfAxel = numOfAxel;
    }
}
