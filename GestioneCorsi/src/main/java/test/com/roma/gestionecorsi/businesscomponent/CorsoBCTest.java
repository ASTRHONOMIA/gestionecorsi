package test.com.roma.gestionecorsi.businesscomponent;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.businesscomponent.CorsoBC;
import com.roma.gestionecorsi.businesscomponent.model.Corso;

@TestMethodOrder(OrderAnnotation.class)
class CorsoBCTest {
	private static Corso corso;
	private static CorsoBC corsoBC;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corso = new Corso();
		corsoBC = new CorsoBC();
		
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
			corsoBC.deleteCorso(corso);
			System.out.println("Corso distrutto");
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			corsoBC.createCorso(corso);
			System.out.println("Corso creato");
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdateAndById() {
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
			
			corsoBC.updateCorso(c);
			System.out.println("Corso Updatato");
			
			Corso cor = corsoBC.getById(1);
			System.out.println(cor.toString());
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void testGetCorsi() {
		try {
			Corso[] co = corsoBC.getCorsi();
			
			assertNotNull(co);
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(4)
	void testGetInizioUltimoCorso() {
		try {
			Date data = corsoBC.getInizioUltimoCorso();
			
			assertNotNull(data);
			
			System.out.println("Data ultimo inizio" + data.toString());
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(5)
	void testGetNumeroCommenti() {
		try {
			int num = corsoBC.getNumeroCommenti();
			
			System.out.println("Numero commeti: " + num);
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(6)
	void testGetCorsiFromDate() {
		try {
			Corso[] corsi = corsoBC.getCorsiFromDate();
			
			assertNotNull(corsi);
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(7)
	void testGetDurataMedia() {
		try {
			int durata = corsoBC.getDurataMedia(corso);
			
			System.out.println("Durata Corso: " + durata);
		} catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
}
