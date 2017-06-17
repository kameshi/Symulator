package komunikacja;

import java.util.ArrayList;

public class ListaPomocnicza {
    ArrayList list = new ArrayList();
    public void set(String napis){
        list.add(napis);
    }
    public String getString(int i){
        return (String) list.get(i);
    }
}
