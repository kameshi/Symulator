package dane;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Marek on 12.06.2017.
 */
public class BazaHistoria implements Serializable {
    private ArrayList<Historia> historia = new ArrayList<Historia>();
    public int size(){
        return historia.size();
    }
    public Historia getObject(int i){
        return historia.get(i);
    }
    public void add(Historia dane){
        historia.add(dane);
    }
    public int getIdHistoria(int i){
        String kon;
        kon = historia.get(i).getIdHistoria();
        return Integer.valueOf(kon);
    }
    public String getIdRejestracja( int i){
        return historia.get(i).getIdRejestracja();
    }
    public String getPrzebieg( int i){
        return historia.get(i).getPrzebieg();
    }
    public String getSpalanie( int i){
        return historia.get(i).getSpalanie();
    }
    public String getPrzeglad( int i){
        return historia.get(i).getPrzeglad();
    }
    public String getWymianaOleju( int i){
        return historia.get(i).getWymianaOleju();
    }
    public String getWymianaRozrzadu( int i){
        return historia.get(i).getWymianaRozrzadu();
    }
    public String getData( int i){
        return historia.get(i).getData();
    }
}
