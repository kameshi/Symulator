package controllerFille;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Created by Marek on 11.05.2017.
 */

/**
 * <h2>Klasa kontrolera przycisków menu wyboru ekranów.</h2>
 * <p>Posiada metody pozwalające obsługiwać przyciski menu.</p>
 */
public class ControllerMenuButtons
{

    private final static Logger logger = Logger.getLogger(ControllerMenuButtons.class);

    private int scene = 0;
    private ControllerGlownaScene controllerGlownaScene;

    /**
     * Metoda wczytująca ekran aktualizacj danych o samochodzie oraz wywołująca metodę setCenter aby ustawić go na ekranie głównym.
     */
    @FXML
    private void aktualizujDaneOnA( )
    {
        if(scene != 1) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/aktualizujDaneScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                logger.error("NIe można załadować strony aktualizuj dane.",e);
            }
            controllerGlownaScene.setCenter(pane);
            scene = 1;
        }
    }

    /**
     * Metoda wczytująca ekran dodaj samochód oraz wywołująca metodę setCenter aby ustawić go na ekranie głównym.
     */
    @FXML
    private void dodajSamochodOnA( )
    {
        if(scene != 2) {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/dodajAutoScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                logger.error("NIe można załadować strony dodaj auto.",e);
            }
            controllerGlownaScene.setCenter(pane);
            scene = 2;
        }
    }

    /**
     * Metoda wczytująca ekran usun samochód oraz wywołująca metodę setCenter aby ustawić go na ekranie głównym.
     */
    @FXML
    private void usunSamochodOnA( )
    {
        if(scene != 3)
        {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/usunAutoScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                logger.error("NIe można załadować strony usuń auto.",e);
            }
            controllerGlownaScene.setCenter(pane);
            scene = 3;
        }
    }

    /**
     * Metoda wczytująca ekran historia oraz wywołująca metodę setCenter aby ustawić go na ekranie głównym.
     */
    @FXML
    private void historiaOnA( )
    {
        if(scene != 4)
        {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/historiaScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                logger.error("NIe można załadować strony historia.",e);
            }
            controllerGlownaScene.setCenter(pane);
            scene = 4;
        }
    }

    /**
     * Metoda wczytująca ekran pomoc oraz wywołująca metodę setCenter aby ustawić go na ekranie głównym.
     */
    @FXML
    private void pomocOnA( )
    {
        if(scene != 5)
        {
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/pomocScene.fxml"));
            Pane pane = null;
            try {
                pane = loader.load();
            } catch (IOException e) {
                logger.error("NIe można załadować strony pomoc.",e);
            }
            controllerGlownaScene.setCenter(pane);
            scene = 5;
        }
    }

    /**
     * Metoda wczytująca ekran aktualizacj danych o samochodzie oraz wywołująca metodę setCenter aby ustawić go na ekranie głównym.
     * @param controllerGlownaScene zmienna przechowująca wskażnik na kontroler ekranu głównego
     */
    protected void setControllerGlownaScene(ControllerGlownaScene controllerGlownaScene)
    {
        this.controllerGlownaScene = controllerGlownaScene;
    }

    /**
     * Metoda obsługująca przycisk wyjście który po naciśnięciu zamyka aplikację.
     */
    public void exit( )
    {
        Platform.exit();
    }
}
