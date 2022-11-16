package test.com.roma.gestionecorsi.businesscomponent;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.businesscomponent.CorsistaBC;
import com.roma.gestionecorsi.businesscomponent.codgenerator.CorsistaCodGenerator;
import com.roma.gestionecorsi.businesscomponent.model.Corsista;

@TestMethodOrder(OrderAnnotation.class)
class CorsistaBCTest {
	static Corsista corsista;
	static CorsistaBC cBC;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
			cBC = new CorsistaBC();
			corsista = new Corsista();
			corsista.setCognomeCorsista("Tulino");
			corsista.setNomeCorsista("Andrea");
			corsista.setPrecedentiFormativi(false);
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			cBC.createOrUpdate(corsista);
		} catch (ClassNotFoundException | DAOException | IOException e) {
			e.printStackTrace();
			fail("Motivo: " + e.getMessage());
		}
	}

	@Test
	@Order(2)
	void testfindByCod() {
		try {
				System.out.println(cBC.findByCod(CorsistaCodGenerator.getInstance().getNextCod()-1).toString());
		} catch (DAOException | ClassNotFoundException | IOException e) {
			e.printStackTrace();
			fail("Motivo: "+ e.getMessage());
		}
	}
		
		@Test
		@Order(3)
		void testgetCorsisti() {
			try {
					corsista.setPrecedentiFormativi(true);
					cBC.createOrUpdate(corsista);
					Corsista[] corsisti;
					System.out.println("Numero corsisti: "+ cBC.getNumberCorsisti());
					corsisti=cBC.getCorsisti();
					for(Corsista c : corsisti)
						System.out.println(c);
			} catch (DAOException | ClassNotFoundException | IOException e) {
				e.printStackTrace();
				fail("Motivo: "+ e.getMessage());
			}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			cBC.delete(corsista);
			System.out.println("eliminato corsista");
		} catch (DAOException exc) {
			exc.printStackTrace();
			System.out.println(exc.getMessage());
		}

	}

}
