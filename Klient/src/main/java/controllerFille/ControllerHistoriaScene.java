package controllerFille;

import dane.BazaHistoria;
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
            System.out.println(rejestracjaString);
            Komunikacja kom = new Komunikacja("127.0.0.1", 6000);
            kom.wyslij("sort");
            kom.wyslij(rejestracjaString);
            wypelnij(kom.odbierz());
            /*
            if (false) {
            okno.oknoBledu("Nie udało się dodać samochodu do bazy.");
             } else {
            okno.oknoWykonania("Dodano", "Samochod dodano do bazy");
            */
            //nie było więc nie wiem czy działa
            /*
            Boolean wynik = kom.odbierzKontrol();
            if(wynik == true)
            {
                rejestracjaText.clear();
                OknaDialogowe.oknoWykonania("Dodano dane o samochodzie");
            }
            else if(wynik == false)
            {
                OknaDialogowe.oknoBledu("Nie udało się dodać danych o samochodzi sprawdź podane dane");
            }*/
            // }
        }
    }

    private void wypelnij(BazaWiersz baza)
    {
        for(int i = 0; i < baza.size(); i++)
        {
            dane.add(baza.getObject(i));
        }
        historiaTable.setItems(dane);
    }

}
