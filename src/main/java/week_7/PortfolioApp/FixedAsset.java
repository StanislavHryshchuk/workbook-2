package week_7.PortfolioApp;

public abstract class FixedAsset implements Valuable, Comparable<Valuable> {
    private String name;
    private double marketValue;

    public FixedAsset(String name, double marketValue) {
        this.name = name;
        this.marketValue = marketValue;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(double marketValue) {
        this.marketValue = marketValue;
    }
    @Override
    public abstract double getValue();

    @Override
    public int compareTo(Valuable o) {

        return 0;
    }
}
