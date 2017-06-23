package rejestracja;

/**
 * Created by Marek on 23.06.2017.
 */
public class Rejestracja {

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
