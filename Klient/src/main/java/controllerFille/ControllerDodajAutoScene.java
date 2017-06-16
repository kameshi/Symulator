package controllerFille;

import dane.DaneAuta;
import oknaDialogowe.OknaDialogowe;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import Komunikacja.*;
import javafx.scene.control.TextFormatter;
import javafx.scene.paint.Paint;

import java.util.Calendar;
import java.util.function.UnaryOperator;

/**
 * Created by Marek on 11.05.2017.
 */
public class ControllerDodajAutoScene { // do serwera przesyła obiekt typu DaneAuta

    OknaDialogowe okno = new OknaDialogowe();

    private DaneAuta daneAuta = new DaneAuta();
    private String[] dane = new String[rozmiar+1];

    Wysylanie wysylanie = new Wysylanie();
    private boolean maloTekstu = false;

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
    private ComboBox rodzajPaliwaComboBox;

    @FXML
    private Label wyjatekLabel;
    @FXML
    private Label wyjatekDwaLabel;
    
    private static final int rozmiar = 6;
    private Label[] label = new Label[rozmiar];
    private TextField[] textField = new TextField[rozmiar];
    private static final String[] textwyjatek = {"Marka*", "Model*", "Pojemność(cm^3)*", "Moc(KM)*", "***Rok produkcji*", "****Rejestracja*"};
    private static final String[] text = {"Marka", "Model", "Pojemność(cm^3)", "Moc(KM)", "***Rok produkcji","****Rejestracja"};
    private static final String[] rodzajPaliwaString = {"benzyna", "gaz", "hybryda", "diesel"};
    private ObservableList<String> rodzajPaliwaList = FXCollections.observableArrayList();


    public void initialize()
    {
        for(int i = 0; i < rozmiar+1; i++)
        {
            dane[i] = new String();
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

        for (String s: rodzajPaliwaString)
        {
            rodzajPaliwaList.add(s);
        }
        rodzajPaliwaComboBox.setItems(rodzajPaliwaList);
        rodzajPaliwaComboBox.setValue("Wybierz");
    }

    private boolean czyLiteraLiczba(int i, int j)
    {
        for(; i < j; i++)
        {
            if(!((dane[5].charAt(i) >= 65 && dane[5].charAt(i) <= 90) || (dane[5].charAt(i) >= 97 && dane[5].charAt(i) <= 122) || (dane[5].charAt(i) >= 48 && dane[5].charAt(i) <= 57)))
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
            if(!((dane[5].charAt(i) >= 65 && dane[5].charAt(i) <= 90) || (dane[5].charAt(i) >= 97 && dane[5].charAt(i) <= 122)))
            {
                return true;
            }
        }
        return false;
    }
    
    private boolean sprawdzRejestracje()
    {
        if(dane[5].length() < 7)
        {
            return true;
        }
        else if(dane[5].length() > 9)
        {
            return true;
        }
        else
        {
            if(dane[5].charAt(3) != ' ')
            {
                if(dane[5].charAt(2) != ' ')
                {
                    return true;
                }
                if(dane[5].length() == 7)
                {
                    if(czyLiteraLiczba(3,7))
                    {
                        return true;
                    }
                }
                if(dane[5].length() == 8)
                {
                    if(czyLiteraLiczba(3,8))
                    {
                        return true;
                    }
                }
            }
            else
            {
                if(dane[5].charAt(2) == ' ')
                {
                    return true;
                }
            }
            if(dane[5].charAt(2) != ' ')
            {
                if(dane[5].charAt(3) != ' ')
                {
                    return true;
                }

                if(dane[5].length() == 8)
                {
                    if(czyLiteraLiczba(4,8))
                    {
                        return true;
                    }

                }
                if(dane[5].length() == 9)
                {
                    if(czyLiteraLiczba(4,9))
                    {
                        return true;
                    }
                }
            }
            else
            {
                if(dane[5].charAt(3) == ' ')
                {
                    return true;
                }
            }

            if(czyLitera(0,2))
            {
                return true;
            }
            if(czyLitera(2,2) && dane[5].charAt(2) == ' ' )
            {
                return true;
            }
        }
        return false;
    }

    @FXML
    private void dodajOnA()
    {
        maloTekstu = false;

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

        if (rodzajPaliwaComboBox.getValue().toString().equals("Wybierz"))
        {
            rodzajPaliwaLabel.setText("Rodzaj paliwa**");
            wyjatekDwaLabel.setVisible(true);
            maloTekstu = true;
        }
        else
        {
            rodzajPaliwaLabel.setText("Rodzaj paliwa");
            dane[rozmiar] = rodzajPaliwaComboBox.getValue().toString();
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

        if(sprawdzRejestracje())
        {
            label[5].setTextFill(Paint.valueOf("RED"));
            maloTekstu = true;
            System.out.println("red");
        }
        else
        {
            label[5].setTextFill(Paint.valueOf("BLACK"));
            System.out.println("black");
        }

        if(!maloTekstu)
        {
            wyjatekLabel.setVisible(false);
            daneAuta.dodaj(dane[0],dane[1],dane[2],dane[3],dane[4],dane[6],dane[5]);
            System.out.println(daneAuta.toString());
            //wysyła tutaj
            if(dane[6].equals("benzyna"))
            {
                okno.oknoBledu("NIe udało się dodać samochodu do bazy.");
            }
            else
            {
                okno.oknoWykonania("Dodano", "Samochod dodano do bazy");
                for(int i = 0 ; i < rozmiar ; i++)
                {
                    textField[i].clear();
                }
                rodzajPaliwaComboBox.setValue("Wybierz");
            }
        }
    }


}
