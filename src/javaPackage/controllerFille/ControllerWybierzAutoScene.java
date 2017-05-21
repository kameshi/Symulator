package javaPackage.controllerFille;

import com.sun.istack.internal.Nullable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;


/**
 * Created by Marek on 11.05.2017.
 */
public class ControllerWybierzAutoScene {

    @FXML
    private Pane paneWybierzAuto;

    private int rozmiar = 6;

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

    private ComboBox[] comboBox = new ComboBox[rozmiar];

    @FXML
    private Button symulujButton;

    private String[] daneSymulacji = new String[rozmiar];

    private ControllerGlownaScene controllerGlownaScene;

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
            daneSymulacji[i] = "";
            comboBox[i].setItems(FXCollections.observableArrayList());
            comboBox[i].setDisable(true);
        }
        symulujButton.setDisable(true);
    }

    @FXML
    private void markaOnA() {
        wyczysc(1);
        ObservableList<String> modelList = FXCollections.observableArrayList();
        daneSymulacji[0] = comboBox[0].getValue().toString();
        System.out.println(daneSymulacji[0]);
        String[] wypalnienie;
        if(daneSymulacji[0].equals("Marka"))
        {
            wypalnienie = new String[]{"Marka", "Model", "Moc(KM)", "Pojemność(cm^3)", "Rok produkcji"};
        }
        else if(daneSymulacji[0].equals("Model"))
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
        daneSymulacji[1] = comboBox[1].getValue().toString();
        System.out.println(daneSymulacji[1]);
        String[] wypalnienie;
        if(daneSymulacji[1].equals("Marka"))
        {
            wypalnienie = new String[]{"Marka", "Model", "Moc(KM)", "Pojemność(cm^3)", "Rok produkcji"};
        }
        else if(daneSymulacji[1].equals("Model"))
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
        daneSymulacji[2] = comboBox[2].getValue().toString();
        System.out.println(daneSymulacji[2]);
        String[] wypalnienie;
        if(daneSymulacji[2].equals("Marka"))
        {
            wypalnienie = new String[]{"Marka", "Model", "Moc(KM)", "Pojemność(cm^3)", "Rok produkcji"};
        }
        else if(daneSymulacji[2].equals("Model"))
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
        daneSymulacji[3] = comboBox[3].getValue().toString();
        System.out.println(daneSymulacji[3]);
        String[] wypalnienie;
        if(daneSymulacji[3].equals("Marka"))
        {
            wypalnienie = new String[]{"Marka", "Model", "Moc(KM)", "Pojemność(cm^3)", "Rok produkcji"};
        }
        else if(daneSymulacji[3].equals("Model"))
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
        daneSymulacji[4] = comboBox[4].getValue().toString();
        System.out.println(daneSymulacji[4]);
        String[] wypalnienie;
        if(daneSymulacji[4].equals("Marka"))
        {
            wypalnienie = new String[]{"Marka", "Model", "Moc(KM)", "Pojemność(cm^3)", "Rok produkcji"};
        }
        else if(daneSymulacji[4].equals("Model"))
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
        daneSymulacji[5] = comboBox[5].getValue().toString();
        System.out.println(daneSymulacji[5]);
        symulujButton.setDisable(false);
    }

    @FXML
    private void symulujOnA(ActionEvent actionEvent) {
        for (String s: daneSymulacji)
        {
            System.out.println(s);
        }
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/symulacjaScene.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        controllerGlownaScene.wypisz();
    }

    public void setControllerGlownaScene(ControllerGlownaScene controllerGlownaScene) {
        this.controllerGlownaScene = controllerGlownaScene;
    }

}
