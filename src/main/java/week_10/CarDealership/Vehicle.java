package week_10.CarDealership;

import java.util.List;

public class Vehicle {
    private int dealershipID;
    private int id;
    private String VIN;
    private String make;
    private String model;
    private int year;
    private String type;
    private String color;
    private int odometer;
    private double price;
    private boolean sold;

    public Vehicle(){};

    public Vehicle(int dealershipID, int id, String VIN, String make, String model, int year, String type, String color, int odometer, double price, boolean sold) {
        this.dealershipID = dealershipID;
        this.id = id;
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.year = year;
        this.type = type;
        this.color = color;
        this.odometer = odometer;
        this.price = price;
        this.sold = sold;
    }

    public int getDealershipID() {
        return dealershipID;
    }

    public void setDealershipID(int dealershipID) {
        this.dealershipID = dealershipID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }



    @Override
    public String toString() {
        return String.format("""
            
            --- Vehicle Details ---
            
            Dealership ID : %d
            Vehicle ID    : %d
            VIN           : %s
            Make          : %s
            Model         : %s
            Year          : %d
            Type          : %s
            Color         : %s
            Odometer      : %,d miles
            Price         : $%,.2f
            Sold          : %s
            """,
                dealershipID, id, VIN, make, model, year, type, color, odometer, price, sold ? "Yes" : "No");
    }
}
