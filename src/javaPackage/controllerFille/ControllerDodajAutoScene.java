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
import javafx.scene.control.TextFormatter;

import java.util.Locale.Category;
import java.util.function.UnaryOperator;

/**
 * Created by Marek on 11.05.2017.
 */
public class ControllerDodajAutoScene {

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
    private ComboBox rodzajPaliwaComboBox;

    @FXML
    private Label wyjatekLabel;
    @FXML
    private Label wyjatekDwaLabel;
    
    private static final int rozmiar = 5;
    private Label[] label = new Label[rozmiar];
    private TextField[] textField = new TextField[rozmiar];
    private static final String[] textwyjatek = {"Marka*", "Model*", "Pojemność(cm^3)*", "Moc(KM)*", "Rok produkcji*"};
    private static final String[] text = {"Marka", "Model", "Pojemność(cm^3)", "Moc(KM)", "Rok produkcji"};
    private static final String[] rodzajPaliwaString = {"Benzyna", "Gaz", "Hybryda", "Diesel"};
    private ObservableList<String> rodzajPaliwaList = FXCollections.observableArrayList();


    public void initialize()
    {
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

        textField[0] = markaText;
        textField[1] = modelText;
        textField[2] = pojemnoscText;
        textField[3] = mocText;
        textField[4] = rokProdukcjiText;

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
    

    @FXML
    private void dodajOnA(ActionEvent actionEvent)
    {
        String[] dane = new String[rozmiar+1];
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

        if(!maloTekstu)
        {
            wyjatekLabel.setVisible(false);
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

        if(!maloTekstu)
        {
            for(int i = 0; i < rozmiar+1; i++)
            {
                System.out.println(dane[i]);
            }
            //wysylanie.wyslij(dane,rozmiar+1);
        }
    }

    @FXML
    private void mocOnKeyR() {
    }

    @FXML
    private void pojemnoscOnKeyR()
    {
    }

}
