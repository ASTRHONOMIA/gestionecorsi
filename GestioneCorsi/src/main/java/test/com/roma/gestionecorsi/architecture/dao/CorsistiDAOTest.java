package test.com.roma.gestionecorsi.architecture.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.roma.gestionecorsi.architecture.dao.CorsistiDAO;
import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)

class CorsistiDAOTest {
	private static Connection conn;
	private static Corsista corsista;
	private static Corsista corsista2;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn=DBAccess.getConnection();
		corsista =new Corsista();
		corsista.setNomeCorsista("Andrea");
		corsista.setCognomeCorsista("Tulino");
		corsista.setCodiceCorsista(1);
		corsista.setPrecedentiFormativi(false);
		
		corsista2 =new Corsista();
		corsista2.setNomeCorsista("Alessio");
		corsista2.setCognomeCorsista("Tulino");
		corsista2.setCodiceCorsista(2);
		corsista2.setPrecedentiFormativi(false);
	}
	
	@Test
	@Order(1)
	void testCreate()
	{
		try
		{
			CorsistiDAO.getFactory().create(conn, corsista);
			CorsistiDAO.getFactory().create(conn, corsista2);
		}
		catch(DAOException exc)
		{
			exc.printStackTrace();
			fail("Motivo" + exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdateGetById() {
		try {
			Corsista corsista = new Corsista();
			corsista.setNomeCorsista("Andrea");
			corsista.setCognomeCorsista("Tulino");
			corsista.setCodiceCorsista(5);
			corsista.setPrecedentiFormativi(true);
			CorsistiDAO.getFactory().update(DBAccess.getConnection(), corsista);
			System.out.println("Aggiornato articolo: ");
			Corsista cors = CorsistiDAO.getFactory().getById(conn, 1);
			System.out.println(cors.toString());
			System.out.println("Numero corsisti totali: "+ CorsistiDAO.getFactory().getNumberCorsisti(conn));
		} catch (ClassNotFoundException | DAOException | IOException exc) {
			exc.printStackTrace();
			fail("Motivo" + exc.getMessage());
		}

	}
	
	@Test
	@Order(3)
	public  void testGetAll()
	{
		try {
			Corsista[]corsista=CorsistiDAO.getFactory().getAll(conn);
			for(Corsista i: corsista)
			{
				System.out.println(i);
			}
			assertNotNull(corsista);
		}
		catch(DAOException exc)
		{
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try
		{
			CorsistiDAO.getFactory().delete(conn, corsista);
			CorsistiDAO.getFactory().delete(conn, corsista2);
			System.out.println("Eliminato corsista");
			conn.commit();
			DBAccess.closeConnetion();
		}
		catch(DAOException exc)
		{
			exc.printStackTrace();
			fail("Motivo: "+exc.getMessage());
		}
		
	}

	

}
