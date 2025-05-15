package week_6.AmusementParkPasses;

public class Pass {
    private String holderName;
    private double basePrice;

    public Pass(String holderName, double basePrice) {
        this.holderName = holderName;
        this.basePrice = basePrice;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
    public double calculateFinalPrice(){
        return basePrice;
    }
}
