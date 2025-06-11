package week_7.LambdaExamples;

public class Main {
    public static void main(String[] args) {
        NumericOperator nm = (a,b) -> a * b;
        System.out.println(nm.operate(5,6));

        NumericOperator nm1 = (a,b) -> (a > b) ? a : b;
        System.out.println(nm1.operate(10,15));

        StringFormatter sf = (s) -> s.toLowerCase();
        System.out.println(sf.format("STAN"));

        UnaryOperation un = (a) -> a * a;
        System.out.println(un.apply(5));


    }

}
