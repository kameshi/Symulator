package javaPackage.controllerFille;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by Marek on 01.06.2017.
 */
public class ControllerSymulacjaZeroScene {
    @FXML
    private Label spalanieLabel;

    public void ustawSpalanie(String spalanie) {
        spalanieLabel.setText(spalanie + " l");
    }


    public void zapiszOnA(ActionEvent actionEvent) {
    }
}
