import model.StudentiDao;
import org.junit.Test;
import static org.junit.Assert.*;
public class TestUpdateUser {
    @Test
    public void testUpdateSuccess()
    {
        StudentiDao sDao = new StudentiDao();
        assertTrue(sDao.checkRegistrazione("c.iommazzo@studenti.unisa.it", "password1234", "Camilla"));
        assertTrue(sDao.checkRegistrazione("g.salzillo2@studenti.unisa.it", "password1234", "Giuseppe"));
        assertTrue(sDao.checkRegistrazione("s.donniacuo1@studenti.unisa.it", "password1234", "Siria"));
        assertTrue(sDao.checkRegistrazione("e.ragozzini@studenti.unisa.it", "password1234", "Emanuele"));

    }

    @Test
    public void testUpdateFailMail()
    {
        StudentiDao sDao = new StudentiDao();
        assertFalse(sDao.checkRegistrazione("l.camilli.unisa.it", "password1234", "Giuseppe"));
        assertFalse(sDao.checkRegistrazione("l@gmail.com", "password1234", "Giuseppe"));
        assertFalse(sDao.checkRegistrazione("", "password1234", "Giuseppe"));
        assertFalse(sDao.checkRegistrazione("l.camilli@it", "password1234", "Giuseppe"));

    }

    @Test
    public void testUpdateFailPassw()
    {
        StudentiDao sDao = new StudentiDao();
        assertFalse(sDao.checkRegistrazione("g.salzillo2@studenti.unisa.it", "lo lo", "Ludovico"));
        assertFalse(sDao.checkRegistrazione("g.salzillo2@studenti.unisa.it", "K", "Ludovico"));
        assertFalse(sDao.checkRegistrazione("g.salzillo2@studenti.unisa.it", "", "Ludovico"));

    }

    @Test
    public void testUpdateFailNome()
    {
        StudentiDao sDao = new StudentiDao();
        assertFalse(sDao.checkRegistrazione("g.salzillo2@studenti.unisa.it", "password1234", ""));
        assertFalse(sDao.checkRegistrazione("g.salzillo2@studenti.unisa.it", "password1234", "Aakfwbfkawbfhawmfwvfvawf"));
        assertFalse(sDao.checkRegistrazione("g.salzillo2@studenti.unisa.it", "password1234", "A!"));

    }
}
