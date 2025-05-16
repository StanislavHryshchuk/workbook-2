package week_5.CarDealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class DealerShipFileManager {

    public static String INVENTORY_FILENAME;
    public static String DEALERSHIPS_FILENAME = "src\\main\\java\\week_5\\CarDealership\\resources\\listOfDealerships";

    public static void displayDealershipFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(DealerShipFileManager.DEALERSHIPS_FILENAME))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Dealership getDealerShipByName(String dealershipName) {
        Dealership dealership = null;

        try (BufferedReader br = new BufferedReader(new FileReader(DEALERSHIPS_FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] arrDealerShipInfo = line.split("\\|");
                if (arrDealerShipInfo[0].equalsIgnoreCase(dealershipName)) {
                    dealership = new Dealership(arrDealerShipInfo[0], arrDealerShipInfo[1], arrDealerShipInfo[2]);
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        getInventoryOfDealership(dealership);
        if(dealership != null){
            INVENTORY_FILENAME = "src\\main\\java\\week_5\\CarDealership\\resources\\DealershipInventory\\" + dealership.getName() + " Inventory.csv";
        }

        return dealership;
    }

    public static void saveTheDealership(Dealership dealership) {
        List<Vehicle> inventory = dealership.getInventory();

        try (FileWriter fr = new FileWriter(INVENTORY_FILENAME)) {
            fr.write(dealership.toFileString() + "\n");
            for (Vehicle vehicle : inventory) {
                fr.write(vehicle.toFileString() + "\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void getInventoryOfDealership(Dealership dealership) {

        try (BufferedReader br = new BufferedReader(new FileReader(INVENTORY_FILENAME))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] arrVehicleInfo = line.split("\\|");
                Vehicle vehicle = new Vehicle(arrVehicleInfo[0], Integer.parseInt(arrVehicleInfo[1]), arrVehicleInfo[2], arrVehicleInfo[3], arrVehicleInfo[4], arrVehicleInfo[5], Double.parseDouble(arrVehicleInfo[6]), Double.parseDouble(arrVehicleInfo[7]));

                dealership.getInventory().add(vehicle);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}