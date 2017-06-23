package controllerFille;

import dane.Historia;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Paint;
import komunikacja.Komunikacja;
import rejestracja.Rejestracja;

import java.text.DecimalFormat;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.function.UnaryOperator;


/**
 * Created by Marek on 11.05.2017.
 */
public class ControllerAktualizujDaneScene {

    private Historia historia = new Historia();
    private String[] dane = new String[2*rozmiar];

    private boolean maloTekstu = false;

    @FXML
    private Label rejestracjaLabel;
    @FXML
    private Label przebiegLabel;
    @FXML
    private Label spalanieLabel;

    @FXML
    private TextField rejestracjaText;
    @FXML
    private TextField przebiegText;
    @FXML
    private TextField spalanieText;

    @FXML
    private CheckBox przegladCheckBox;
    @FXML
    private CheckBox wymainaOlejuCheckBox;
    @FXML
    private CheckBox wymainaRozrzaduCheckBox;

    @FXML
    private Label wyjatekLabel;

    private static final int rozmiar = 3;
    private Label[] label = new Label[rozmiar];
    private TextField[] textField = new TextField[rozmiar];
    private CheckBox[] checkBox = new CheckBox[rozmiar];
    private static final String[] textwyjatek = {"**Rejestracja*","Przebieg*", "Średnie spalanie*"};
    private static final String[] text = {"**Rejestracja","Przebieg", "Średnie spalanie"};

    private Rejestracja rejestracja = new Rejestracja();

    @FXML
    public void initialize()
    {
        for(int i = 0; i < rozmiar*2; i++)
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


        DecimalFormat format = new DecimalFormat( "#.0" );
        UnaryOperator<TextFormatter.Change> filter2 = change -> {
            if ( change.getControlNewText().isEmpty() )
            {
                return change;
            }

            ParsePosition parsePosition = new ParsePosition( 0 );
            Object object = format.parse( change.getControlNewText(), parsePosition );

            if ( object == null || parsePosition.getIndex() < change.getControlNewText().length() )
            {
                return null;
            }
            else
            {
                return change;
            }
        };


        TextFormatter<String> textFormatter1 = new TextFormatter<>(filter);
        TextFormatter<String> textFormatter2 = new TextFormatter<>(filter2);

        label[0] = rejestracjaLabel;
        label[1] = przebiegLabel;
        label[2] = spalanieLabel;

        textField[0] = rejestracjaText;
        textField[1] = przebiegText;
        textField[2] = spalanieText;

        checkBox[0] = przegladCheckBox;
        checkBox[1] = wymainaOlejuCheckBox;
        checkBox[2] = wymainaRozrzaduCheckBox;

        textField[1].setTextFormatter(textFormatter1);
        textField[2].setTextFormatter(textFormatter2);
    }

    @FXML
    private void dodajOnA(){
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

            if (checkBox[i].isSelected()) {
                dane[i + 3] = "tak";
            } else {
                dane[i + 3] = "nie";
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
            String data = new String();
            Calendar calendar = Calendar.getInstance();
            int dzien = calendar.get(Calendar.DATE);
            int miesiac = calendar.get(Calendar.MONTH) + 1;
            int rok = calendar.get(Calendar.YEAR);
            if (miesiac < 10) {
                if (dzien < 10) {
                    data = "0" + String.valueOf(dzien) + ".0" + String.valueOf(miesiac) + "." + String.valueOf(rok);
                } else {
                    data = String.valueOf(dzien) + ".0" + String.valueOf(miesiac) + "." + String.valueOf(rok);
                }

            } else {
                if (dzien < 10) {
                    data = "0" + String.valueOf(dzien) + "." + String.valueOf(miesiac) + "." + String.valueOf(rok);
                } else {
                    data = String.valueOf(dzien) + "." + String.valueOf(miesiac) + "." + String.valueOf(rok);
                }
            }
            historia.dodaj(dane[1], dane[2], dane[3], dane[4], dane[5], data);
            Komunikacja kom = new Komunikacja("127.0.0.1", 6000);
            kom.wyslij("stare");
            kom.wyslij(dane[0]);
            kom.wyslij(historia);
            kom.odbierzKontrol();
            for (int i = 0; i < rozmiar; i++)
            {
                textField[i].clear();
                checkBox[i].setSelected(false);
            }
        }
    }

}
