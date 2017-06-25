package controllerFille;

import dane.BazaWiersz;
import dane.Wiersz;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import komunikacja.Komunikacja;
import oknaDialogowe.OknaDialogowe;
import rejestracja.Rejestracja;

/**
 * <h2>Klasa kontrolera ekranu wyświetlania histori samochodów.</h2>
 * <p>Posiada metody pozwalające obsługiwać pola zawarte na ekranie "Historia".</p>
 */

public class ControllerHistoriaScene {

    @FXML
    private TableView<Wiersz> historiaTable;
    @FXML
    private TableColumn<Wiersz, String> rejestracjaColumn;
    @FXML
    private TableColumn<Wiersz, String> markaColumn;
    @FXML
    private TableColumn<Wiersz, String> modelColumn;
    @FXML
    private TableColumn<Wiersz, String> pojemnoscColumn;
    @FXML
    private TableColumn<Wiersz, String> mocColumn;
    @FXML
    private TableColumn<Wiersz, String> rokProdukcjiColumn;
    @FXML
    private TableColumn<Wiersz, String> rodzajPaliwaColumn;
    @FXML
    private TableColumn<Wiersz, String> przebieColumn;
    @FXML
    private TableColumn<Wiersz, String> spalanieColumn;
    @FXML
    private TableColumn<Wiersz, String> przegladColumn;
    @FXML
    private TableColumn<Wiersz, String> wymianaOlejuColumn;
    @FXML
    private TableColumn<Wiersz, String> wymianaRozrzaduColumn;
    @FXML
    private TableColumn<Wiersz, String> dataColumn;
    @FXML
    private Label rejestracjaLabel;
    @FXML
    private TextField rejestracjaText;
    @FXML
    public Label wyjatekLabel;

    private Rejestracja rejestracja;
    private String rejestracjaString = "";

    private ObservableList<Wiersz> dane = FXCollections.observableArrayList();

    /**
     * Metoda inicjująca zmienne oraz ustawiająca odpowiednie nazwy danych w kolumnach.
     */
    @FXML
    public void initialize()
    {
        rejestracja = new Rejestracja();
        Komunikacja kom = new Komunikacja("127.0.0.1", 6000);
        kom.wyslij("historia");
        BazaWiersz bazaWiersz = kom.odbierz();
        wypelnij(bazaWiersz);
        
        rejestracjaColumn.setCellValueFactory(new PropertyValueFactory<>("rejestracja"));
        markaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        pojemnoscColumn.setCellValueFactory(new PropertyValueFactory<>("pojemnosc"));
        mocColumn.setCellValueFactory(new PropertyValueFactory<>("moc"));
        rokProdukcjiColumn.setCellValueFactory(new PropertyValueFactory<>("rok"));
        rodzajPaliwaColumn.setCellValueFactory(new PropertyValueFactory<>("paliwo"));
        przebieColumn.setCellValueFactory(new PropertyValueFactory<>("przebieg"));
        spalanieColumn.setCellValueFactory(new PropertyValueFactory<>("spalanie"));
        przegladColumn.setCellValueFactory(new PropertyValueFactory<>("przeglad"));
        wymianaOlejuColumn.setCellValueFactory(new PropertyValueFactory<>("wymianaOleju"));
        wymianaRozrzaduColumn.setCellValueFactory(new PropertyValueFactory<>("wymianaRozrzadu"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
    }

    /**
     * Metoda sprawdzająca poprawność wprowadzonych danych, jeżeli są poprawne wysyła je do serwera i wywołuję funkcję wypelnij(), aby wyświetlić otrzymane dane w tabeli.
     */
    @FXML
    private void wyszukajOnAction(){
        boolean maloTekstu = false;
        if (rejestracjaText.getLength() == 0) {
            rejestracjaLabel.setText("*Podaj numer rejestracyjny samochodu**");
            wyjatekLabel.setVisible(true);
            maloTekstu = true;
        }
        else
        {
            rejestracjaLabel.setText("*Podaj numer rejestracyjny samochodu");
            rejestracjaString = rejestracjaText.getText();
            wyjatekLabel.setVisible(false);
        }
        if(rejestracja.sprawdzRejestracje(rejestracjaString))
        {
            rejestracjaLabel.setTextFill(Paint.valueOf("RED"));
            maloTekstu = true;
        }
        else
        {
            rejestracjaLabel.setTextFill(Paint.valueOf("BLACK"));
        }

        if (!maloTekstu) {
            Komunikacja kom = new Komunikacja("127.0.0.1", 6000);
            kom.wyslij("sort");
            kom.wyslij(rejestracjaString);
            wypelnij(kom.odbierz());
            Boolean wynik = kom.odbierzKontrol();
            if(wynik)
            {
                rejestracjaText.clear();
            }
            else
            {
                OknaDialogowe.oknoBledu("Nie ma takiego samochodu");
            }
        }
    }

    /**
     * Metoda metoda wypełniająca liste dane typu FXCollections.observableArrayList() elementami z obiektu baza i wyświetlajaca je w tabeli historiaTable.
     * @param baza zawiera dane do wyswietlenia w tabeli.
     */
    private void wypelnij(BazaWiersz baza)
    {
        dane.clear();
        for(int i = 0; i < baza.size(); i++)
        {
            dane.add(baza.getObject(i));
        }
        historiaTable.setItems(dane);
    }

}
