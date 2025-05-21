package week_7.InterfaceMashupMadness;

public class PopStar implements Singer, Dancer{

    @Override
    public String perform() {
        return Singer.super.perform() + "and" + Dancer.super.perform();
    }
}
