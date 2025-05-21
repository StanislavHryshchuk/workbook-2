package week_7.PortfolioApp;

public class FinanceApplication {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio("Portfolio 2025", "Stanislav Hryshchuk");
        BankAccount bankOfAmerica = new BankAccount("Checking", "062695", 21300);
        CreditCard bOfAmericaCreditCard = new CreditCard("Credit Account", "952606", 12000);
        House hawaiiHouse = new House("Hawaii House", 1000000,2005,3000,4);
        Gold goldBar = new Gold("Gold Bar", 105000,1);
        Jewelry jewelry = new Jewelry("GrandMother Ring", 3000,3);

        portfolio.getAssets().add(bankOfAmerica);
    }
}
