package week_10.CarDealership;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;


public class UserInterface {
    private static Scanner scanner = new Scanner(System.in);
    private static DealershipDAO dealershipDAO;
    private static VehicleDAO vehicleDAO;
    private static UserPrompt prompt;

    public static void userMenu(String[] args){
        init(args);
        boolean userMenuRunning = true;
        while (userMenuRunning) {
            System.out.println("\n          *** Home Screen *** ");
            System.out.println("Please select a menu option from 1 - 9 | 0 -> Exit");
            System.out.println("""
                    1. User DAO Interface
                    2. Find vehicles by make/model.
                    3. Find vehicles by year range.
                    4. Find vehicles by color.
                    5. Find vehicles by mileage range.
                    6. Find vehicles by type(car, truck,SUV,van)
                    7. List all vehicles.
                    8. Add a vehicle.
                    9. Remove a vehicle.
                    10. Create a contract.
                    0. Exit.""");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());

                switch (userChoice) {
                    case 1:
                        userDAOInterface();
                        break;
                    case 2:
                        processByMakeModelRequest();
                        break;
                    case 3:
                        processByYearRequest();
                        break;
                    case 4:
                        processByColorRequest();
                        break;
                    case 5:
                        processByMileageRequest();
                        break;
                    case 6:
                        processByTypeRequest();
                        break;
                    case 7:
                        processAllVehicleRequest();
                        break;
                    case 8:
                        processAddVehicleRequest();
                        break;
                    case 9:
                        processRemoveVehicleRequest();
                        break;
                    case 10:
                        processContractInformationRequest();
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
                    4. Vehicles""");

            int userChoice = Integer.parseInt(scanner.nextLine().trim());
            switch (userChoice){
                case 1 -> dealershipDAOMenu();
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
                    case 1 -> dealershipDAO.printList(dealershipDAO.getAll());
                    case 2 -> dealershipDAO.add(prompt.createDealershipPrompt());
                    case 3 -> {
                        System.out.println("Please enter dealership ID:");
                        dealershipDAO.update(Integer.parseInt(scanner.nextLine().trim()),prompt.createDealershipPrompt());
                    }
                    case 4 -> {
                        System.out.println("Please enter dealership ID:");
                        dealershipDAO.remove(Integer.parseInt(scanner.nextLine().trim()));
                    }
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

    public static void

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
