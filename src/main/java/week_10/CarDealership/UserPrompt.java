package week_10.CarDealership;

import java.util.Optional;
import java.util.Scanner;

public class UserPrompt {
    private static Scanner scanner = new Scanner(System.in);


    public String getUserDealershipId(){
        return scanner.nextLine();
    }

    public Vehicle createVehiclePrompt(){

        Vehicle vehicle = new Vehicle();

        System.out.println("Please enter Dealership ID:");
        vehicle.setDealershipID(Integer.parseInt(scanner.nextLine().trim()));

        System.out.println("Please enter the VIN number:");
        vehicle.setVIN(scanner.nextLine().trim().toUpperCase());

        System.out.println("Please enter the year of production:");
        vehicle.setYear(Integer.parseInt(scanner.nextLine().trim()));

        System.out.println("Please enter the Make of the vehicle:");
        vehicle.setMake(scanner.nextLine().trim());

        System.out.println("Please enter the Model of the vehicle:");
        vehicle.setModel(scanner.nextLine().trim());

        System.out.println("Please enter the Type of the vehicle:");
        vehicle.setType(scanner.nextLine().trim());

        System.out.println("Please enter the Color of the vehicle:");
        vehicle.setColor(scanner.nextLine().trim());

        System.out.println("Please enter the Odometer of the vehicle:");
        vehicle.setOdometer(Integer.parseInt(scanner.nextLine().trim()));

        System.out.println("Please enter the Price of the vehicle:");
        vehicle.setPrice(Double.parseDouble(scanner.nextLine().trim()));

        System.out.println("Mark it as sold? (yes / no)");
        vehicle.setSold(scanner.nextLine().trim().equalsIgnoreCase("yes"));

        return vehicle;
    }

    public Vehicle updatePricePrompt(){

        Vehicle vehicle = new Vehicle();

        System.out.println("Please enter Vehicle ID:");
        vehicle.setId(Integer.parseInt(scanner.nextLine().trim()));

        System.out.println("Please enter the Price of the vehicle:");
        vehicle.setPrice(Double.parseDouble(scanner.nextLine().trim()));

        return vehicle;
    }

    public Dealership createDealershipPrompt(){
        Dealership dealership = new Dealership();

        System.out.println("Please enter dealership Name:");
        dealership.setName(scanner.nextLine().trim());

        System.out.println("Please enter dealership Address:");
        dealership.setAddress(scanner.nextLine().trim());

        System.out.println("Please enter dealership Phone:");
        dealership.setPhone(scanner.nextLine().trim());

        return dealership;
    }
}
