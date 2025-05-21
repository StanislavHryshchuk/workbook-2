package week_7.PortfolioApp;

import week_6.AssetManager.Asset;

import java.util.ArrayList;
import java.util.List;

public class Portfolio implements Valuable {
    private String name;
    private String owner;
    private List<Valuable> valuables = new ArrayList<>();

    public Portfolio(String name, String owner) {
        this.name = name;
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<Valuable> getAssets() {
        return valuables;
    }

   public void addAsset(Valuable valuable){
        this.valuables.add(valuable);
   }
   public double getValue(){
        double totalValue = 0;
        for (Valuable valuable: valuables){
            totalValue += valuable.getValue();
        }
        return totalValue;
   }

   public Valuable getMostValuable(){
        return null;
   }

   public Valuable getLeastValuable(){
        return null;
   }


}
