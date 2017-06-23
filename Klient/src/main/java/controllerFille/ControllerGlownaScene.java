package controllerFille;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import org.apache.log4j.Logger;

import java.io.IOException;

public class ControllerGlownaScene {

    @FXML
    private BorderPane borderPane;
    private final static Logger logger = Logger.getLogger(ControllerGlownaScene.class);

    public void initialize()
    {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/aktualizujDaneScene.fxml"));
        Pane pane = null;
        try
        {
            pane = loader.load();
        }
        catch (IOException e)
        {
            logger.error("NIe można załadować strony aktualizuj dane.",e);
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
            logger.error("NIe można załadować menu.",e);
        }
        borderPane.setTop(hBox);
        ControllerMenuButtons controllerMenuButtons = loader.getController();
        controllerMenuButtons.setControllerGlownaScene(this);
    }

    protected void setCenter(Pane pane) {
        borderPane.setCenter(null);
        borderPane.setCenter(pane);
    }

}
