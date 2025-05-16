package week_5.CarDealership;

public class LeaseContract extends Contract {
    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, vehicle, customerName, customerEmail);
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
                "LEASE|%s|%s|%s|%s|%.2f|%.2f|%.2f",
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
