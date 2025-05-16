package week_5.CarDealership;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Vehicle> inventory = new ArrayList<>();

    public Dealership(String name, String address, String phoneNumber){
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;

    }

    public List<Vehicle> getVehicleByThePriceRange(double minPrice, double maxPrice){
        List<Vehicle> vehiclesByPriceRange = new ArrayList<>();

        for (Vehicle vehicle: inventory){
            if (vehicle.getPrice() >= minPrice && vehicle.getPrice() <= maxPrice){
                vehiclesByPriceRange.add(vehicle);
            }
        }
        return vehiclesByPriceRange;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model){
        List<Vehicle> vehiclesByMakeModel = new ArrayList<>();
        for (Vehicle vehicle: inventory){

            if(vehicle.getMake().equalsIgnoreCase(make) && vehicle.getModel().equalsIgnoreCase(model)){
                vehiclesByMakeModel.add(vehicle);
            }
        }
        return vehiclesByMakeModel;
    }

    public List<Vehicle> getVehicleByYear(int minYear, int maxYear){
        List<Vehicle> vehiclesByYear = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if(vehicle.getYear() >= minYear && vehicle.getYear() <= maxYear){
                vehiclesByYear.add(vehicle);
            }
        }
        return vehiclesByYear;
    }

    public List<Vehicle> getVehicleByColor(String color){
        List<Vehicle> vehiclesByColor = new ArrayList<>();

        for(Vehicle vehicle: inventory){

            if(vehicle.getColor().equalsIgnoreCase(color)){
                vehiclesByColor.add(vehicle);
            }
        }
        return vehiclesByColor;
    }

    public List<Vehicle> getVehicleByMileage(double minMileage, double maxMileage){
        List<Vehicle> vehiclesByMileage = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if(vehicle.getOdometer() >= minMileage && vehicle.getOdometer()<= maxMileage ){
                vehiclesByMileage.add(vehicle);
            }
        }
        return vehiclesByMileage;
    }

    public List<Vehicle> getVehicleByType(String type){
        List<Vehicle> vehiclesByType = new ArrayList<>();

        for(Vehicle vehicle: inventory){
            if(vehicle.getVehicleType().equalsIgnoreCase(type)){
                vehiclesByType.add(vehicle);
            }
        }
        return vehiclesByType;
    }

    public List<Vehicle> getAllVehicle (){
        return inventory;
    }

    public void addVehicleToList(Vehicle vehicle){
        inventory.add(vehicle);
        try (FileWriter fw = new FileWriter(DealerShipFileManager.INVENTORY_FILENAME, true)) {
            fw.write(vehicle.toFileString() + "\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeVehicleFromListAndFile(Vehicle vehicle){
        inventory.remove(vehicle);

        DealerShipFileManager.saveTheDealership(this);
    }

    public String toFileString() {
        return   name + "|" + address + "|" + phoneNumber;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(List<Vehicle> inventory) {
       this.inventory = inventory;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
