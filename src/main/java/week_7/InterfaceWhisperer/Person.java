package week_7.InterfaceWhisperer;

public class Person implements Diving, SnowBoarding,Camping,Volleyball {

    @Override
    public void camping() {
        System.out.println("Stan is on Camping.");
    }

    @Override
    public void dive() {
        System.out.println("Stan decide to go and dive in the lake.");
    }

    @Override
    public void ride() {
        System.out.println("Kind of happy driving back home, and will be waiting for a winter, to go snowboarding");
    }

    @Override
    public void play() {
        System.out.println("Stan is playing volleyball, alone and depressed:(");
    }

    public void hobbyList(){
        camping();
        play();
        dive();
        ride();
    }
}
