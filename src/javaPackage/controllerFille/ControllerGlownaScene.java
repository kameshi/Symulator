package javaPackage.controllerFille;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class ControllerGlownaScene {

    @FXML
    private BorderPane borderPane;

    public void initialize()
    {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/AktualizujDaneScene.fxml"));
        Pane pane = null;
        try
        {
            pane = loader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        setCenter(pane);
        loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/menuButtons.fxml"));
        HBox hBox = null;
        try
        {
            hBox = loader.load();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        borderPane.setTop(hBox);
        ControllerMenuButtons controllerMenuButtons = loader.getController();
        controllerMenuButtons.setControllerGlownaScene(this);
    }

    public void setCenter(Pane pane) {
        borderPane.setCenter(null);
        borderPane.setCenter(pane);
    }

}
