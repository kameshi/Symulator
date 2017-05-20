package javaPackage.controllerFille;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;

/**
 * Created by Marek on 16.05.2017.
 */
public class ControllerSymulacjaScene {

    @FXML
    private LineChart symulacjaLineChar;

    private void initialize()
    {
        symulacjaLineChar.setLayoutX(3);
        symulacjaLineChar.setLayoutY(6);
    }

}
