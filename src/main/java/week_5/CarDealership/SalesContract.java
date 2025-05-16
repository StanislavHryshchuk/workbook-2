package week_5.CarDealership;

public class SalesContract extends Contract {

    private double recordingFee = 100;
    private boolean financeQuestion;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicle, boolean financeQuestion) {
        super(date, vehicle, customerName, customerEmail);
        this.financeQuestion = financeQuestion;

    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public boolean isFinanceQuestion() {
        return financeQuestion;
    }

    public void setFinanceQuestion(boolean financeQuestion) {
        this.financeQuestion = financeQuestion;
    }

    @Override
    public String toFileString() {
        String financeStatus = isFinanceQuestion() ? "YES" : "NO";
        return String.format(
                "SALE|%s|%s|%s|%s|%.2f|%.2f|%.2f|%.2f|%s|%.2f",
                getDate(),
                getCustomerName(),
                getCustomerEmail(),
                getVehicle().toFileString(),
                calculateSalesTaxAmount(),
                recordingFee,
                processingFee(),
                getTotalPrice(),
                financeStatus,
                getMonthlyPayment()
        );
    }

    @Override
    public double getTotalPrice() {
        return getVehicle().getPrice() + calculateSalesTaxAmount() + processingFee() + recordingFee;
    }

    @Override
    public double getMonthlyPayment() {
       if (!financeQuestion){
           return 0;
       }
        if (getVehicle().getPrice() >= 10000){
            return getVehicle().getPrice() * (0.0425 / 12) / (1 - Math.pow(1 + (0.0425 / 12),-48));
       }else {
            return getVehicle().getPrice() * (0.0525 / 12) / (1 - Math.pow(1 + (0.0525 / 12),-24));
       }
    }

    public double calculateSalesTaxAmount (){
        return getVehicle().getPrice() * 0.05;
    }

    public double processingFee() {
        double processingFee = 0;
        if (getVehicle().getPrice() <= 10000){
            processingFee += 295;
        }else {
            processingFee += 495;
        }
        return processingFee;
    }
}
