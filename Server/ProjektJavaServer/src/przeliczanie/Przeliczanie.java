package przeliczanie;

import java.io.FileNotFoundException;

public class Przeliczanie {

	private Pliki p = new Pliki();
	
	public String dzialanie(String marka , String model , String iloscKM , String rodzajPaliwa , String rodzajSilnika , String srednieSpalanie) throws FileNotFoundException{
		p.odczyt();
		double pom;
		if((pom = p.wyszukanie(marka, model , rodzajPaliwa , konwersja(rodzajSilnika))) == -1){
			p.zapis(marka, model , rodzajPaliwa , konwersja(rodzajSilnika) , konwersja(srednieSpalanie));
			return konwersja((konwersja(srednieSpalanie)/konwersja(iloscKM))*100);
		}else{
			return konwersja((pom/konwersja(iloscKM))*100);
		}
	}
	private String konwersja(Double liczba){
		return liczba.toString();
	}
	private Double konwersja(String napis){
		return Double.valueOf(napis);
	}
	
}
