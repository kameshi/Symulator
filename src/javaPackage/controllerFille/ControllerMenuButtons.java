package javaPackage.controllerFille;

import com.sun.deploy.uitoolkit.impl.fx.FXWindow;
import javafx.application.Platform;
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
    private ControllerGlownaScene controllerGlownaScene;

    @FXML
    public void wybierzSamochodOnA( )
    {
        if(scene != 1) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/wybierzAutoScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            ControllerWybierzAutoScene controllerWybierzAutoScene = loader.getController();
            controllerWybierzAutoScene.setControllerGlownaScene(controllerGlownaScene);
            controllerGlownaScene.setCenter(pane);
            scene = 1;
        }
    }

    @FXML
    public void dodajSamochodOnA( )
    {
        if(scene != 2) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/dodajAutoScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            controllerGlownaScene.setCenter(pane);
            scene = 2;
        }
    }

    @FXML
    public void usunSamochodOnA( )
    {
        if(scene != 3)
        {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/usunAutoScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            controllerGlownaScene.setCenter(pane);
            scene = 3;
        }
    }

    @FXML
    public void historiaOnA( )
    {
        if(scene != 4)
        {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/historiaScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            controllerGlownaScene.setCenter(pane);
            scene = 4;
        }
    }

    @FXML
    public void pomocOnA( )
    {
        if(scene != 5)
        {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/pomocScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            controllerGlownaScene.setCenter(pane);
            scene = 5;
        }
    }

    public void setControllerGlownaScene(ControllerGlownaScene controllerGlownaScene)
    {
        this.controllerGlownaScene = controllerGlownaScene;
    }

    public void exit( )
    {
        Platform.exit();
    }
}
