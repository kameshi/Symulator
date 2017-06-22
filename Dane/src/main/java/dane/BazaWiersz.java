package dane;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Marek on 22.06.2017.
 */
public class BazaWiersz implements Serializable{
    private ArrayList<Wiersz> wiersz = new ArrayList<Wiersz>();
    public int size(){
        return wiersz.size();
    }
    public Wiersz getObject(int i){
        return wiersz.get(i);
    }
    public void add(Wiersz dane){
        wiersz.add(dane);
    }
    public String toString(int i){
        return "Wiersz : " + wiersz.get(i).toString();
    }
}
