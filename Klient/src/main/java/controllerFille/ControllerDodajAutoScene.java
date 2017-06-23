package controllerFille;

import komunikacja.Komunikacja;
import dane.DaneAuta;

import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import oknaDialogowe.OknaDialogowe;
import rejestracja.Rejestracja;

import java.util.Calendar;
import java.util.Collections;
import java.util.function.UnaryOperator;

/**
 * Created by Marek on 11.05.2017.
 */
public class ControllerDodajAutoScene { // do serwera przesyła obiekt typu DaneAuta

    //OknaDialogowe okno = new OknaDialogowe();

    private DaneAuta daneAuta;
    private String[] dane;

    @FXML
    private Label markaLabel;
    @FXML
    private Label modelLabel;
    @FXML
    private Label mocLabel;
    @FXML
    private Label rokProdukcjiLabel;
    @FXML
    private Label pojemnoscLabel;
    @FXML
    private Label rodzajPaliwaLabel;
    @FXML
    private Label rejestracjaLabel;
    @FXML
    private TextField markaText;
    @FXML 
    private TextField modelText;
    @FXML
    private TextField pojemnoscText;
    @FXML
    private TextField mocText;
    @FXML
    private TextField rokProdukcjiText;
    @FXML
    private TextField rejestracjaText;
    @FXML
    private ComboBox<String> rodzajPaliwaComboBox;

    @FXML
    private Label wyjatekLabel;
    @FXML
    private Label wyjatekDwaLabel;
    
    private static final int rozmiar = 6;
    private Label[] label;
    private TextField[] textField;
    private static final String[] textwyjatek = {"Marka*", "Model*", "Pojemność(cm^3)*", "Moc(KM)*", "***Rok produkcji*", "****Rejestracja*"};
    private static final String[] text = {"Marka", "Model", "Pojemność(cm^3)", "Moc(KM)", "***Rok produkcji","****Rejestracja"};
    private static final String[] rodzajPaliwaString = {"benzyna", "gaz", "hybryda", "diesel"};
    private ObservableList<String> rodzajPaliwaList = FXCollections.observableArrayList();

    private Rejestracja rejestracja;


    public void initialize()
    {
        daneAuta = new DaneAuta();
        dane = new String[rozmiar+1];
        label = new Label[rozmiar];
        textField = new TextField[rozmiar];
        rejestracja = new Rejestracja();

        for(int i = 0; i < rozmiar+1; i++)
        {
            dane[i] = "";
        }
        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();
            if (text.matches("[0-9]*")) {
                return change;
            }
            return null;
        };


        TextFormatter<String> textFormatter1 = new TextFormatter<>(filter);
        TextFormatter<String> textFormatter2 = new TextFormatter<>(filter);
        TextFormatter<String> textFormatter3 = new TextFormatter<>(filter);

        label[0] = markaLabel;
        label[1] = modelLabel;
        label[2] = pojemnoscLabel;
        label[3] = mocLabel;
        label[4] = rokProdukcjiLabel;
        label[5] = rejestracjaLabel;

        textField[0] = markaText;
        textField[1] = modelText;
        textField[2] = pojemnoscText;
        textField[3] = mocText;
        textField[4] = rokProdukcjiText;
        textField[5] = rejestracjaText;

        textField[2].setTextFormatter(textFormatter1);
        textField[3].setTextFormatter(textFormatter2);
        textField[4].setTextFormatter(textFormatter3);

        Collections.addAll(rodzajPaliwaList, rodzajPaliwaString);
        rodzajPaliwaComboBox.setItems(rodzajPaliwaList);
        rodzajPaliwaComboBox.setValue("Wybierz");
    }

    @FXML
    private void dodajOnA(){
        boolean maloTekstu = false;

        for(int i = 0 ; i < rozmiar ; i++)
        {
            if(textField[i].getLength()==0)
            {
                label[i].setText(textwyjatek[i]);
                wyjatekLabel.setVisible(true);
                maloTekstu = true;
            }
            else
            {
                label[i].setText(text[i]);
                dane[i] = textField[i].getText();
            }
        }

        if (rodzajPaliwaComboBox.getValue().equals("Wybierz"))
        {
            rodzajPaliwaLabel.setText("Rodzaj paliwa**");
            wyjatekDwaLabel.setVisible(true);
            maloTekstu = true;
        }
        else
        {
            rodzajPaliwaLabel.setText("Rodzaj paliwa");
            dane[rozmiar] = rodzajPaliwaComboBox.getValue();
            wyjatekDwaLabel.setVisible(false);
        }

        Calendar calendar = Calendar.getInstance();
        if (!(dane[4].isEmpty()))
        {
            if(!(Integer.parseInt(dane[4]) > 1930 && Integer.parseInt(dane[4]) < calendar.get(Calendar.YEAR)) )
            {
                label[4].setTextFill(Paint.valueOf("RED"));
                maloTekstu = true;
            }
            else
            {
                label[4].setTextFill(Paint.valueOf("BLACK"));
            }
        }

        if(rejestracja.sprawdzRejestracje(dane[5]))
        {
            label[5].setTextFill(Paint.valueOf("RED"));
            maloTekstu = true;
        }
        else
        {
            label[5].setTextFill(Paint.valueOf("BLACK"));
        }

        if(!maloTekstu)
        {
            wyjatekLabel.setVisible(false);
            daneAuta.dodaj(dane[0],dane[1],dane[2],dane[3],dane[4],dane[6],dane[5]);
            Komunikacja kom = new Komunikacja("127.0.0.1", 6000);
            kom.wyslij("nowe");
            kom.wyslij(daneAuta);
            //Nie było tu odbierzKontrol więc nie wiem czy to dział
            /*
            Boolean wynik = kom.odbierzKontrol();
            if(wynik == true)
            {

                for(int i = 0 ; i < rozmiar ; i++)
                {
                    textField[i].clear();
                }
                rodzajPaliwaComboBox.setValue("Wybierz");
                OknaDialogowe.oknoWykonania("Dodano dane o samochodzie");
            }
            else if(wynik == false)
            {
                OknaDialogowe.oknoBledu("Nie udało się dodać danych o samochodzi sprawdź podane dane");
            }
            */
        }
    }


}
