package test.com.roma.gestionecorsi.businesscomponent;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.AmministratoreBC;
import com.roma.gestionecorsi.businesscomponent.model.Amministratore;

@TestMethodOrder(OrderAnnotation.class)
class AmministratoreBCTest {
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Insert into amministratore values(2,'Andrea','Tulino')");
		conn.commit();
	}
	
	@Test
	@Order(1)
	void testFindByID() throws ClassNotFoundException, IOException {
		try {
			Amministratore amministratore = new AmministratoreBC().findByID(2);
			System.out.println(amministratore);
		}catch(SQLException sql){
			sql.printStackTrace();
			fail("Motivo: "+sql.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testGetAdmin() throws ClassNotFoundException, IOException {
		try {
			Amministratore[] amministratori = new AmministratoreBC().getAdmin();
			for(Amministratore admin: amministratori)
				System.out.println(admin);
		}catch(SQLException sql){
			sql.printStackTrace();
			fail("Motivo: "+sql.getMessage());
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Delete from amministratore where cod_admin = 2");
		conn.commit();
		DBAccess.closeConnetion();
	}
}