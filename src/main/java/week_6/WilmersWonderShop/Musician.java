package week_6.WilmersWonderShop;

import java.util.ArrayList;
import java.util.List;

public class Musician {
    private String name;

    private List<MusicItem> musicItems = new ArrayList<>();



    public Musician(String name) {
        this.name = name;
    }

    public List<MusicItem> getMusicItems() {
        return musicItems;
    }

    public void setMusicItems(List<MusicItem> musicItems) {
        this.musicItems = musicItems;
    }
    public void preformConcert(){
        for (MusicItem music: musicItems){
            if(music instanceof Guitar){
                music.use();
            }
            if (music instanceof DrumKit){
                music.use();
            }

        }
    }
}
