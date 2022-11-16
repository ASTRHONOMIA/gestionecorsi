package test.com.roma.gestionecorsi.businesscomponent;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.CorsoBC;
import com.roma.gestionecorsi.businesscomponent.model.Corso;

@TestMethodOrder(OrderAnnotation.class)
class CorsoBCTest {
	private static Connection conn;
	private static Corso corso;
	private static Corso corso2;
	private static CorsoBC cBC;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Insert into docente values('francesco','Francese','',1)");
		conn.commit();
		
		corso = new Corso();
		
		corso.setNomeCorso("Inglese");
		corso.setDataInizio(new GregorianCalendar(2022, 10, 15).getTime());
		corso.setDataFine(new GregorianCalendar(2022, 12, 20).getTime());
		corso.setCosto(150);
		corso.setCommento("Impara Java");
		corso.setAulaCorso("N5");
		corso.setCodDocente(1);
		
		corso2 = new Corso();
		
		corso2.setNomeCorso("Betacom accademy");
		corso2.setDataInizio(new GregorianCalendar(2021, 9, 10).getTime());
		corso2.setDataFine(new GregorianCalendar(2021, 12, 20).getTime());
		corso2.setCosto(150);
		corso2.setCommento("Impara Java");
		corso2.setAulaCorso("N5");
		corso2.setCodDocente(1);
		
		cBC = new CorsoBC();
		
	}
	
	
	@Test
	@Order(1)
	void createTest() {
		try {
			cBC.createCorso(corso);
			cBC.createCorso(corso2);
			System.out.println(corso.toString());
		}catch (ClassNotFoundException | DAOException | IOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void updateTest() {
		try {
			Corso cor2 = new Corso();
			cor2.setCodCorso(corso.getCodCorso());
			cor2.setNomeCorso("English");
			cor2.setDataInizio(new GregorianCalendar(2022, 10, 15).getTime());
			cor2.setDataFine(new GregorianCalendar(2022, 12, 20).getTime());
			cor2.setCosto(250);
			cor2.setCommento("Impara Java");
			cor2.setAulaCorso("N5");
			cor2.setCodDocente(1);
			cBC.updateCorso(cor2);
			System.out.println("Update corso"+cor2.toString());
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(3)
	void findByID() {
		try {
			cBC.getById(corso.getCodCorso());
			System.out.println(cBC.getById(corso.getCodCorso()).toString());
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(4)
	void getDurataCorso() {
		try {
			cBC.getDurataCorso(corso);
			System.out.println("Durata Corso: "+ cBC.getDurataCorso(corso));
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(4)
	void getNumeroCommenti() {
		try {
			cBC.getNumeroCommenti();
			System.out.println("numero commenti "+ cBC.getNumeroCommenti());
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	

	@Test
	@Order(5)
	void getCorsi() {
		try {
			Corso[] corsi =	cBC.getCorsi();
			System.out.println("Elenco Corsi");
			for(Corso cor : corsi) {
				System.out.println(cor.toString());
			}
			
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(6)
	void getDataUltimoCorso() {
		try {
			
			System.out.println("Data Inizio ultimo Corso"+ new java.util.Date(cBC.getInizioUltimoCorso().getTime()));
			
			
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	
	@Test
	@Order(7)
	void getDurataMediaCorsi() {
		try {
			System.out.println(cBC.getDurataMediaCorsi());
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			
			cBC.deleteCorso(corso);
			cBC.deleteCorso(corso2);
			
			//Delete Docente
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Delete from docente where cod_docente=1");
			conn.commit();
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
		
	}

	
}
