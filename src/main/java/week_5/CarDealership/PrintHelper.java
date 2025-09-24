package week_5.CarDealership;

import week_10.CarDealership.Vehicle;

import java.util.List;

public class PrintHelper {

    public static void listToTable(List<Vehicle> vehicleList){

        if (vehicleList.isEmpty()){
            System.out.println("No matches found");
        }else{
            System.out.printf ("""
                %12s | %10s | %17s | %10s | %10s | %4s | %6s | %7s | %10s | %12s | %4s |
                --------------------------------------------------------------------------------------------
                """,
                    "DealershipID", "VehicleID", "VIN", "Make", "Model", "Year", "Type", "Color", "Odometer", "Price", "Sold");
            for ( Vehicle v : vehicleList) {
                System.out.printf("| %12d | %10d | %-17s | %-10s | %-10s | %4d | %-6s | %-7s | %,10d | $%,10.2f | %-4s |\n",
                        v.getDealershipID(),
                        v.getId(),
                        v.getVIN(),
                        v.getMake(),
                        v.getModel(),
                        v.getYear(),
                        v.getType(),
                        v.getColor(),
                        v.getOdometer(),
                        v.getPrice(),
                        v.isSold() ? "Yes" : "No");
            }
        }
    }
}
