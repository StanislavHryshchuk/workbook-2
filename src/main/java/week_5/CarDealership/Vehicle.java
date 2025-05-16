package week_5.CarDealership;

import java.util.Objects;

public class Vehicle {
    private String vinNumber;
    private int year;
    private String make;
    private String model;
    private String vehicleType;
    private String color;
    private double odometer;
    private double price;

    public Vehicle(String vinNumber,int year, String make, String model, String vehicleType, String color, double odometer, double price) {
        this.vinNumber = vinNumber;
        this.year = year;
        this.make = make;
        this.model = model;
        this.vehicleType = vehicleType;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getOdometer() {
        return odometer;
    }

    public void setOdometer(double odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(vinNumber, vehicle.vinNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vinNumber);
    }

    public String toFileString() {
        return vinNumber + "|" + year + "|" + make + "|" + model + "|" + vehicleType + "|" + color + "|" + odometer + "|" + price;
    }
}