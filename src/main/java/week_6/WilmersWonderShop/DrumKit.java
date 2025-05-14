package week_6.WilmersWonderShop;

public class DrumKit extends MusicItem{


    public DrumKit(String name, double price) {
        super(name, price);
    }

    @Override
    public  void use(){
        System.out.println("🥁 Boom boom! The drumbeat fills the room!");
    }
}
