package week_6.AmusementParkPasses;

import java.util.ArrayList;
import java.util.List;

public class GroupBooking {
    private List<Pass> passes = new ArrayList<>();

    public void addPass(Pass pass) {
        this.passes.add(pass);
    }

    public void printSummary() {

        double totalRevenue = 0;
        for(Pass pass: passes){
            if(pass instanceof ChildPass){
                System.out.println(pass.getHolderName() + " " + pass.calculateFinalPrice());
                totalRevenue += pass.calculateFinalPrice();
            } else if (pass instanceof SeniorPass){
                System.out.println(pass.getHolderName() + " " + pass.calculateFinalPrice());
                totalRevenue += pass.calculateFinalPrice();
            } else {
                System.out.println(pass.getHolderName() + " " + pass.calculateFinalPrice());
                totalRevenue += pass.calculateFinalPrice();
            }
        }
        System.out.printf("Total cost of all purchsed passes is: %.2f", totalRevenue);
    }
}
