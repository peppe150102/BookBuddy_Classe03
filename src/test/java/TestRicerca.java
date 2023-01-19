import model.MaterialeDidatticoDao;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRicerca {
    @Test
    public void testRicercaSuccess()
    {
        MaterialeDidatticoDao mDao = new MaterialeDidatticoDao();
        assertNotNull(mDao.doRetrieveByNome("Sistemi"));
    }

    @Test
    public void testRicercaFail()
    {
        MaterialeDidatticoDao mDao = new MaterialeDidatticoDao();
        assertTrue(mDao.doRetrieveByNome("!").isEmpty());
    }
}
