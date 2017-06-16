package controllerFille;

import oknaDialogowe.OknaDialogowe;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;


/**
 * Created by Marek on 12.05.2017.
 */
public class ControllerUsunAutoScene {//do serwera wysyła tablice typu string z rejestracja marka i modelem moge to zrobić na obiekcie DaneAuta jak trzeba

    OknaDialogowe okno = new OknaDialogowe();

    private String[] dane = new String[rozmiar];

    private boolean maloTekstu = false;

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
    private Label[] label = new Label[rozmiar];
    private TextField[] textField = new TextField[rozmiar];
    private static final String[] textwyjatek = {"**Rejestracja*","Marka*", "Model*"};
    private static final String[] text = {"**Rejestracja","Marka", "Model"};

    @FXML
    public void initialize()
    {
        for(int i = 0; i < rozmiar; i++)
        {
            dane[i] = new String();
        }
        label[0] = rejestracjaLabel;
        label[1] = markaLabel;
        label[2] = modelLabel;

        textField[0] = rejestracjaText;
        textField[1] = markaText;
        textField[2] = modelText;

    }


    private boolean czyLiteraLiczba(int i, int j)
    {
        for(; i < j; i++)
        {
            if(!((dane[0].charAt(i) >= 65 && dane[0].charAt(i) <= 90) || (dane[0].charAt(i) >= 97 && dane[0].charAt(i) <= 122) || (dane[0].charAt(i) >= 48 && dane[0].charAt(i) <= 57)))
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
            if(!((dane[0].charAt(i) >= 65 && dane[0].charAt(i) <= 90) || (dane[0].charAt(i) >= 97 && dane[0].charAt(i) <= 122)))
            {
                return true;
            }
        }
        return false;
    }

    private boolean sprawdzRejestracje()
    {
        if(dane[0].length() < 7)
        {
            return true;
        }
        else if(dane[0].length() > 9)
        {
            return true;
        }
        else
        {
            if(dane[0].charAt(3) != ' ')
            {
                if(dane[0].charAt(2) != ' ')
                {
                    return true;
                }
                if(dane[0].length() == 7)
                {
                    if(czyLiteraLiczba(3,7))
                    {
                        return true;
                    }
                }
                if(dane[0].length() == 8)
                {
                    if(czyLiteraLiczba(3,8))
                    {
                        return true;
                    }
                }
            }
            else
            {
                if(dane[0].charAt(2) == ' ')
                {
                    return true;
                }
            }
            if(dane[0].charAt(2) != ' ')
            {
                if(dane[0].charAt(3) != ' ')
                {
                    return true;
                }

                if(dane[0].length() == 8)
                {
                    if(czyLiteraLiczba(4,8))
                    {
                        return true;
                    }

                }
                if(dane[0].length() == 9)
                {
                    if(czyLiteraLiczba(4,9))
                    {
                        return true;
                    }
                }
            }
            else
            {
                if(dane[0].charAt(3) == ' ')
                {
                    return true;
                }
            }

            if(czyLitera(0,2))
            {
                return true;
            }
            if(czyLitera(2,2) && dane[0].charAt(2) == ' ' )
            {
                return true;
            }
        }
        return false;
    }

    @FXML
    void usunOnA(ActionEvent event) {
        maloTekstu = false;

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

        if(sprawdzRejestracje())
        {
            label[0].setTextFill(Paint.valueOf("RED"));
            maloTekstu = true;
            System.out.println("red");
        }
        else
        {
            label[0].setTextFill(Paint.valueOf("BLACK"));
            System.out.println("black");
        }

        if (!maloTekstu) {
            wyjatekLabel.setVisible(false);
            //wysyła tutaj
            if (false) {
                okno.oknoBledu("Nie udało się dodać samochodu do bazy.");
            } else {
                okno.oknoWykonania("Dodano", "Samochod dodano do bazy");
                for (int i = 0; i < rozmiar; i++) {
                    textField[i].clear();
                }
            }
        }
    }
}
