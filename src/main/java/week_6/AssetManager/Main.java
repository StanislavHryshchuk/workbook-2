package week_6.AssetManager;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Asset> assets = new ArrayList<>();

        House houseHawaii = new House("Hawaii House", "2025", 1500000, "111 Best Street", 1, 4225, 174240);

        House houseCabo = new House("Cabo House", "2024", 700000, "111 Best Street", 2, 3500, 130680);

        Vehicle vehicleHawaii = new Vehicle("Hawaii Vehicle", "2025", 310500, "Audi RS 6", 2020, 50000);

        Vehicle vehicleCabo = new Vehicle("Cabo Vehicle", "2024", 85500, "BMW X6", 2020, 55000);

        assets.add(houseHawaii);
        assets.add(houseCabo);
        assets.add(vehicleHawaii);
        assets.add(vehicleCabo);

        for (Asset asset: assets){
            if (asset instanceof House){
                System.out.println(asset.getDescription() + "\n" + asset.getValue());
            }
            if (asset instanceof Vehicle){
                System.out.println(asset.getDescription() + "\n" + asset.getValue());
            }
        }
    }
}
