package test.com.roma.gestionecorsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dao.DocenteDAO;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.model.Docente;


@TestMethodOrder(OrderAnnotation.class)
class DocenteDAOTest {
	private static Connection conn;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
	}
	
	//Test get by cod
	@Test
	@Order(1)
	void testGetByCod() {
		try {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Insert into docente values('Andrea','Tulino','',3)");
			conn.commit();
			Docente docente =DocenteDAO.getFactory().getById(conn, 3);
			System.out.println(docente.toString());
		}catch(SQLException  exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	
	//get all
	@Test
	@Order(2)
	void testGetAll() {
		try {
			DocenteDAO.getFactory().getAll(conn);
			
		}catch( DAOException  exc) {
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			Statement stmt = conn.createStatement();
				stmt.executeUpdate("Delete from docente where cod_docente=3");
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
