package week_5.CarDealership;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DealerShipFileManager {
    public static String INVENTORY_FILENAME = "src\\main\\java\\week_5\\CarDealership\\resources\\inventory.csv";
    public static String DEALERSHIPS_FILENAME = "src\\main\\java\\week_5\\CarDealership\\resources\\listOfDealerships";

    public static Dealership getDealership(){

        String[] arrDealerShipInfo = null;
        List<Vehicle> vehicles = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(INVENTORY_FILENAME))){

            String dealerShipInfo = br.readLine();
            arrDealerShipInfo = dealerShipInfo.split("\\|");

            String line;
            while ((line = br.readLine())!= null){
                String[] arrVehicle = line.split("\\|");

                Vehicle vehicle = new Vehicle(arrVehicle[0],Integer.parseInt(arrVehicle[1]) ,arrVehicle[2],arrVehicle[3],arrVehicle[4],arrVehicle[5],Double.parseDouble(arrVehicle[6]),Double.parseDouble(arrVehicle[7]));

                vehicles.add(vehicle);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        Dealership dealership = new Dealership(arrDealerShipInfo[0],arrDealerShipInfo[1],arrDealerShipInfo[2]);
        dealership.setInventory(vehicles);

        return dealership;
    }

    public static Dealership getDealerShipByName(String dealershipName){

        Dealership dealership = null;

        try (BufferedReader br = new BufferedReader(new FileReader(DEALERSHIPS_FILENAME))){
            String line;
            while ((line = br.readLine())!= null){

                String[] arrDealerShipInfo = line.split("\\|");

                if (arrDealerShipInfo[0].equalsIgnoreCase(dealershipName)){
                    dealership = new Dealership(arrDealerShipInfo[0],arrDealerShipInfo[1],arrDealerShipInfo[2]);
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return dealership;
    }

    public static void saveTheDealership(Dealership dealership){
        List<Vehicle> inventory = dealership.getInventory();

        try(FileWriter fr = new FileWriter(INVENTORY_FILENAME)){
            fr.write(dealership.toFileString() + "\n");

            for (Vehicle vehicle: inventory){
                fr.write(vehicle.toFileString() + "\n");
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static void displayDealershipFile(){
        try (BufferedReader br = new BufferedReader(new FileReader(DEALERSHIPS_FILENAME))){
            String line;

            while ((line = br.readLine())!= null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static Dealership getRandomDealerShip(){
        int lineCount = 0;
        int randomNum = (int) (Math.random() * 10) + 1;
        String[] arrDealership = null;
        Dealership dealership = null;
        try (BufferedReader br = new BufferedReader(new FileReader(DEALERSHIPS_FILENAME))){
            String line;
            while((br.readLine()) != null){
                lineCount++;
            }
            if(randomNum == lineCount){
                while ((line = br.readLine()) != null){
                    arrDealership = line.split("\\|");
                    dealership = new Dealership(arrDealership[0],arrDealership[1],arrDealership[2]);
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        return dealership;
    }

    public static List<Vehicle> getVehiclesOfDealership(Dealership dealership){

        List<Vehicle> vehicles = new ArrayList<>();
        String[] arrVehicle = null;
        try (BufferedReader br = new BufferedReader(new FileReader(INVENTORY_FILENAME))){

            String line;
            while ((line = br.readLine())!= null){

                if(line.contains(dealership.getName())){
                    line = br.readLine();
                    arrVehicle =  line.split("\\|");

                    Vehicle vehicle = new Vehicle(arrVehicle[0],Integer.parseInt(arrVehicle[1]) ,arrVehicle[2],arrVehicle[3],arrVehicle[4],arrVehicle[5],Double.parseDouble(arrVehicle[6]),Double.parseDouble(arrVehicle[7]));

                    vehicles.add(vehicle);
                }
                if(line.)

            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        dealership.setInventory(vehicles);
        return vehicles;
    }
}


