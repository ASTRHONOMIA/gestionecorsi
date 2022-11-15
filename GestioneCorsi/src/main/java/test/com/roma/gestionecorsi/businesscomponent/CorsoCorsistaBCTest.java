package test.com.roma.gestionecorsi.businesscomponent;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.CorsistaBC;
import com.roma.gestionecorsi.businesscomponent.CorsoBC;
import com.roma.gestionecorsi.businesscomponent.CorsoCorsistaBC;
import com.roma.gestionecorsi.businesscomponent.model.Corsista;
import com.roma.gestionecorsi.businesscomponent.model.Corso;
import com.roma.gestionecorsi.businesscomponent.model.CorsoCorsista;

class CorsoCorsistaBCTest {
	private static Connection conn;
	private static Corso corso;
	private static Corsista corsista;
	private static CorsoCorsista cc;
	private static CorsoBC cBC;
	private static CorsistaBC corBC;
	private static CorsoCorsistaBC ccBC;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//Insert Docente
		conn = DBAccess.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Insert into docente values('Andrea','Tulino','',1)");
		conn.commit();

		
		corso = new Corso();
		cBC = new CorsoBC();
		
		corso.setCodCorso(1);
		corso.setNomeCorso("Inglese");
		corso.setDataInizio(new GregorianCalendar(2022, 10, 15).getTime());
		corso.setDataFine(new GregorianCalendar(2022, 12, 20).getTime());
		corso.setCosto(150);
		corso.setCommento("Impara Java");
		corso.setAulaCorso("N5");
		corso.setCodDocente(1);
		
		
		corBC = new CorsistaBC();
		corsista = new Corsista();
		corsista.setCognomeCorsista("Tulino");
		corsista.setNomeCorsista("Andrea");
		corsista.setPrecedentiFormativi(false);
		
		
		
		corsista.setPrecedentiFormativi(false);
		
		
		cc = new CorsoCorsista();
		ccBC = new CorsoCorsistaBC();
		
		
	}
	
	@Test
	void create() {
		try {
			cBC.createCorso(corso);
			System.out.println(corso.toString());
			
			corBC.createOrUpdate(corsista);
			System.out.println(corsista.toString());
			
			cc.setCodCorso(corso.getCodCorso());
			cc.setCodCorsista(corsista.getCodiceCorsista());
			ccBC.create(cc);
			System.out.println(cc.toString());
			
		}catch (ClassNotFoundException | DAOException | IOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			corBC.delete(corsista);
			cBC.deleteCorso(corso);
			
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
