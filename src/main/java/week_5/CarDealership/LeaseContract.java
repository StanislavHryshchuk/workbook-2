package week_5.CarDealership;

public class LeaseContract extends Contract {
    private double expectedEndinValue;
    private double leaseFee;
    private double monthlyPayment;
    public LeaseContract(String typeOfContract,String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(typeOfContract ,date, vehicle, customerName, customerEmail);
    }

    public LeaseContract (String typeOfContract, String date, String customerName, String customerEmail, Vehicle vehicle, double expectedEndingValue, double leaseFee, double monthlyPayment){
        super(typeOfContract, date, vehicle, customerName, customerEmail);
        this.expectedEndinValue = expectedEndingValue;
        this.leaseFee = leaseFee;
        this.monthlyPayment = monthlyPayment;
    }

    @Override
    public double getTotalPrice() {
        return getVehicle().getPrice() * 0.5 + getVehicle().getPrice() * 0.07;
    }

    @Override
    public double getMonthlyPayment() {
        return getVehicle().getPrice() * (0.04 / 12) / (1 - Math.pow(1 + (0.04 / 12),-36));
    }

    public double getExpectedEndingValue(){
        return getVehicle().getPrice() * 0.5;
    }

    public double getLeaseFee(){
        return getVehicle().getPrice() * 0.07;
    }
    @Override
    public String toFileString() {
        return String.format(
                "%s|%s|%s|%s|%s|%.2f|%.2f|%.2f",
                getTypeOfContract(),
                getDate(),
                getCustomerName(),
                getCustomerEmail(),
                getVehicle().toFileString(),
                getExpectedEndingValue(),
                getLeaseFee(),
                getMonthlyPayment()
        );
    }
}
