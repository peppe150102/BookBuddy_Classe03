import model.Studenti;
import model.StudentiDao;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestLogin {
    @Test
    public void testLoginSuccess() throws Exception {
        StudentiDao sDao = new StudentiDao();
        assertNotNull(sDao.checkLogin("g.salzillo2@studenti.unisa.it", "password123"));
        assertNotNull(sDao.checkLogin("c.iommazzo@studenti.unisa.it", "password123"));
        assertNotNull(sDao.checkLogin("s.donniacuo1@studenti.unisa.it", "password123"));
        assertNotNull(sDao.checkLogin("e.ragozzini@studenti.unisa.it", "password123"));
    }

    @Test
    public void testLoginFailPassw() throws Exception{
        StudentiDao sDao = new StudentiDao();
        assertNull(sDao.checkLogin("g.salzillo2@studenti.unisa.it", "kakakabizo"));
        assertNull(sDao.checkLogin("c.iommazzo@studenti.unisa.it", ""));
        assertNull(sDao.checkLogin("s.donniacuo1@studenti.unisa.it", "popipopi123"));
        assertNull(sDao.checkLogin("e.ragozzini@studenti.unisa.it", "ninonino123"));
    }

    @Test
    public void testLoginFailMail() throws Exception{
        StudentiDao sDao = new StudentiDao();
        assertNull(sDao.checkLogin("g.salzillo2@unisa.it", "kakakabizo"));
        assertNull(sDao.checkLogin("", "ninapi568"));
        assertNull(sDao.checkLogin("s.doncuo@studenti.unisa.it", "popipopi123"));
        assertNull(sDao.checkLogin("e.ragoz@studenti.unisa.it", "ninonino123"));
    }
}
