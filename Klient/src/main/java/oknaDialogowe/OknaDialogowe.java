package oknaDialogowe;

import javafx.scene.control.Alert;

/**
 * Created by Marek on 14.06.2017.
 */
public class OknaDialogowe
{
    public static void oknoBledu(String komunikat)
    {
        Alert blad = new Alert(Alert.AlertType.ERROR);
        blad.setTitle("Błąd");
        blad.setHeaderText(komunikat);
        blad.showAndWait();
    }

    public static void oknoWykonania( String komunikat)
    {
        Alert wykonano = new Alert(Alert.AlertType.INFORMATION);
        wykonano.setTitle("Sukces");
        wykonano.setHeaderText(komunikat);
        wykonano.showAndWait();
    }

}
