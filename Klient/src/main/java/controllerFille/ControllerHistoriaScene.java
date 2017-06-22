package controllerFille;

import dane.Wiersz;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Paint;
import komunikacja.Komunikacja;

import java.io.IOException;
import java.util.Calendar;


public class ControllerHistoriaScene {

    private boolean maloTekstu = false;

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

    private String rejestracjaString;

    @FXML
    public Label wyjatekLabel;

    private ObservableList<Wiersz> dane;

    @FXML
    public void initialize()
    {
        rejestracjaString = new String();
        Wiersz nowy = new Wiersz("fds","sdfs","fsdf", "fsd", "gdfg", "gdfg", "gdfg", "gfd", "dfgdf","fds","fgd","egr","gdfg");
        dane = FXCollections.<Wiersz> observableArrayList(nowy);
        historiaTable.setItems(dane);

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

    private boolean czyLiteraLiczba(int i, int j)
    {
        for(; i < j; i++)
        {
            if(!((rejestracjaString.charAt(i) >= 65 && rejestracjaString.charAt(i) <= 90) || (rejestracjaString.charAt(i) >= 97 && rejestracjaString.charAt(i) <= 122) || (rejestracjaString.charAt(i) >= 48 && rejestracjaString.charAt(i) <= 57)))
            {
                return true;
            }
        }
        return false;
    }

    private boolean czyLitera(int i, int j)
    {
        for(; i < j; i++)
        {
            if(!((rejestracjaString.charAt(i) >= 65 && rejestracjaString.charAt(i) <= 90) || (rejestracjaString.charAt(i) >= 97 && rejestracjaString.charAt(i) <= 122)))
            {
                return true;
            }
        }
        return false;
    }

    private boolean sprawdzRejestracje()
    {
        if(rejestracjaString.length() < 7)
        {
            return true;
        }
        else if(rejestracjaString.length() > 9)
        {
            return true;
        }
        else
        {
            if(rejestracjaString.charAt(3) != ' ')
            {
                if(rejestracjaString.charAt(2) != ' ')
                {
                    return true;
                }
                if(rejestracjaString.length() == 7)
                {
                    if(czyLiteraLiczba(3,7))
                    {
                        return true;
                    }
                }
                if(rejestracjaString.length() == 8)
                {
                    if(czyLiteraLiczba(3,8))
                    {
                        return true;
                    }
                }
            }
            else
            {
                if(rejestracjaString.charAt(2) == ' ')
                {
                    return true;
                }
            }
            if(rejestracjaString.charAt(2) != ' ')
            {
                if(rejestracjaString.charAt(3) != ' ')
                {
                    return true;
                }

                if(rejestracjaString.length() == 8)
                {
                    if(czyLiteraLiczba(4,8))
                    {
                        return true;
                    }

                }
                if(rejestracjaString.length() == 9)
                {
                    if(czyLiteraLiczba(4,9))
                    {
                        return true;
                    }
                }
            }
            else
            {
                if(rejestracjaString.charAt(3) == ' ')
                {
                    return true;
                }
            }

            if(czyLitera(0,2))
            {
                return true;
            }
            if(czyLitera(2,2) && rejestracjaString.charAt(2) == ' ' )
            {
                return true;
            }
        }
        return false;
    }

    @FXML
    void wyszukajOnAction(){
        maloTekstu = false;
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
        if(sprawdzRejestracje())
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
            // if (false) {
            //okno.oknoBledu("Nie udało się dodać samochodu do bazy.");
            // } else {
            //okno.oknoWykonania("Dodano", "Samochod dodano do bazy");
            rejestracjaText.clear();
            // }
        }
    }

}
