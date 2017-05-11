package javaPackage.controllerFille;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.IOException;

/**
 * Created by Marek on 11.05.2017.
 */
public class ControllerMenuButtons
{

    private int scene = 0;
    private ControllerprimaryScene controllerprimaryScene;

    @FXML
    public void wybierzSamochodOnA( )
    {
        if(scene != 1) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/choiceAutoScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            controllerprimaryScene.setCenter(pane);
            scene = 1;
        }
    }

    @FXML
    public void dodajSamochodOnA( )
    {
        if(scene != 2) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/addAutoScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            controllerprimaryScene.setCenter(pane);
            scene = 2;
        }
    }

    @FXML
    public void historiaOnA( )
    {
        if(scene != 3)
        {
            scene = 3;
        }
    }

    @FXML
    public void pomocOnA( )
    {
        if(scene != 4)
        {
            scene = 4;
        }
    }

    public void setControllerprimaryScene(ControllerprimaryScene controllerprimaryScene)
    {
        this.controllerprimaryScene = controllerprimaryScene;
    }

    public void exit( )
    {

    }
}
