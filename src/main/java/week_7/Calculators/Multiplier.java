package week_7.Calculators;

public class Multiplier implements Calculate{
    int num;
    int num1;

    public Multiplier(int num, int num1) {
        this.num = num;
        this.num1 = num1;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getNum1() {
        return num1;
    }

    public void setNum1(int num1) {
        this.num1 = num1;
    }

    @Override
    public int calculate() {
        return num * num1;
    }
}
