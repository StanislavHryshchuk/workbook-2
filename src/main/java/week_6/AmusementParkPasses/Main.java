package week_6.AmusementParkPasses;

public class Main {
    public static void main(String[] args) {

        ChildPass childPass = new ChildPass("Stan", 120);
        AdultPass adultPass = new AdultPass("Linda", 120);
        SeniorPass seniorPass = new SeniorPass("Kabrea", 120);

        GroupBooking groupBooking = new GroupBooking();
        groupBooking.addPass(childPass);
        groupBooking.addPass(adultPass);
        groupBooking.addPass(seniorPass);

        groupBooking.printSummary();
    }
}
