package week_3.InventoryApp;

public class Product {
    private int id;
    private String name;
    private float price;

    public Product(int id, String name, float price) { this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public float getPrice() {
        return this.price;
    }

    public String toFileString() {
        return id + "|" + name + "|" + price;
    }
}
