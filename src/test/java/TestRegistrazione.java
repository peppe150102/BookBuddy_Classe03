import model.StudentiDao;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRegistrazione {
    @Test
    public void testRegistrazioneSuccess()
    {
        StudentiDao sDao = new StudentiDao();
        assertTrue(sDao.checkRegistrazione("g.russo244@studenti.unisa.it", "password123", "Giovanni"));
        assertTrue(sDao.checkRegistrazione("c.iommazzo@studenti.unisa.it", "password123", "Camilla"));
        assertTrue(sDao.checkRegistrazione("s.donniacuo1@studenti.unisa.it", "password123", "Siria"));
        assertTrue(sDao.checkRegistrazione("g.salzillo2@studenti.unisa.it", "password123", "Giuseppe"));
    }

    @Test
    public void testRegistrazioneFailMail()
    {
        StudentiDao sDao = new StudentiDao();
        assertFalse(sDao.checkRegistrazione("g@studenti.unisa.it", "password123", "Giovanni"));
        assertFalse(sDao.checkRegistrazione("a@mail.it", "password123", "Giovanni"));
        assertFalse(sDao.checkRegistrazione("g.russo244.it", "password123", "Giovanni"));
        assertFalse(sDao.checkRegistrazione("", "password123", "Giovanni"));
    }

    @Test
    public void testRegistrazioneFailPassw()
    {
        StudentiDao sDao = new StudentiDao();
        assertFalse(sDao.checkRegistrazione("g.russo244@studenti.unisa.it", "pass", "Giovanni"));
        assertFalse(sDao.checkRegistrazione("a@mail.it", "123", "Giovanni"));
        assertFalse(sDao.checkRegistrazione("g.russo244@studenti.unisa.it", "k", "Giovanni"));
        assertFalse(sDao.checkRegistrazione("g.russo244@studenti.unisa.it", "", "Giovanni"));
    }

    @Test
    public void testRegistrazioneFailNome()
    {
        StudentiDao sDao = new StudentiDao();
        assertFalse(sDao.checkRegistrazione("g.russo244@studenti.unisa.it", "password123", "Z!"));
        assertFalse(sDao.checkRegistrazione("a@mail.it", "password123", "!"));
        assertFalse(sDao.checkRegistrazione("g.russo244@studenti.unisa.it", "k", "G"));
        assertFalse(sDao.checkRegistrazione("g.russo244@studenti.unisa.it", "password123", ""));
    }

}
