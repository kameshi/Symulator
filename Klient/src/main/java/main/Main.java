package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * <h2>Klasa kontrolera przycisków menu wyboru ekranów.</h2>
 * <p>Posiada metody pozwalające obsługiwać przyciski menu.</p>
 */
public class Main extends Application {
    private final static Logger logger = Logger.getLogger(Main.class);

    @Override
    public void start(Stage primaryStage) {
        logger.info("Uruchomiono program." );


        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/glownaScene.fxml"));
        BorderPane borderPane = null;
        try {
            borderPane = loader.load();
        } catch (IOException e) {
            logger.error("NIe można załadować strony głównej.",e);
        }
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Symulator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
