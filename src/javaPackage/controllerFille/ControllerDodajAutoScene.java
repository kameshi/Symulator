package javaPackage.controllerFille;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javaPackage.Komunikacja.*;

import java.util.Locale.Category;

/**
 * Created by Marek on 11.05.2017.
 */
public class ControllerDodajAutoScene {
    
    private boolean maloTekstu = false;

    @FXML
    private Label markaLabel;
    @FXML
    private Label modelLabel;
    @FXML
    private Label mocLabel;
    @FXML
    private Label pojemnoscLabel;
    @FXML
    private Label rokLabel;
    @FXML
    private Label rodzajPaliwaLabel;

    @FXML
    private TextField markaText;
    @FXML 
    private TextField modelText;
    @FXML
    private TextField mocText;
    @FXML
    private TextField pojemnoscText;
    @FXML
    private TextField rokText;
    @FXML
    private ComboBox rodzajPaliwaComboBox;

    @FXML
    private Label wyjatekLabel;
    @FXML
    private Label wyjatekDwaLabel;
    
    private static final int rozmiar = 5;
    private Label[] label = new Label[rozmiar];
    private TextField[] textField = new TextField[rozmiar];
    private static final String[] textwyjatek = {"Marka*", "Model*", "Moc*", "Pojemnosc*", "Rok*"};
    private static final String[] text = {"Marka", "Model", "Moc", "Pojemnosc", "Rok"};
    private static final String[] rodzajPaliwaString = {"Benzyna", "Gaz", "Hybryda", "Diesel"};
    private ObservableList<String> rodzajPaliwaList = FXCollections.observableArrayList();
    private ObjectProperty<String> rodzajPaliwaObject = new SimpleObjectProperty<>();


    public void initialize()
    {
        label[0] = markaLabel;
        label[1] = modelLabel;
        label[2] = mocLabel;
        label[3] = pojemnoscLabel;
        label[4] = rokLabel;
        
        textField[0] = markaText;
        textField[1] = modelText;
        textField[2] = mocText;
        textField[3] = pojemnoscText;
        textField[4] = rokText;

        for (String s: rodzajPaliwaString)
        {
            rodzajPaliwaList.add(s);
        }
        rodzajPaliwaComboBox.setItems(rodzajPaliwaList);

    }
    

    @FXML
    private void dodajOnA(ActionEvent actionEvent)
    {
        String[] dane = new String[rozmiar+1];

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
                System.out.println(dane[i]);
            }
        }

        if (rodzajPaliwaComboBox.getValue().equals(""))
        {
            rodzajPaliwaLabel.setText("Rodzaj paliwa**");
            wyjatekDwaLabel.setVisible(true);
            maloTekstu = true;
        }
        else
        {
            rodzajPaliwaLabel.setText("Rodzaj paliwa");
            dane[rozmiar] = rodzajPaliwaComboBox.getValue().toString();
            System.out.println(dane[rozmiar]);
        }
        if(!maloTekstu)
        {
            Wysylanie.wyslij(dane,rozmiar+1);
        }
    }
}
