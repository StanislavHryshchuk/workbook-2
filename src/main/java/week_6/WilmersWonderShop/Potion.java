package week_6.WilmersWonderShop;

public class Potion extends MagicItem{

    public Potion(String name, double price) {
        super(name, price);
    }

    @Override
    public  void use(){
        System.out.println("✨✨✨✨✨✨");
    }
}
