package week_6.ShoppingCartSystem;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private final double taxes = 0.21;
    private List<Product> items = new ArrayList<>();

    public List<Product> getItems() {
        return items;
    }

    public void addItem(Product product){
        this.items.add(product);
    }

    public void printReceipt(){
        System.out.println("In your cart:");
        for (Product product: items){
            if(product instanceof DiscountProduct){
                System.out.printf("%s: $%.2f%n",product.getName(), product.getFinalPrice());
            }else {
                System.out.printf("%s: $%.2f%n",product.getName(), product.getFinalPrice());
            }
        }
        System.out.printf("Total before taxes: %.2f%n",  sumOfProduct());
        System.out.printf("Tax amount: %.2f%n", sumOfProduct() * taxes);
        System.out.printf("Total after taxes: %.2f", sumWithTaxes(sumOfProduct()));

    }

    public double sumOfProduct (){
        double sum = 0;
        for (Product product: items){
            if(product instanceof DiscountProduct){
                sum+= product.getFinalPrice();
            }else {
                sum+= product.getFinalPrice();
            }
        }
        return sum;
    }

    public double sumWithTaxes(double sum){
        sum += sum * (1-taxes);
        return sum;
    }
}
