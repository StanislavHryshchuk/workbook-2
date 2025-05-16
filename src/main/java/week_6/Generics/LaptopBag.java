package week_6.Generics;

import java.util.ArrayList;
import java.util.List;

public class LaptopBag {
    private List<Laptop> items = new ArrayList<>();

    public List<Laptop> getItems() {
        return items;
    }

    public void addLaptop(Laptop laptop){
        this.items.add(laptop);
    }

    public void printContents(){
        for(Laptop laptop: items){
            System.out.println(laptop.toString());
        }
    }
}
