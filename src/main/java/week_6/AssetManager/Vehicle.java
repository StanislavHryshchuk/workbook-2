package week_6.AssetManager;

import java.time.LocalDate;

public class Vehicle extends Asset{
    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public double getValue(){
        int yearsOld = LocalDate.now().getYear() - year;
        double percentOfReduction = 0;
        if(yearsOld <= 3){
            percentOfReduction = 0.03;
        }
        else if (yearsOld <= 6){
            percentOfReduction = 0.06;
        }
        else if (yearsOld <= 10){
            percentOfReduction = 0.08;
        }

        return calculatePriceVehicle(yearsOld, percentOfReduction);
    }

    public double calculatePriceVehicle (int yeasOld, double percentOfReduction){

        double baseCost = getOriginalCost() * (1 - yeasOld * percentOfReduction);
        boolean isHighMileage = getOdometer() > 100000 && !makeModel.contains("Honda") && !makeModel.contains("Toyota");

        if (isHighMileage && yeasOld > 10 ){
            return 750;
        } else if (yeasOld > 10) {
            return 1000;
        }
        if(isHighMileage){
            baseCost *= 0.75;
        }
        return baseCost;
    }
}
