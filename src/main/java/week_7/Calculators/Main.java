package week_7.Calculators;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Adder a = new Adder(5,6);
        Multiplier m = new Multiplier(5,6);
        List<Calculate> calc = new ArrayList<>();

        calc.add(a);
        calc.add(m);
        for (Calculate c: calc){
            if(c instanceof Adder){
                System.out.println("Sum " + c.calculate());

            }
            if(c instanceof Multiplier){
                System.out.println("Mult " + c.calculate());

            }
        }
    }
}
