package week_7.StreamsEx;

public class Number implements NumberTester{
    @Override
    public boolean test(int num) {
       return (num % 2 == 0) ? true : false;
    }
}
