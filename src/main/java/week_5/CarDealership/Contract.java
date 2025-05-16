package week_5.CarDealership;

import java.time.LocalDate;
import java.util.Scanner;

public abstract class Contract {
    public Scanner scanner = new Scanner(System.in);
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicle;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String date, Vehicle vehicle, String customerName, String customerEmail) {
        this.date = date;
        this.vehicle = vehicle;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public abstract double getTotalPrice();

    public abstract String toFileString();

    public abstract double getMonthlyPayment();
}
