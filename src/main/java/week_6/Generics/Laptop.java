package week_6.Generics;

public class Laptop {
    private String brand;

    public Laptop(String brand) {
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString(){
       return   "Laptop: " + getBrand();
    }
}
