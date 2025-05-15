package week_6.AmusementParkPasses;

public class ChildPass extends Pass{
    private final double discount = 0.5;
    public ChildPass(String holderName, double basePrice) {
        super(holderName, basePrice);
    }
    @Override
    public double calculateFinalPrice(){
        return getBasePrice() * (1 - discount);
    }
}
