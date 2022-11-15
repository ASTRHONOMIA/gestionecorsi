package test.com.roma.gestionecorsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.roma.gestionecorsi.architecture.dao.CorsistiDAO;
import com.roma.gestionecorsi.architecture.dao.CorsoCorsistaDAO;
import com.roma.gestionecorsi.architecture.dao.CorsoDAO;
import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.model.Corsista;
import com.roma.gestionecorsi.businesscomponent.model.Corso;
import com.roma.gestionecorsi.businesscomponent.model.CorsoCorsista;

class CorsoCorsistaDAOTest {
	private static Connection conn;
	private static Corso corso;
	private static Corsista corsista;
	private static CorsoCorsista cc;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();

		corso = new Corso();
		
		corso.setCodCorso(1);
		corso.setNomeCorso("Inglese");
		corso.setDataInizio(new GregorianCalendar(2022, 10, 15).getTime());
		corso.setDataFine(new GregorianCalendar(2022, 12, 20).getTime());
		corso.setCosto(150);
		corso.setCommento("Impara Java");
		corso.setAulaCorso("N5");
		corso.setCodDocente(1);
		
		corsista =new Corsista();
		corsista.setNomeCorsista("Franco");
		corsista.setCognomeCorsista("Molis");
		corsista.setCodiceCorsista(1);
		corsista.setPrecedentiFormativi(false);
		
		
		cc = new CorsoCorsista();
		cc.setCodCorso(1);
		cc.setCodCorsista(1);
		
		
		
	}
	

	@Test
	void corsoCorsistaTest() throws DAOException {
		try {
			CorsoDAO.getFactory().create(conn, corso);
			CorsistiDAO.getFactory().create(conn, corsista);
			CorsoCorsistaDAO.getFactory().create(conn, cc);
			//System.out.println(cc.toString());
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsistiDAO.getFactory().delete(conn, corsista);
			CorsoDAO.getFactory().delete(conn, corso);
			DBAccess.closeConnetion();
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}


}
