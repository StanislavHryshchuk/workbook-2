package week_6.AmusementParkPasses;

public class AdultPass extends Pass{

    public AdultPass(String holderName, double basePrice) {
        super(holderName, basePrice);
    }
    public double calculateFinalPrice(){
        return getBasePrice();
    }
}
