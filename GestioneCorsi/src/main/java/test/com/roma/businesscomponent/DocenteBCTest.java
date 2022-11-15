package test.com.roma.businesscomponent;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.roma.businesscomponent.DocenteBC;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.model.Docente;


@TestMethodOrder(OrderAnnotation.class)
class DocenteBCTest {
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Insert into docente values('Andrea','Tulino','',3)");
		stmt.executeUpdate("Insert into docente values('francesco','Francese','',4)");
		conn.commit();
	}
	
	@Test
	@Order(1)
	void testFindByCod() throws ClassNotFoundException, IOException {
		try {
		Docente d = new DocenteBC().findByCod(4);
		System.out.println(d.toString());
		} catch(SQLException  exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testGetDocenti() throws ClassNotFoundException, IOException {
		try {
		Docente [] d = new DocenteBC().getDocenti();
		System.out.println("Get all()");
		for(Docente doc : d) {
			System.out.println(doc.toString());
		}
		
		} catch(SQLException  exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	
	
	
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			Statement stmt = conn.createStatement();
				stmt.executeUpdate("Delete from docente where cod_docente=3");
				stmt.executeUpdate("Delete from docente where cod_docente=4");
				conn.commit();
		}
		catch(SQLException exc)
		{
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
		DBAccess.closeConnetion();
	}

	

}
