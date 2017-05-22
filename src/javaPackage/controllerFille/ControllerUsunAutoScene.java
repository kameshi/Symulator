package javaPackage.controllerFille;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import java.io.FileNotFoundException;


/**
 * Created by Marek on 12.05.2017.
 */
public class ControllerUsunAutoScene {

    private int rozmiar = 6;
    private String[] daneUsuwania = new String[rozmiar];

    @FXML
    private ComboBox markaComboBox;
    @FXML
    private ComboBox modelComboBox;
    @FXML
    private ComboBox pojemnoscComboBox;
    @FXML
    private ComboBox mocComboBox;
    @FXML
    private ComboBox rokProdukcjiComboBox;
    @FXML
    private ComboBox rodzajPaliwaComboBox;
    @FXML
    private ComboBox[] comboBox = new ComboBox[rozmiar];
    @FXML
    private Button usunButton;

    public void initialize() throws FileNotFoundException {
        comboBox[0] = markaComboBox;
        comboBox[1] = modelComboBox;
        comboBox[2] = pojemnoscComboBox;
        comboBox[3] = mocComboBox;
        comboBox[4] = rokProdukcjiComboBox;
        comboBox[5] = rodzajPaliwaComboBox;
        ObservableList<String> markaList = FXCollections.observableArrayList();
        String[] wypalnienie = {"Marka", "Model", "Moc(KM)", "Pojemność(cm^3)", "Rok produkcji"};
        for (String s: wypalnienie)
        {
            markaList.add(s);
        }
        comboBox[0].setItems(markaList);
    }

    private void wyczysc(int i)
    {
        for(; i < rozmiar; i++)
        {
            daneUsuwania[i] = "";
            comboBox[i].setItems(FXCollections.observableArrayList());
            comboBox[i].setDisable(true);
        }
        usunButton.setDisable(true);
    }

    @FXML
    private void markaOnA() {
        wyczysc(1);
        ObservableList<String> modelList = FXCollections.observableArrayList();
        daneUsuwania[0] = comboBox[0].getValue().toString();
        System.out.println(daneUsuwania[0]);
        String[] wypalnienie;
        if(daneUsuwania[0].equals("Marka"))
        {
            wypalnienie = new String[]{"Marka", "Model", "Moc(KM)", "Pojemność(cm^3)", "Rok produkcji"};
        }
        else if(daneUsuwania[0].equals("Model"))
        {
            wypalnienie = new String[]{ "Pojemność(cm^3)", "Rok produkcji"};
        }
        else
            wypalnienie = new String[]{"Marka", "Model", "Rok produkcji"};
        for (String s: wypalnienie)
        {
            modelList.add(s);
        }
        comboBox[1].setItems(modelList);
        comboBox[1].setDisable(false);
    }

    @FXML
    private void modelOnA() {
        wyczysc(2);
        ObservableList<String> pojemnoscList = FXCollections.observableArrayList();
        daneUsuwania[1] = comboBox[1].getValue().toString();
        System.out.println(daneUsuwania[1]);
        String[] wypalnienie;
        if(daneUsuwania[1].equals("Marka"))
        {
            wypalnienie = new String[]{"Marka", "Model", "Moc(KM)", "Pojemność(cm^3)", "Rok produkcji"};
        }
        else if(daneUsuwania[1].equals("Model"))
        {
            wypalnienie = new String[]{ "Pojemność(cm^3)", "Rok produkcji"};
        }
        else
            wypalnienie = new String[]{"Marka", "Model", "Rok produkcji"};
        for (String s: wypalnienie)
        {
            pojemnoscList.add(s);
        }
        comboBox[2].setItems(pojemnoscList);
        comboBox[2].setDisable(false);
    }

    @FXML
    private void pojemnoscOnA() {
        wyczysc(3);
        ObservableList<String> mocList = FXCollections.observableArrayList();
        daneUsuwania[2] = comboBox[2].getValue().toString();
        System.out.println(daneUsuwania[2]);
        String[] wypalnienie;
        if(daneUsuwania[2].equals("Marka"))
        {
            wypalnienie = new String[]{"Marka", "Model", "Moc(KM)", "Pojemność(cm^3)", "Rok produkcji"};
        }
        else if(daneUsuwania[2].equals("Model"))
        {
            wypalnienie = new String[]{ "Pojemność(cm^3)", "Rok produkcji"};
        }
        else
            wypalnienie = new String[]{"Marka", "Model", "Rok produkcji"};
        for (String s: wypalnienie)
        {
            mocList.add(s);
        }
        comboBox[3].setItems(mocList);
        comboBox[3].setDisable(false);
    }

    @FXML
    private void mocOnA() {
        wyczysc(4);
        ObservableList<String> rokProdukcjiList = FXCollections.observableArrayList();
        daneUsuwania[3] = comboBox[3].getValue().toString();
        System.out.println(daneUsuwania[3]);
        String[] wypalnienie;
        if(daneUsuwania[3].equals("Marka"))
        {
            wypalnienie = new String[]{"Marka", "Model", "Moc(KM)", "Pojemność(cm^3)", "Rok produkcji"};
        }
        else if(daneUsuwania[3].equals("Model"))
        {
            wypalnienie = new String[]{ "Pojemność(cm^3)", "Rok produkcji"};
        }
        else
            wypalnienie = new String[]{"Marka", "Model", "Rok produkcji"};
        for (String s: wypalnienie)
        {
            rokProdukcjiList.add(s);
        }
        comboBox[4].setItems(rokProdukcjiList);
        comboBox[4].setDisable(false);
    }

    @FXML
    private void rokProdukcjiOnA() {
        wyczysc(5);
        ObservableList<String> rodzajPaliwaList = FXCollections.observableArrayList();
        daneUsuwania[4] = comboBox[4].getValue().toString();
        System.out.println(daneUsuwania[4]);
        String[] wypalnienie;
        if(daneUsuwania[4].equals("Marka"))
        {
            wypalnienie = new String[]{"Marka", "Model", "Moc(KM)", "Pojemność(cm^3)", "Rok produkcji"};
        }
        else if(daneUsuwania[4].equals("Model"))
        {
            wypalnienie = new String[]{ "Pojemność(cm^3)", "Rok produkcji"};
        }
        else
            wypalnienie = new String[]{"Marka", "Model", "Rok produkcji"};
        for (String s: wypalnienie)
        {
            rodzajPaliwaList.add(s);
        }
        comboBox[5].setItems(FXCollections.observableArrayList());
        comboBox[5].setItems(rodzajPaliwaList);
        comboBox[5].setDisable(false);
    }

    @FXML
    private void rodzajPaliwaOnA() {
        daneUsuwania[5] = comboBox[5].getValue().toString();
        System.out.println(daneUsuwania[5]);
        usunButton.setDisable(false);
    }

    @FXML
    private void usunOnA(ActionEvent actionEvent) {
        for (String s: daneUsuwania)
        {
            System.out.println(s);
        }
    }
}
