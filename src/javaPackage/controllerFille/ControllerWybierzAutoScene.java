package javaPackage.controllerFille;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import jdk.internal.org.objectweb.asm.tree.analysis.AnalyzerException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.function.UnaryOperator;


/**
 * Created by Marek on 11.05.2017.
 */
public class ControllerWybierzAutoScene {

    private int rozmiarString = 8;
    private String[] daneSymulacji = new String[rozmiarString];

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
    private int rozmiarComboBox = rozmiarString - 2;
    @FXML
    private ComboBox[] comboBox = new ComboBox[rozmiarComboBox];
    @FXML
    private TextField predkoscText;
    @FXML
    private TextField iloscKmText;
    @FXML
    private Button symulujButton;
    @FXML
    private Pane paneWybierzAuto;

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

        UnaryOperator<TextFormatter.Change> filter = change -> {
            String text = change.getText();
            if (text.matches("[0-9]*")) {
                return change;
            }
            return null;
        };
        TextFormatter<String> textFormatter = new TextFormatter<>(filter);
        predkoscText.setTextFormatter(textFormatter);
        predkoscText.setText("0");
        iloscKmText.setText("0");
    }

    private void wyczysc(int i)
    {
        for(; i < rozmiarComboBox; i++)
        {
            daneSymulacji[i] = "";
            comboBox[i].setItems(FXCollections.observableArrayList());
            comboBox[i].setDisable(true);
        }
        predkoscText.setText("0");
        iloscKmText.setText("0");
        predkoscText.setDisable(true);
        iloscKmText.setDisable(true);
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
        wyczysc(6);
        daneSymulacji[5] = comboBox[5].getValue().toString();
        System.out.println(daneSymulacji[5]);
        predkoscText.setDisable(false);
        iloscKmText.setDisable(false);
        symulujButton.setDisable(false);
    }

    @FXML
    private void symulujOnA() {
        daneSymulacji[6] = predkoscText.getText();
        System.out.println(daneSymulacji[6]);
        daneSymulacji[7] = predkoscText.getText();
        System.out.println(daneSymulacji[7]);

        for (String s: daneSymulacji)
        {
            System.out.println(s);
        }
        if(daneSymulacji[6].equals("0"))
        {
            daneSymulacji[7] = "0";
            String spalanie = "15";
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/symulacjaZeroScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ControllerSymulacjaZeroScene controllerSymulacjaZeroScene = loader.getController();
            controllerSymulacjaZeroScene.ustawSpalanie(spalanie);
            paneWybierzAuto.getChildren().clear();
            paneWybierzAuto.getChildren().add(pane);
        }
        else
        {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/symulacjaScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }

            ControllerSymulacjaScene controllerSymulacjaScene = loader.getController();
            paneWybierzAuto.getChildren().clear();
            paneWybierzAuto.getChildren().add(pane);
        }
    }

}
