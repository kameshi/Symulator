package javaPackage.controllerFille;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;

import java.awt.*;

/**
 * Created by Marek on 11.05.2017.
 */
public class ControllerAddAutoScene{

    private boolean maloTekstu = false;

    @FXML
    private Label markaLabel;

    @FXML
    private Label modelLabel;

    @FXML
    private Label mocLabel;

    @FXML
    private Label wyjatekLabel;

    @FXML
    private TextField markaText;

    @FXML
    private TextField modelText;

    @FXML
    private TextField mocText;

    @FXML
    public void dodajOnA(ActionEvent actionEvent)
    {
        String[] dane = new String[3];
        if(markaText.getLength()==0)
        {
            String text = markaLabel.getText();
            markaLabel.setText(text + "*");
            wyjatekLabel.setVisible(true);
            maloTekstu = true;
        }
        else
        {
            dane[0] = markaText.getText();
            System.out.println(dane[0]);
        }
        if(modelText.getLength()==0)
        {
            String text = modelLabel.getText();
            modelLabel.setText(text + "*");
            wyjatekLabel.setVisible(true);
            maloTekstu = true;
        }
        else
        {
            dane[1] = modelText.getText();
            System.out.println(dane[1]);
        }
        if(mocText.getLength()==0)
        {
            String text = mocLabel.getText();
            mocLabel.setText(text + "*");
            wyjatekLabel.setVisible(true);
            maloTekstu = true;
        }
        else
        {
            dane[2] = mocText.getText();
            System.out.println(dane[2]);
        }
    }
}
