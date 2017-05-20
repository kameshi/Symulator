package javaPackage.controllerFille;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;


/**
 * Created by Marek on 11.05.2017.
 */
public class ControllerWybierzAutoScene {

    private ObservableList<Locale.Category> markaOL = FXCollections.observableArrayList();
    private ObjectProperty<Locale.Category> markaOP = new SimpleObjectProperty<>();

    private ControllerGlownaScene controllerGlownaScene;

    public void init() throws FileNotFoundException {



    }

    public void rokProdukcjiOnA(ActionEvent actionEvent) {
    }

    public void mocOnA(ActionEvent actionEvent) {
    }

    public void pojemnoscOnA(ActionEvent actionEvent) {
    }

    public void modelOnA(ActionEvent actionEvent) {
    }

    public void markaOnA(ActionEvent actionEvent) {
    }

    public void symulujOnA(ActionEvent actionEvent) {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/symulacjaScene.fxml"));
        Pane pane = null;
        try {
            pane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //controllerGlownaScene.setCenter(pane);
    }

    public void setControllerGlownaScene(ControllerGlownaScene controllerGlownaScene) {
        this.controllerGlownaScene = controllerGlownaScene;
    }
}
