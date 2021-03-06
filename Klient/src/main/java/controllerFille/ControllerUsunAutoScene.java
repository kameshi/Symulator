package controllerFille;

import komunikacja.Komunikacja;
import oknaDialogowe.OknaDialogowe;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import rejestracja.Rejestracja;


/**
 * Created by Marek on 12.05.2017.
 */
/**
 * <h2>Klasa kontrolera ekranu usuwania samochodu.</h2>
 * <p>Posiada metody pozwalające obsługiwać pola zawarte na ekranie "Usuń samochód".</p>
 */
public class ControllerUsunAutoScene {//do serwera wysyła tablice typu string z rejestracja marka i modelem moge to zrobić na obiekcie DaneAuta jak trzeba

    private String[] dane;

    @FXML
    private Label rejestracjaLabel;
    @FXML
    private Label markaLabel;
    @FXML
    private Label modelLabel;

    @FXML
    private TextField rejestracjaText;
    @FXML
    private TextField markaText;
    @FXML
    private TextField modelText;

    @FXML
    private Label wyjatekLabel;

    private static final int rozmiar = 3;
    private Label[] label;
    private TextField[] textField;
    private static final String[] textwyjatek = {"**Rejestracja*","Marka*", "Model*"};
    private static final String[] text = {"**Rejestracja","Marka", "Model"};
    private Rejestracja rejestracja;

    /**
     * Metoda inicjująca zmienne.
     */
    @FXML
    public void initialize()
    {
        dane = new String[rozmiar];
        label = new Label[rozmiar];
        textField = new TextField[rozmiar];
        rejestracja = new Rejestracja();
        for(int i = 0; i < rozmiar; i++)
        {
            dane[i] = "";
        }
        label[0] = rejestracjaLabel;
        label[1] = markaLabel;
        label[2] = modelLabel;

        textField[0] = rejestracjaText;
        textField[1] = markaText;
        textField[2] = modelText;

    }

    /**
     * Metoda sprawdzająca poprawność wprowadzonych danych, jeżeli są poprawne wysyła je do serwera i wyświetla stosowny komunikat.
     */
    @FXML
    private void usunOnA() {
        boolean maloTekstu = false;

        for (int i = 0; i < rozmiar; i++) {
            if (textField[i].getLength() == 0) {
                label[i].setText(textwyjatek[i]);
                wyjatekLabel.setVisible(true);
                maloTekstu = true;
            } else {
                label[i].setText(text[i]);
                dane[i] = textField[i].getText();
            }
        }

        if(rejestracja.sprawdzRejestracje(dane[0]))
        {
            label[0].setTextFill(Paint.valueOf("RED"));
            maloTekstu = true;
        }
        else
        {
            label[0].setTextFill(Paint.valueOf("BLACK"));
        }

        if (!maloTekstu) {
            wyjatekLabel.setVisible(false);
            Komunikacja kom = new Komunikacja("127.0.0.1", 6000);
            kom.wyslij("usun");
            for(int i = 0;i < 3; i++){
                kom.wyslij(dane[i]);
            }
            Boolean wynik = kom.odbierzKontrol();
            if(wynik)
            {
                for (int i = 0; i < rozmiar; i++) {
                    textField[i].clear();
                }
                OknaDialogowe.oknoWykonania("Usunięto podany samochód");
            }
            else
            {
                OknaDialogowe.oknoBledu("Nie udało się usunać podanego samochodu, sprawdź podane dane");
            }
        }
    }
}
