package week_6.Generics;

import java.util.ArrayList;
import java.util.List;

public class Bag<T> {
    private List<T> items = new ArrayList<>();


    public void add(T item){
        this.items.add(item);
    }

    public void printItem(){
        for (T item: items){
            System.out.println(item.toString());
        }
    }
    public T getFirst(){
        if (!items.isEmpty()){
            return items.getFirst();
        }else {
            return null;
        }
    }
}
