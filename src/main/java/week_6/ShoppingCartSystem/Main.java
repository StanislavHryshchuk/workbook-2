package week_6.ShoppingCartSystem;

public class Main {
    public static void main(String[] args) {

        Product apple = new Product("Apple", 0.99);
        Product banana = new Product("Banana", 3.99);
        DiscountProduct potato = new DiscountProduct("Potato",2.99,0.1);
        DiscountProduct pineapple = new DiscountProduct("Pineapple", 7.56,0.15);

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(apple);
        shoppingCart.addItem(banana);
        shoppingCart.addItem(potato);
        shoppingCart.addItem(pineapple);

        shoppingCart.printReceipt();

    }
}
