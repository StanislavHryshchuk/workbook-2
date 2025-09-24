package week_10.CarDealership;

import org.apache.commons.dbcp2.BasicDataSource;
import week_5.CarDealership.PrintHelper;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;


public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static DealershipDAO dealershipDAO;
    private static VehicleDAO vehicleDAO;



    public static void userMenu(String[] args){
        init(args);
        boolean userMenuRunning = true;
        while (userMenuRunning) {
            System.out.println("\n          *** Home Screen *** ");
            System.out.println("Please select a menu option from 1 - 9 | 0 -> Exit");
            System.out.println("""
                    1. User DAO Interface
                    0. Exit.""");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());

                switch (userChoice) {
                    case 1:
                        userDAOInterface();
                        break;
                    case 0:
                        userMenuRunning = false;
                        break;
                    default:
                        System.out.println("Invalid input, please select from 1 - 9 | 0 -> Exit");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void userDAOInterface(){
        boolean userDAORunning = true;
        while (userDAORunning){
            System.out.println("Select the Table you want to work with.");
            System.out.println("""
                    1. Dealerships
                    2. Inventory
                    3. Sales Contracts
                    4. Vehicles
                    0. Back""");

            int userChoice = Integer.parseInt(scanner.nextLine().trim());
            switch (userChoice){
                case 1 -> dealershipDAOMenu();
                case 4 -> vehicleDAOMenu();
                case 0 -> {
                    System.out.println("Returning back to Home Screen...");
                    userDAORunning = false;
                }
                default -> System.out.println("Invalid input. Please try again");
            }
        }
    }

    public static void dealershipDAOMenu(){

        boolean dealershipDAOMenuRunning = true;
        try {
            while (dealershipDAOMenuRunning){
                System.out.println("Select from the following option.");
                System.out.println("""
                1. All dealerships
                2. Add dealership
                3. Update Dealership
                4. Remove Dealership
                0. Back
                """);
                int userChoice = Integer.parseInt(scanner.nextLine().trim());

                switch (userChoice){
//                    case 1 -> printList(dealershipDAO.getAll());

                    case 2 -> dealershipDAO.add(UserPrompt.createDealershipPrompt());

                    case 3 -> dealershipDAO.update(UserPrompt.getInt("Please enter dealership ID: "), UserPrompt.createDealershipPrompt());

                    case 4 -> dealershipDAO.remove(UserPrompt.getInt("Please enter dealership ID: "));

                    case 0 -> {
                        System.out.println("Bye");
                        dealershipDAOMenuRunning = false;
                    }
                    default -> System.out.println("Invalid input. Try again");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void vehicleDAOMenu(){
        boolean vehicleDAOMenuRunning = true;
        try{
            while (vehicleDAOMenuRunning){
                System.out.println("Select from the following option.");
                System.out.println("""
                1. All Vehicles.
                2. Add Vehicle.
                3. Update Price.
                4. Update Sold.
                5. Remove Vehicle.
                6. Find vehicles by price range.
                7. Find vehicles by make/model.
                8. Find vehicles by year range.
                9. Find vehicles by color.
                10. Find vehicles by mileage range.
                11. Find vehicles by type(car, truck,SUV,van)
                0. Back
                """);
                int userChoice = Integer.parseInt(scanner.nextLine().trim());

                switch (userChoice){
                    case 1 -> PrintHelper.listToTable(vehicleDAO.getAll());

                    case 2 -> vehicleDAO.add(UserPrompt.createVehiclePrompt());

                    case 3 -> vehicleDAO.updatePrice(
                            UserPrompt.getInt("Enter Vehicle ID: "),
                            UserPrompt.getDouble("Enter the price: "));

                    case 4 -> vehicleDAO.updateSold(
                            UserPrompt.getInt("Enter Vehicle ID: "),
                            UserPrompt.getBoolean("Type 'Yes' to mark Vehicle as Sold"));

                    case 5 -> vehicleDAO.remove(UserPrompt.getInt("Enter Vehicle ID: "));

                    case 6 -> PrintHelper.listToTable(
                            vehicleDAO.findVehiclesByPriceRange(
                                    UserPrompt.getDouble("Enter min Price: "),
                                    UserPrompt.getDouble("Enter max Price: ")));

                    case 7 -> PrintHelper.listToTable(
                            vehicleDAO.findVehicleByMakeModel(
                                UserPrompt.getString("Enter Make: "),
                                UserPrompt.getString("Enter Model: ")));

                    case 8 -> PrintHelper.listToTable(
                            vehicleDAO.findVehiclesByYearRange(
                                    UserPrompt.getInt("Enter min year: "),
                                    UserPrompt.getInt("Enter max year:")));

                    case 9 -> PrintHelper.listToTable(
                            vehicleDAO.findVehiclesByColor(
                                    UserPrompt.getString("Enter color of the Vehicle: ")));

                    case 10 -> PrintHelper.listToTable(
                            vehicleDAO.findVehiclesByMileageRange(
                                    UserPrompt.getInt("Enter min mileage: "),
                                    UserPrompt.getInt("Enter max mileage: ")));

                    case 11 -> PrintHelper.listToTable(
                            vehicleDAO.findVehiclesByType(
                                    UserPrompt.getString("Enter type of The Vehicle: ")));

                    case 0 -> {
                        System.out.println("Returning back to DAO Screen...");
                        vehicleDAOMenuRunning = false;
                    }
                    default -> System.out.println("Invalid input. Try again");
                }
            }
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
        }
    }

    public static void init(String[] args){
        if (args.length != 2){
            System.out.println("Need 2 arguments to work");
        }
        String username = args[0];
        String password = args[1];

        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl("jdbc:mysql://localhost:3306/dealership");

        dealershipDAO = new DealershipDAO(dataSource);
        vehicleDAO = new VehicleDAO(dataSource);
    }
}