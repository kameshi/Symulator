package javaPackage.controllerFille;

import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;

/**
 * Created by Marek on 16.05.2017.
 */
public class ControllerSymulacjaScene {

    @FXML
    private LineChart<?,?> symulacjaLineChar;

    public void initialize()
    {
        XYChart.Series series = new XYChart.Series();

        String tab[] = {"1","2","3","35.4","5","6","7.5"};
        double tab2[] = {1,2,3,4,5,6,7};

        for (int i = 0; i < tab.length; i++)
        {
            series.getData().add(new XYChart.Data(tab[i],Double.parseDouble(tab[i])));
        }

        symulacjaLineChar.getData().addAll(series);
        symulacjaLineChar.setTitle("Spalanie");
        symulacjaLineChar.getYAxis().setLabel("Spalanie");
        symulacjaLineChar.getXAxis().setLabel("Ilość przebytych kilometrów");
    }

    public void zapiszOnA() {
    }
}
