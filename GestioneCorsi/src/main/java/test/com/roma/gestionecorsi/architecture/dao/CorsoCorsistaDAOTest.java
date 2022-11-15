package test.com.roma.gestionecorsi.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.sql.Statement;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.roma.gestionecorsi.architecture.dao.CorsistiDAO;
import com.roma.gestionecorsi.architecture.dao.CorsoCorsistaDAO;
import com.roma.gestionecorsi.architecture.dao.CorsoDAO;
import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.architecture.dbaccess.DBAccess;
import com.roma.gestionecorsi.businesscomponent.CorsoBC;
import com.roma.gestionecorsi.businesscomponent.model.Corsista;
import com.roma.gestionecorsi.businesscomponent.model.Corso;
import com.roma.gestionecorsi.businesscomponent.model.CorsoCorsista;

class CorsoCorsistaDAOTest {
	private static Connection conn;
	private static Corso corso;
	private static Corso corso2;
	private static Corso corso3;
	private static Corsista corsista;
	private static CorsoCorsista cc;
	private static CorsoCorsista cc2;
	private static CorsoCorsista cc3;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		
		

		Statement stmt = conn.createStatement();
		stmt.executeUpdate("Insert into docente values('francesco','Francese','',1)");
		conn.commit();

		corso = new Corso();
		corso.setCodCorso(1);
		corso.setNomeCorso("Inglese");
		corso.setDataInizio(new GregorianCalendar(2022, 10, 15).getTime());
		corso.setDataFine(new GregorianCalendar(2022, 12, 20).getTime());
		corso.setCosto(150);
		corso.setCommento("Impara Java");
		corso.setAulaCorso("N5");
		corso.setCodDocente(1);
		
		corso2 = new Corso();
		corso2.setCodCorso(2);
		corso2.setNomeCorso("Francese");
		corso2.setDataInizio(new GregorianCalendar(2022, 10, 15).getTime());
		corso2.setDataFine(new GregorianCalendar(2022, 12, 20).getTime());
		corso2.setCosto(150);
		corso2.setCommento("Impara Java");
		corso2.setAulaCorso("N5");
		corso2.setCodDocente(1);
		
		corso3 = new Corso();
		corso3.setCodCorso(3);
		corso3.setNomeCorso("Francese");
		corso3.setDataInizio(new GregorianCalendar(2022, 10, 15).getTime());
		corso3.setDataFine(new GregorianCalendar(2022, 12, 20).getTime());
		corso3.setCosto(150);
		corso3.setCommento("Impara Java");
		corso3.setAulaCorso("N5");
		corso3.setCodDocente(1);
		
		corsista =new Corsista();
		corsista.setNomeCorsista("Franco");
		corsista.setCognomeCorsista("Molis");
		corsista.setCodiceCorsista(1);
		corsista.setPrecedentiFormativi(false);
		
		
		cc = new CorsoCorsista();
		cc.setCodCorso(1);
		cc.setCodCorsista(1);
		
		cc2 = new CorsoCorsista();
		cc2.setCodCorso(2);
		cc2.setCodCorsista(1);
		
		cc3 = new CorsoCorsista();
		cc3.setCodCorso(3);
		cc3.setCodCorsista(1);
		
		
		
	}
	

	@Test
	void corsoCorsistaTest() throws DAOException {
		try {
			CorsoDAO.getFactory().create(conn, corso3);
			CorsoDAO.getFactory().create(conn, corso2);
			CorsoDAO.getFactory().create(conn, corso);
			CorsistiDAO.getFactory().create(conn, corsista);
			CorsoCorsistaDAO.getFactory().create(conn, cc);
			CorsoCorsistaDAO.getFactory().create(conn, cc2);
			CorsoCorsistaDAO.getFactory().create(conn, cc3);
			String[] c = CorsoCorsistaDAO.getFactory().CorsoPiuFrequentato(conn);
			System.out.println("Corsi piu frequentati:");
			for(String nomi: c)
				System.out.println(nomi);
			System.out.println(corsista.getCodiceCorsista());
			System.out.println("Corsi frquentati dal corsista:");
			long cod[]=CorsoCorsistaDAO.getFactory().corsiDelCorsista(conn, corsista.getCodiceCorsista());
			for(int i=0;i<cod.length;i++)
			{
				System.out.println(CorsoDAO.getFactory().getById(conn, cod[i]));
			}
			//System.out.println(cc.toString());
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsistiDAO.getFactory().delete(conn, corsista);
			CorsoDAO.getFactory().delete(conn, corso);
			CorsoDAO.getFactory().delete(conn, corso2);
			CorsoDAO.getFactory().delete(conn, corso3);
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("Delete from docente where cod_docente=1");
			conn.commit();
			DBAccess.closeConnetion();
		}catch (DAOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}


}
