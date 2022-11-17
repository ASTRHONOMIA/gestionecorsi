package test.com.roma.gestionecorsi.businesscomponent.utilities;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import com.roma.gestionecorsi.businesscomponent.utilities.Validazione;

class ValidazioneTest {

	@Test
	void testValidazioneStringa() {
		Validazione validate=new Validazione();
		assertTrue(validate.convalidaStringa("Luca"));
		assertFalse(validate.convalidaStringa("Luca5"));
	}
	
	
	@Test
	void testValidazioneNomeCorso() {
		Validazione validate=new Validazione();
		assertTrue(validate.convalidaAula("B 123"));
	}
	
	@Test
	void testValidazioneFormatoDate() {
		Validazione validate=new Validazione();
		assertFalse(validate.convalidaFormatoDate("30/2/1999"));
		assertFalse(validate.convalidaFormatoDate("30/2/2000"));
		assertTrue(validate.convalidaFormatoDate("31/12/2000"));
		assertFalse(validate.convalidaFormatoDate("31/11/2000"));
		assertTrue(validate.convalidaFormatoDate("30/11/2000"));
		assertFalse(validate.convalidaFormatoDate("31-10-2000"));
		assertFalse(validate.convalidaFormatoDate("31.10.2000"));
		assertFalse(validate.convalidaFormatoDate("10/31/2000"));
		assertFalse(validate.convalidaFormatoDate("2000/10/31"));
		assertFalse(validate.convalidaFormatoDate("2000/31/10"));
	}
	
	@Test
	void testValidaDate()
	{
		Validazione validate=new Validazione();
		assertTrue(validate.convalidaDate("15/11/2022", "18/11/2022"));
		assertTrue(validate.convalidaDate("17/11/2022", "18/11/2022"));
		assertTrue(validate.convalidaDate("17/11/2022", "18/11/2022"));
		assertFalse(validate.convalidaDate("19/11/2022", "20/11/2022"));
		assertFalse(validate.convalidaDate("18/11/2022", "19/11/2022"));
		assertTrue(validate.convalidaDate("18/11/2022", "21/11/2022"));
		
	}

}
