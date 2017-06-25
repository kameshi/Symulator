package oknaDialogowe;

import javafx.scene.control.Alert;

/**
 * Created by Marek on 14.06.2017.
 */

/**
 * <h2>Klasa okien dialogowych.</h2>
 * <p>Posiada metody odpowiedzialne za wyświetlanie odpowiednich okien dialogowych.</p>
 */
public class OknaDialogowe
{

    /**
     * Metoda wyświetlająca okno błędu.
     * @param komunikat komunikat do wyswietlenia.
     */
    public static void oknoBledu(String komunikat)
    {
        Alert blad = new Alert(Alert.AlertType.ERROR);
        blad.setTitle("Błąd");
        blad.setHeaderText(komunikat);
        blad.showAndWait();
    }

    /**
     * Metoda wyswietlająca komunikat.
     * @param komunikat komunikat do wyswietlenia.
     */
    public static void oknoWykonania( String komunikat)
    {
        Alert wykonano = new Alert(Alert.AlertType.INFORMATION);
        wykonano.setTitle("Sukces");
        wykonano.setHeaderText(komunikat);
        wykonano.showAndWait();
    }

}
