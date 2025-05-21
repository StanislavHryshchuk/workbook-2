package week_7.InterfaceMashupMadness;

public interface Singer {
    default String perform() { return "La la la!"; }
}
