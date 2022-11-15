package test.com.roma.gestionecorsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.roma.gestionecorsi.architecture.dao.CorsoDAO;
import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.model.Corso;

@TestMethodOrder(OrderAnnotation.class)
class CorsoDAOTest {
	private static Connection conn;
	private static Corso corso;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();

		corso = new Corso();
		
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
			CorsoDAO.getFactory().delete(conn, corso);
			DBAccess.closeConnetion();
			System.out.println("Docente e Corso distrutto");
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsoDAO.getFactory().create(conn, corso);
			System.out.println("Docente e Corso creato");
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdate() {
		try {
			Corso c = new Corso();
			
			c.setCodCorso(1);
			c.setNomeCorso("PHP");
			c.setDataInizio(new GregorianCalendar(2022, 10, 10).getTime());
			c.setDataFine(new GregorianCalendar(2022, 12, 10).getTime());
			c.setCosto(150);
			c.setCommento("Impara PHP");
			c.setAulaCorso("N5");
			c.setCodDocente(1);
			
			CorsoDAO.getFactory().update(conn, c);
			System.out.println("Docente e Corso Updatato");
			
			Corso cor = CorsoDAO.getFactory().getById(conn, 1);
			System.out.println(cor.toString());
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void testFindById() {
		try {
			corso = new Corso();
			corso.setCodCorso(1);
			corso.setNomeCorso("Java");
			corso.setDataInizio(new GregorianCalendar(2022, 10, 15).getTime());
			corso.setDataFine(new GregorianCalendar(2022, 11, 20).getTime());
			corso.setCosto(150);
			corso.setCommento("Impara Java");
			corso.setAulaCorso("N5");
			corso.setCodDocente(1);
			
			CorsoDAO.getFactory().update(conn, corso);
			System.out.println("Aggiornamento Corso");
			
			Corso cor = CorsoDAO.getFactory().getById(conn, 1);
			System.out.println(cor.toString());
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(4)
	void testFindAll() {
		try {
			Corso[] co = CorsoDAO.getFactory().getAll(conn);
			
			assertNotNull(co);
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(5)
	void testGetData() {
		try {
			Date data =  CorsoDAO.getFactory().getInizioCorso(conn, 1);
			System.out.println(data.toString());
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(6)
	void testGetNumeroCommenti() {
		try {
			int i =  CorsoDAO.getFactory().getNumeroCommenti(conn);
			System.out.println(i);
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(7)
	void testGetAfterDate() {
		try {
			Corso[] co = CorsoDAO.getFactory().getCorsoFromDate(conn);
			
			assertNotNull(co);
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(8)
	void testDate() {
		try {
			int num = CorsoDAO.getFactory().getDurataCorso(conn, corso);
			System.out.println("Numero giorni: " + num);
		} catch (Exception e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
}
