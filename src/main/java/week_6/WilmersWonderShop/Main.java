package week_6.WilmersWonderShop;

public class Main {
    public static void main(String[] args) {

        Magician wimbuldorTheMagician = new Magician("Professor Wimbuldor");

        Wand wimbuldorsWand = new Wand("Wimbuldor's Wand", 100);
        Potion wimbuldorsPoition = new Potion("UNO potion", 100);
        Potion wimbuldorsPoition1 = new Potion("Get 2 more hands", 200);

        wimbuldorTheMagician.getMagicItems().add(wimbuldorsWand);
        wimbuldorTheMagician.getMagicItems().add(wimbuldorsPoition);
        wimbuldorTheMagician.getMagicItems().add(wimbuldorsPoition1);


        Musician wimbuldorTheMusician = new Musician("Modulations");
        Guitar modulationGuitar = new Guitar("The Loudest One", 150);
        Guitar modulationGuitar1 = new Guitar("The Most Melodic", 150);
        DrumKit modulationDrum = new DrumKit("Crazy Rhythm", 150);

        wimbuldorTheMusician.getMusicItems().add(modulationDrum);
        wimbuldorTheMusician.getMusicItems().add(modulationGuitar);
        wimbuldorTheMusician.getMusicItems().add(modulationGuitar1);

        wimbuldorTheMagician.preformShow();
        wimbuldorTheMusician.preformConcert();


    }
}
