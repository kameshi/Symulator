package logg;

import org.apache.log4j.*;

import java.io.IOException;

/**
 * Created by Marek on 22.06.2017.
 */
public class Logg {
    private org.apache.log4j.Logger logger;
    private Layout layout;
    private Appender appender;
    private Appender fileAppender;

    public Logg()
    {
        layout = new PatternLayout("[%p] %m - Data wpisu: %d %n");
        this.logger = org.apache.log4j.Logger.getRootLogger();
    }

    public void loggPlikIKonsola(String rodzaj, String komunikat)
    {
        loggKonsola(rodzaj, komunikat);
        loggPlik(rodzaj, komunikat);
    }

    public void loggPlik(String rodzaj, String komunikat)
    {
        try {
            fileAppender = new FileAppender(layout, "C:/Users/user/Desktop/Symulator/logg.log");
        }
        catch (IOException e) {
            loggKonsola("error", "Błąd zapisu loggów do pliku.");
        }
        BasicConfigurator.resetConfiguration();
        BasicConfigurator.configure(fileAppender);
        logg(rodzaj, komunikat);
    }

    public void loggKonsola(String rodzaj, String komunikat)
    {
        appender = new ConsoleAppender(layout);
        BasicConfigurator.resetConfiguration();
        BasicConfigurator.configure(appender);
        logg(rodzaj, komunikat);
    }

    private void logg(String rodzaj, String komunikat)
    {
        if(rodzaj.equals("error"))
        {
            logger.setLevel(Level.ERROR);
            logger.error(komunikat);
        }
        else if(rodzaj.equals("trace"))
        {
            logger.setLevel(Level.TRACE);
            logger.trace(komunikat);
        }
        else if(rodzaj.equals("info"))
        {
            logger.setLevel(Level.INFO);
            logger.info(komunikat);
        }
        else
        {
            logger.setLevel(Level.DEBUG);
            logger.debug(komunikat);
        }
    }
}
