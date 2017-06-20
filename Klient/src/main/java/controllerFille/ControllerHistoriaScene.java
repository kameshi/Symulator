package controllerFille;

import dane.Wiersz;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


public class ControllerHistoriaScene {

    @FXML
    private TableView<Wiersz> historiaTable;

    @FXML
    private TableColumn<Wiersz, String> rejestracjaColumn;

    @FXML
    private TableColumn<Wiersz, String> markaColumn;

    @FXML
    private TableColumn<Wiersz, String> modelColumn;

    @FXML
    private TableColumn<Wiersz, String> pojemnoscColumn;

    @FXML
    private TableColumn<Wiersz, String> mocColumn;

    @FXML
    private TableColumn<Wiersz, String> rokProdukcjiColumn;

    @FXML
    private TableColumn<Wiersz, String> rodzajPaliwaColumn;

    @FXML
    private TableColumn<Wiersz, String> przebieColumn;

    @FXML
    private TableColumn<Wiersz, String> spalanieColumn;

    @FXML
    private TableColumn<Wiersz, String> przegladColumn;

    @FXML
    private TableColumn<Wiersz, String> wymianaOlejuColumn;

    @FXML
    private TableColumn<Wiersz, String> wymianaRozrzaduColumn;

    @FXML
    private TableColumn<Wiersz, String> dataColumn;

    @FXML
    private Label rejestracjaLabel;

    @FXML
    private TextField rejestracjaText;

    private ObservableList<Wiersz> dane;

    @FXML
    public void initialize()
    {

        Wiersz nowy = new Wiersz("fds","sdfs","fsdf", "fsd", "gdfg", "gdfg", "gdfg", "gfd", "dfgdf","fds","fgd","egr","gdfg");
        dane = FXCollections.<Wiersz> observableArrayList(nowy);
        historiaTable.setItems(dane);

        rejestracjaColumn.setCellValueFactory(new PropertyValueFactory<>("rejestracja"));
        markaColumn.setCellValueFactory(new PropertyValueFactory<>("marka"));
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        pojemnoscColumn.setCellValueFactory(new PropertyValueFactory<>("pojemnosc"));
        mocColumn.setCellValueFactory(new PropertyValueFactory<>("moc"));
        rokProdukcjiColumn.setCellValueFactory(new PropertyValueFactory<>("rok"));
        rodzajPaliwaColumn.setCellValueFactory(new PropertyValueFactory<>("paliwo"));
        przebieColumn.setCellValueFactory(new PropertyValueFactory<>("przebieg"));
        spalanieColumn.setCellValueFactory(new PropertyValueFactory<>("spalanie"));
        przegladColumn.setCellValueFactory(new PropertyValueFactory<>("przeglad"));
        wymianaOlejuColumn.setCellValueFactory(new PropertyValueFactory<>("wymianaOleju"));
        wymianaRozrzaduColumn.setCellValueFactory(new PropertyValueFactory<>("wymianaRozrzadu"));
        dataColumn.setCellValueFactory(new PropertyValueFactory<>("data"));
    }

    @FXML
    private void wyszukajOnAction()
    {
        Wiersz nowy = new Wiersz("fds","234","fsdf", "fsd", "gdfg", "gdfg", "gdfg", "gfd", "dfgdf","fds","fgd","egr","gdfg");
        dane = FXCollections.<Wiersz> observableArrayList(nowy);
        historiaTable.setItems(dane);


    }

}
