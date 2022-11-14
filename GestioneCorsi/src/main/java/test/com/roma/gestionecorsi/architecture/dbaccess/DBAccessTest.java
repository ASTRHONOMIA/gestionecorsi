package test.com.roma.gestionecorsi.architecture.dbaccess;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;



class DBAccessTest {

	@Test
	void testConnection() {
		try {
		DBAccess.getConnection();
		}
		catch(DAOException | ClassNotFoundException | IOException exc)
		{
			exc.printStackTrace();
			fail("Errore nel tentativo di connessione: "+exc.getMessage());
		}
		finally {
			try 
			{
				DBAccess.closeConnetion();
			}
			catch (DAOException exc) {
				exc.printStackTrace();
				fail("Errore nella chiusura della connesione: "+exc.getMessage());
			}
			
		}
	}

}
