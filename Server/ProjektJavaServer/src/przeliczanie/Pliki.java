package przeliczanie;

import java.io.*;
import java.util.*;

import przeliczanie.DaneAut;

public class Pliki {
	private List<DaneAut> auta = new ArrayList<DaneAut>();
	private Scanner spalanie;
	private Scanner paliwo;
	private Scanner silnik;
	private Scanner model;
	private Scanner marka;
	
	public void odczyt() throws FileNotFoundException{
		marka = new Scanner(new BufferedReader(new FileReader("DaneAutMarka.txt")));
		model = new Scanner(new BufferedReader(new FileReader("DaneAutModel.txt")));
		silnik = new Scanner(new BufferedReader(new FileReader("DaneAutRodzajSilnika.txt")));
		paliwo = new Scanner(new BufferedReader(new FileReader("DaneAutRodzajPaliwa.txt")));
		spalanie = new Scanner(new BufferedReader(new FileReader("DaneAutSrednieSpalanie.txt")));
		Double spalanieK , silnikK;
		while(marka.hasNext()){
			spalanieK = konwertuj(spalanie.nextLine());
			silnikK = konwertuj(silnik.nextLine());
			auta.add(new DaneAut( marka.nextLine() , model.nextLine() , spalanieK , silnikK , paliwo.nextLine()));
		}
	}
	public void zapis(String marka , String model , String rodzajPaliwa , double rodzajSilnika , double srednieSpalanie) throws FileNotFoundException{
		PrintWriter markaOut = new PrintWriter("DaneAutMarka.txt");
		PrintWriter modelOut = new PrintWriter("DaneAutModel.txt");
		PrintWriter silnik = new PrintWriter("DaneAutRodzajSilnika.txt");
		PrintWriter paliwo = new PrintWriter("DaneAutRodzajPaliwa.txt");
		PrintWriter spalanie = new PrintWriter("DaneAutSrednieSpalanie.txt");
		
		int i = 0;
		while(i != auta.size()){
			markaOut.println(getMarka(i));
			modelOut.println(getModel(i));
			silnik.println(getRodzajSilnika(i));
			paliwo.println(getRodzajPaliwa(i));
			spalanie.println(getSrednieSpalanie(i));
			i++;
		}
		
		markaOut.println(marka);
		modelOut.println(model);
		silnik.println(rodzajSilnika);
		paliwo.println(rodzajPaliwa);
		spalanie.println(srednieSpalanie);
		markaOut.close();
		modelOut.close();
		silnik.close();
		paliwo.close();
		spalanie.close();
	}
	public Double getSrednieSpalanie(int i){
		return auta.get(i).getSrednieSpalanie();
	}
	public Double getRodzajSilnika(int i){
		return auta.get(i).getRodzajSilnika();
	}
	public String getRodzajPaliwa(int i){
		return auta.get(i).getRodzajPaliwa();
	}
	public String getMarka(int i){
		return auta.get(i).getMarka();
	}
	public String getModel(int i){
		return auta.get(i).getModel();
	}
	public double wyszukanie(String marka , String model , String rodzajPaliwa , double rodzajSilnika){
		int i=0;
		while(i != auta.size()){
			if(auta.get(i).getMarka().equals(marka)){
				if(auta.get(i).getModel().equals(model)){
					if(auta.get(i).getRodzajPaliwa().equals(rodzajPaliwa)){
						if(auta.get(i).getRodzajSilnika() == rodzajSilnika){
							return auta.get(i).getSrednieSpalanie();
						}
					}
				}
			}
			i++;
		}
		return -1;
	}
	private double konwertuj(String napis){
		return Double.valueOf(napis);
	}
	/*Zosatawiam jakby by³o trzeba testowac
	public void wyswietl(){
		int i = 0;
		while(i != auta.size()){
			System.out.println(getMarka(i) + " " +getModel(i) + " " + getSrednieSpalanie(i) + " " + getRodzajSilnika(i) + " " + getRodzajPaliwa(i));
			i++;
		}
	}
	*/
}

