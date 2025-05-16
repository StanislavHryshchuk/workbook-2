package week_5.CarDealership;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private Dealership dealership;

    public UserInterface(){}

    public void display(){
        userMenu();
    }

    public void userMenu(){
        selectDealership();
        boolean running = true;
        while (running) {
            System.out.println("\n          *** Home Screen *** ");
            System.out.println("Please select a menu option from 1 - 9 | 0 -> Exit");
            System.out.println("""
                    1. Find the vehicle within a price range.
                    2. Find vehicles by make/model.
                    3. Find vehicles by year range.
                    4. Find vehicles by color.
                    5. Find vehicles by mileage range.
                    6. Find vehicles by type(car, truck,SUV,van)
                    7. List all vehicles.
                    8. Add a vehicle.
                    9. Remove a vehicle.
                    0. Exit.""");
            try {
                int userChoice = Integer.parseInt(scanner.nextLine());

                switch (userChoice) {
                    case 1:
                        processPriceByRequest();
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
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid input, please select from 1 - 9 | 0 -> Exit");
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void processPriceByRequest(){
        System.out.println("Please enter the starting price:");
        double minPrice = Double.parseDouble(scanner.nextLine().trim());

        System.out.println("Please enter the end price:");
        double maxPrice = Double.parseDouble(scanner.nextLine().trim());

        displayList(dealership.getVehicleByThePriceRange(minPrice,maxPrice));
    }

    public void processByMakeModelRequest(){
        System.out.println("Please enter the Make:");
        String userMake = scanner.nextLine().trim();
        System.out.println("Please enter the Model:");
        String userModel = scanner.nextLine().trim();

        displayList(dealership.getVehicleByMakeModel(userMake,userModel));
    }

    public void processByYearRequest(){
        System.out.println("Please enter the starting year:");
        int startYear = Integer.parseInt(scanner.nextLine().trim());
        System.out.println("Please enter the end year:");
        int endYear = Integer.parseInt(scanner.nextLine().trim()) ;

        displayList(dealership.getVehicleByYear(startYear,endYear));
    }

    public void processByColorRequest(){
        System.out.println("Please enter the color:");
        String colour = scanner.nextLine().trim();

        displayList(dealership.getVehicleByColor(colour));
    }

    public void processByMileageRequest(){
        System.out.println("Please enter the min mileage:");
        double minMileage = Double.parseDouble(scanner.nextLine().trim());
        System.out.println("Please enter the max mileage:");
        double maxMileage = Double.parseDouble (scanner.nextLine().trim());

        displayList(dealership.getVehicleByMileage(minMileage,maxMileage));
    }

    public void processByTypeRequest(){
        System.out.println("Please enter the type of the vehicle:");
        String vehicleType = scanner.nextLine().trim();

        displayList(dealership.getVehicleByType(vehicleType));
    }

    public void processAllVehicleRequest(){
        displayList( dealership.getAllVehicle());
    }

    public void processAddVehicleRequest(){

        System.out.println("Please enter the VIN number");
        String vinNumber = scanner.nextLine().trim().toUpperCase();

        System.out.println("Please enter the year of production:");
        int yearOfCar = Integer.parseInt(scanner.nextLine().trim());

        System.out.println("Please enter the Make of the vehicle:");
        String vehicleMake = scanner.nextLine().trim();

        System.out.println("Please enter the Model of the vehicle:");
        String vehicleModel = scanner.nextLine().trim();

        System.out.println("Please enter the Type of the vehicle:");
        String vehicleType = scanner.nextLine().trim();

        System.out.println("Please enter the Color of the vehicle:");
        String vehicleColor = scanner.nextLine().trim();

        System.out.println("Please enter the Odometer of the vehicle:");
        double vehicleOdometer = Double.parseDouble(scanner.nextLine().trim());

        System.out.println("Please enter the Price of the vehicle:");
        double vehiclePrice = Double.parseDouble(scanner.nextLine());

        dealership.addVehicleToList(new Vehicle(vinNumber,yearOfCar,vehicleMake,vehicleModel,vehicleType,vehicleColor,vehicleOdometer,vehiclePrice));
    }

    public void processRemoveVehicleRequest(){
        System.out.println("Please enter the VIN number");
        String vinNumber = scanner.nextLine().trim();

        dealership.removeVehicleFromListAndFile(vinNumber);
    }

    public void displayList(List<Vehicle> vehicles) {

        for (Vehicle vehicle : vehicles) {
            System.out.printf("%s | %s | %s | %s | %s | %s | %.2f | %.2f%n", vehicle.getVinNumber(),vehicle.getYear(),vehicle.getMake(),vehicle.getModel(),vehicle.getVehicleType(),vehicle.getColor(),vehicle.getOdometer(),vehicle.getPrice());
        }
    }

    public void selectDealership(){

        DealerShipFileManager.displayDealershipFile();

        System.out.println("Enter the name of Dealership:");
        String userDealership = scanner.nextLine().trim().toLowerCase().replaceAll("\\s{2,}", " ");

        dealership = DealerShipFileManager.getDealerShipByName(userDealership);

    }

}


