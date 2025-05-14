package week_6.ShoppingCartSystem;

public class DiscountProduct extends Product {
    private double discountPercentage;

    public DiscountProduct(String name, double price, double discountPercentage) {
        super(name, price);
        this.discountPercentage = discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
    @Override
    public double getFinalPrice(){
        return getPrice() * (1 - discountPercentage);
    }
}
