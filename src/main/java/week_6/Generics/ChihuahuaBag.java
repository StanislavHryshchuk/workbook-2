package week_6.Generics;

import java.util.ArrayList;
import java.util.List;

public class ChihuahuaBag {
    private List<Chihuahua> items = new ArrayList<>();

    public void addChihuahua(Chihuahua chihuahua){
        this.items.add(chihuahua);
    }

    public void printContents(){
        for(Chihuahua chihuahua: items){
            System.out.println(chihuahua.toString());
        }
    }
}
