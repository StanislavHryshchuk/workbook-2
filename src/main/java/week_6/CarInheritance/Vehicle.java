package week_6.CarInheritance;

public class Vehicle {
    private String make;
    private String model;
    private String color;
    private int numWheels;
    private String typeOfLicense;
    private int numOfPeople;

   public Vehicle(){}

    public Vehicle(String make, String model, String color, int numWheels, String typeOfLicense, int numOfPeople) {
        this.make = make;
        this.model = model;
        this.color = color;
        this.numWheels = numWheels;
        this.typeOfLicense = typeOfLicense;
        this.numOfPeople = numOfPeople;
    }
}

