package test.com.roma.gestionecorsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.roma.gestionecorsi.architecture.dao.CorsoDAO;
import com.roma.gestionecorsi.architecture.dao.DocenteDAO;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.model.Corso;
import com.roma.gestionecorsi.businesscomponent.model.Docente;
import com.roma.gestionecorsi.architecture.dao.DAOException;

class CorsoDAOTest {
	private static Connection conn;
	private static Corso corso;
	private static Docente docente;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		docente = new Docente();
		corso = new Corso();
		
		docente.setCodDocente(1);
		docente.setNomeDocente("Marco");
		docente.setCognomeDocente("Rossi");
		docente.setCvDocente("File");
		
		corso.setCodCorso(1);
		corso.setNomeCorso("Java");
		corso.setDataInizio(new GregorianCalendar(2022, 10, 15).getTime());
		corso.setDataFine(new GregorianCalendar(2022, 12, 20).getTime());
		corso.setCosto(150);
		corso.setCommento("Impara Java");
		corso.setAulaCorso("N5");
		corso.setCodDocente(1);
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			DocenteDAO.getFactory().delete(conn, docente);
			CorsoDAO.getFactory().delete(conn, corso);
			DBAccess.closeConnetion();
			System.out.println("Docente e Corso distrutto");
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}

	@Test
	void testCreate() {
		try {
			DocenteDAO.getFactory().create(conn, docente);
			CorsoDAO.getFactory().create(conn, corso);
			System.out.println("Docente e Corso creato");
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}

}
