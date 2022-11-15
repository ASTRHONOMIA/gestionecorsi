package test.com.roma.gestionecorsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.roma.gestionecorsi.architecture.dao.AmministratoreDAO;
import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.model.Amministratore;

@TestMethodOrder(OrderAnnotation.class)
class AmministratoreDAOTest {
	private static Amministratore amministratore;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
			conn = DBAccess.getConnection();
			
		
	}
	
	@Test
	@Order(1)
	void testGetAll() {
		try {
			amministratore = null;
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Insert into amministratore values(2,'Andrea','Tulino')");
			conn.commit();
			Amministratore[] amministratori = AmministratoreDAO.getFactory().getAll(conn);
			assertNotNull(amministratori);
		}catch(SQLException  exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testGetByID() {
		try {
			Amministratore amministratore = AmministratoreDAO.getFactory().getById(conn, 2);
			System.out.println(amministratore.toString());
		}catch(DAOException exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		amministratore = null;
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Delete from amministratore where cod_admin = 2");
		conn.commit();
		DBAccess.closeConnetion();
	}
}