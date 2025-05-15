package week_6.AmusementParkPasses;

public class SeniorPass extends Pass{
    private final double discount = 0.3;
    public SeniorPass(String holderName, double basePrice) {
        super(holderName, basePrice);
    }

    public double calculateFinalPrice(){
        return getBasePrice() * (1 - discount);
    }
}
