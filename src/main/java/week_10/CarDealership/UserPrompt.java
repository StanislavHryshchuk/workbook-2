package week_10.CarDealership;

import java.util.Optional;
import java.util.Scanner;

public class UserPrompt {
    private static Scanner scanner = new Scanner(System.in);

    public static Vehicle createVehiclePrompt(){

        Vehicle vehicle = new Vehicle();

        vehicle.setDealershipID(getInt("Please enter Dealership ID: "));

        vehicle.setVIN(getString("Please enter the VIN number: ").toUpperCase());

        vehicle.setYear(getInt("Please enter the year of production: "));

        vehicle.setMake(getString("Please enter the Make of the vehicle: "));

        vehicle.setModel(getString("Please enter the Model of the vehicle: "));

        vehicle.setType(getString("Please enter the Type of the vehicle: "));

        vehicle.setColor(getString("Please enter the Color of the vehicle: "));

        vehicle.setOdometer(getInt("Please enter the Odometer of the vehicle: "));

        vehicle.setPrice(getDouble("Please enter the Price of the vehicle: "));

        vehicle.setSold(getBoolean("Mark it as sold? (yes / no)"));

        return vehicle;
    }

    public static Dealership createDealershipPrompt(){
        Dealership dealership = new Dealership();

        dealership.setName(getString("Please enter dealership Name: "));

        dealership.setAddress(getString("Please enter dealership Address:"));

        dealership.setPhone(getString("Please enter dealership Phone:"));

        return dealership;
    }

    public static boolean getBoolean(String prompt){
        System.out.println(prompt);
        return scanner.nextLine().trim().equalsIgnoreCase("yes");
    }

    public static int getInt(String prompt){
        System.out.println(prompt);
        return Integer.parseInt(scanner.nextLine().trim());
    }

    public static String getString(String prompt){
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    public static double getDouble(String prompt){
        System.out.println(prompt);
        return Double.parseDouble(scanner.nextLine().trim());
    }
}
