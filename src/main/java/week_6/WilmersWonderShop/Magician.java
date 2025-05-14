package week_6.WilmersWonderShop;

import java.util.ArrayList;
import java.util.List;

public class Magician {

    private String name;


    private List<MagicItem> magicItems = new ArrayList<>();

    public Magician(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MagicItem> getMagicItems() {
        return magicItems;
    }

    public void setMagicItems(List<MagicItem> magicItems) {
        this.magicItems = magicItems;
    }

    public void preformShow(){
        for (MagicItem magic: magicItems){
            if(magic instanceof Wand){
                System.out.println(getName() + " \uD83E\uDDD9\u200D♂\uFE0F " + "appears on the scene. In his hands " + magic.getName()+".");
                magic.use();

            }
            if (magic instanceof Potion){
                System.out.println("He drinks his " + magic.getName()   + " \uD83E\uDDEA. Now his UNO tricks are beyond imagination.");
                magic.use();
            }

        }
    }
}
