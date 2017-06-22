package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logg.Logg;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Logg logg = new Logg();
        logg.loggPlikIKonsola("info","Rozpoczęcie działania klienta.");
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxmlPackage/glownaScene.fxml"));
        BorderPane borderPane = null;
        try {
            borderPane = loader.load();
        } catch (IOException e) {
            logg.loggPlikIKonsola("error","Błąd wczytania Sceny głównej.");
        }
        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Symulator");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
     /*
        Scanner scannerI = new Scanner(System.in);
        Scanner scannerS = new Scanner(System.in);
        Komunikacja k = new Komunikacja();
        boolean n = true;
        do{
            System.out.println("Podaj co robic \n1.nowe auto\n2.stare auto\n3.Historia\n0.koniec");
            int kon;

            kon = scannerI.nextInt();
            if(kon == 1){
                String marka, model, km, paliwo, silnik;
                System.out.println("Marka: ");
                marka = scannerS.nextLine();
                System.out.println("Modle: ");
                model = scannerS.nextLine();
                System.out.println("KM: ");
                km = scannerS.nextLine();
                System.out.println("Paliwo: ");
                paliwo = scannerS.nextLine();
                System.out.println("Silnik: ");
                silnik = scannerS.nextLine();
                k.wyslij(marka, model, km, paliwo, silnik);
                System.out.println("Srednie spalanie na " + km + " Km " + " wynosi: " + k.odebrane());
            }else if(kon == 2){

            }else if(kon == 0){
                n = false;
            }
        }while(n);
*/
    }

}
