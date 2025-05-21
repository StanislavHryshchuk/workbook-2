package week_7.InterfaceMashupMadness;

public interface Dancer {
    default String perform() { return "*jazz hands*"; }
}
