package javaPackage.controllerFille;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javaPackage.dane.*;

/**
 * Created by Marek on 12.05.2017.
 */
public class ControllerHistoriaScene {

    @FXML
    private TableView<Spalanie> historiaTable;

    @FXML
    private TableColumn<Spalanie, Integer> idColumn;
    @FXML
    private TableColumn<Samochod, String> markaColumn;
    @FXML
    private TableColumn<Samochod, String> modelColumn;
    @FXML
    private TableColumn<Samochod, String> pojemnoscColumn;
    @FXML
    private TableColumn<Samochod, String> mocColumn;
    @FXML
    private TableColumn<Samochod, String> rokProdukcjiColumn;
    @FXML
    private TableColumn<Samochod, String> rodzajPaliwaColumn;
    @FXML
    private TableColumn<Spalanie, String> sredniaPredkoscColumn;
    @FXML
    private TableColumn<Spalanie, String> srednieSpalanieColumn;
    @FXML
    private TableColumn<Spalanie, String> dataColumn;

    @FXML
    public void initialize()
    {

    }
}
