package rejestracja;

/**
 * Created by Marek on 23.06.2017.
 */

/**
 * <h2>Klasa odpowiedzialna za sprawdzanie rejestracji.</h2>
 * <p>Posiada metody sprawdzające poprawność wprowadzonej przez użytkownika .</p>
 */
public class Rejestracja {

    /**
     * Metoda sprawdzjaąca czy w zmiennej rejestracjaString na miejscach od i do j znajduje się litera lub liczba.
     * @param rejestracjaString rejestracja
     * @param i miejsce pierwszego sprawdzanego elementu
     * @param j miejsce ostatniego sprawdzanego elementu
     * @return boolean zwraca true jeśli w sprawdzanym przedziale jest inny znak niż litera lub liczba.
     */
    private boolean czyLiteraLiczba(String rejestracjaString, int i, int j)
    {
        for(; i < j; i++)
        {
            if(!((rejestracjaString.charAt(i) >= 65 && rejestracjaString.charAt(i) <= 90) || (rejestracjaString.charAt(i) >= 97 && rejestracjaString.charAt(i) <= 122) || (rejestracjaString.charAt(i) >= 48 && rejestracjaString.charAt(i) <= 57)))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Metoda sprawdzjaąca czy w zmiennej rejestracjaString na miejscach od i do j znajduje się litera.
     * @param rejestracjaString rejestracja
     * @param i miejsce pierwszego sprawdzanego elementu
     * @param j miejsce ostatniego sprawdzanego elementu
     * @return boolean zwraca true jeśli w sprawdzanym przedziale jest inny znak niż litera.
     */
    private boolean czyLitera(String rejestracjaString, int i, int j)
    {
        for(; i < j; i++)
        {
            if(!((rejestracjaString.charAt(i) >= 65 && rejestracjaString.charAt(i) <= 90) || (rejestracjaString.charAt(i) >= 97 && rejestracjaString.charAt(i) <= 122)))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * Metoda sprawdzająca cy rejestracja przekazana do funkcji przez argument jest w odpowiednim formacie.
     * @param rejestracjaString rejestracja
     * @return boolean zwraca true jeśli rejestracja nie jest poprawna.
     */
    public boolean sprawdzRejestracje(String rejestracjaString)
    {
        if(rejestracjaString.length() < 7)
        {
            return true;
        }
        else if(rejestracjaString.length() > 9)
        {
            return true;
        }
        else
        {
            if(rejestracjaString.charAt(3) != ' ')
            {
                if(rejestracjaString.charAt(2) != ' ')
                {
                    return true;
                }
                if(rejestracjaString.length() == 7)
                {
                    if(czyLiteraLiczba(rejestracjaString,3,7))
                    {
                        return true;
                    }
                }
                if(rejestracjaString.length() == 8)
                {
                    if(czyLiteraLiczba(rejestracjaString,3,8))
                    {
                        return true;
                    }
                }
            }
            else
            {
                if(rejestracjaString.charAt(2) == ' ')
                {
                    return true;
                }
            }
            if(rejestracjaString.charAt(2) != ' ')
            {
                if(rejestracjaString.charAt(3) != ' ')
                {
                    return true;
                }

                if(rejestracjaString.length() == 8)
                {
                    if(czyLiteraLiczba(rejestracjaString,4,8))
                    {
                        return true;
                    }

                }
                if(rejestracjaString.length() == 9)
                {
                    if(czyLiteraLiczba(rejestracjaString,4,9))
                    {
                        return true;
                    }
                }
            }
            else
            {
                if(rejestracjaString.charAt(3) == ' ')
                {
                    return true;
                }
            }

            if(czyLitera(rejestracjaString,0,2))
            {
                return true;
            }
            if(czyLitera(rejestracjaString,2,2) && rejestracjaString.charAt(2) == ' ' )
            {
                return true;
            }
        }
        return false;
    }
}
