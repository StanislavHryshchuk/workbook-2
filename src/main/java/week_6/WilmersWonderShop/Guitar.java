package week_6.WilmersWonderShop;

public class Guitar extends MusicItem{

    public Guitar(String name, double price) {
        super(name, price);
    }

    @Override
    public  void use(){
        System.out.println("🎸 Strumming the strings of the guitar!");
    }
}
