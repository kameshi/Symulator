import org.junit.Before;
import org.junit.Test;
import rejestracja.Rejestracja;

import static org.junit.Assert.assertTrue;

/**
 * Created by Marek on 24.06.2017.
 */
public class TestRejestracja {
    private Rejestracja rejestracja;

    @Before
    public void setUp()
    {
        rejestracja = new Rejestracja();
    }

    @Test
    public void sprawdzRejestracje()
    {
        assertTrue(rejestracja.sprawdzRejestracje("fdsfds"));
        assertTrue(rejestracja.sprawdzRejestracje("fds fdsfdsf"));
        assertTrue(rejestracja.sprawdzRejestracje("fds  ffds"));
        assertTrue(rejestracja.sprawdzRejestracje("f fdsg"));
        assertTrue(rejestracja.sprawdzRejestracje("f4 fdgs"));
        assertTrue(rejestracja.sprawdzRejestracje("fdf fdsfe"));
    }
}
