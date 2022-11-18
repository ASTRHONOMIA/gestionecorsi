package com.roma.gestionecorsi.businesscomponent.facade;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.businesscomponent.AmministratoreBC;
import com.roma.gestionecorsi.businesscomponent.CorsistaBC;
import com.roma.gestionecorsi.businesscomponent.CorsoBC;
import com.roma.gestionecorsi.businesscomponent.CorsoCorsistaBC;
import com.roma.gestionecorsi.businesscomponent.DocenteBC;
import com.roma.gestionecorsi.businesscomponent.model.Amministratore;
import com.roma.gestionecorsi.businesscomponent.model.Corsista;
import com.roma.gestionecorsi.businesscomponent.model.Corso;
import com.roma.gestionecorsi.businesscomponent.model.CorsoCorsista;
import com.roma.gestionecorsi.businesscomponent.model.Docente;
import com.roma.gestionecorsi.businesscomponent.utilities.Validazione;

public class Facade {
	private static Facade f;
	private AmministratoreBC aBC;
	private CorsistaBC cBC;
	private DocenteBC dBC;
	private CorsoBC corBC;
	private CorsoCorsistaBC corcorsBC;
	private Validazione valBC;

	private Facade() {
	}

	public static Facade getIstance() {
		if (f == null)
			f = new Facade();
		return f;
	}

	// Inizio Facade per Corsista

	public void createOrUpdate(Corsista corsista) throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsistaBC();
		cBC.createOrUpdate(corsista);
	}

	public Corsista[] getCorsisti() throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsistaBC();
		return cBC.getCorsisti();
	}

	public Corsista findCorsistaByCod(long cod) throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsistaBC();
		return cBC.findByCod(cod);
	}

	public void deleteCorsita(Corsista corsista) throws DAOException, ClassNotFoundException, IOException {
		cBC = new CorsistaBC();
		cBC.delete(corsista);
	}

	public int getNumberCorsisti() throws ClassNotFoundException, DAOException, IOException {
		cBC = new CorsistaBC();
		return cBC.getNumberCorsisti();
	}
	// fine Facade per Corsista

	// Inizio Facade per Amministratore

	public Amministratore findAmministratoreByid(long cod) throws ClassNotFoundException, DAOException, IOException {
		aBC = new AmministratoreBC();
		return aBC.findByID(cod);
	}

	public Amministratore[] getAmministratori() throws DAOException, ClassNotFoundException, IOException {
		aBC = new AmministratoreBC();
		return aBC.getAdmin();
	}

	// Fine Facade per Amministratore

	// Inizio Facade per Docente

	public Docente findDocenteById(long cod) throws ClassNotFoundException, DAOException, IOException {
		dBC = new DocenteBC();
		return dBC.findByCod(cod);
	}

	public Docente[] getDocenti() throws ClassNotFoundException, DAOException, IOException {
		dBC = new DocenteBC();
		return dBC.getDocenti();
	}

	// Fine Facade per Docente

	// Inizio Facade per Corso

	public void createCorso(Corso corso) throws DAOException, ClassNotFoundException, IOException {
		corBC = new CorsoBC();
		corBC.createCorso(corso);

	}

	public void updateCorso(Corso corso) throws ClassNotFoundException, DAOException, IOException {
		corBC = new CorsoBC();
		corBC.updateCorso(corso);
	}

	public Corso findByCod(long cod) throws ClassNotFoundException, DAOException, IOException {
		corBC = new CorsoBC();
		return corBC.getById(cod);
	}

	public Corso[] getCorsi() throws ClassNotFoundException, DAOException, IOException {
		corBC = new CorsoBC();
		return corBC.getCorsi();
	}

	public void deleteCorsi(Corso corso) throws ClassNotFoundException, DAOException, IOException {
		corBC = new CorsoBC();
		corBC.deleteCorso(corso);
	}

	public int numeroCommenti() throws ClassNotFoundException, DAOException, IOException {
		corBC = new CorsoBC();
		return corBC.getNumeroCommenti();
	}

	public Date getInizioUltimoCorso() throws ClassNotFoundException, DAOException, IOException {
		corBC = new CorsoBC();
		return corBC.getInizioUltimoCorso();
	}

	public Corso[] getCorsiAperti() throws ClassNotFoundException, DAOException, IOException {
		corBC = new CorsoBC();
		return corBC.getCorsiFromDate();
	}
	
	public int getDurataCorso(Corso corso) throws ClassNotFoundException, DAOException, IOException
	{
		corBC= new CorsoBC();
		return corBC.getDurataCorso(corso);
	}
	
	public int postiDisponibili(Long cod) throws ClassNotFoundException, DAOException, IOException
	{
		corBC=new CorsoBC();
		return corBC.postiDisponibili(getNumberCorsisti());
	}
	
	//Fine Facade per Corso
	
	//Inizio Facade per CorsoCorsista
	public void createCorsoCorstita(CorsoCorsista corsoCorsista) throws ClassNotFoundException, DAOException, IOException
	{
		corcorsBC=new CorsoCorsistaBC();
		corcorsBC.create(corsoCorsista);
	}
	
	public String[] corsoPiuFrequentato() throws DAOException, ClassNotFoundException, IOException
	{
		corcorsBC=new CorsoCorsistaBC();
		return corcorsBC.corsoPiuFrequentato();
	}
	
	public long[] corsiDelCorsista(long cod) throws ClassNotFoundException, DAOException, IOException
	{
		corcorsBC=new CorsoCorsistaBC();
		return corcorsBC.corsiDelCorsista(cod);
	}
	
	public CorsoCorsista[] getAllCorsoCorsista() throws ClassNotFoundException, DAOException, IOException
	{
		corcorsBC= new CorsoCorsistaBC();
		return corcorsBC.getAll();
	}
	
	public Corso[] getCorsiPrenotabili(long cod) throws ClassNotFoundException, DAOException, IOException
	{
		corcorsBC= new CorsoCorsistaBC();
		return corcorsBC.getCorsiPrenotabili(cod);
	}
	
	
	//Fine Facade per CorsoCorsista
	
	//Inizio Facade Validazione
	public boolean convalidaStringa(String stringa)
	{
		valBC = new Validazione();
		return valBC.convalidaStringa(stringa);
	}
	
	public boolean convalidaCommento(String commento)
	{
		valBC = new Validazione();
		return valBC.convalidaCommento(commento);
	}
	
	public boolean convalidaFormatoDate(String data)
	{
		valBC = new Validazione();
		return valBC.convalidaFormatoDate(data);
	}
	
	public boolean convalidaDate(String data1,String data2)
	{
		valBC = new Validazione();
		return valBC.convalidaDate(data1,data2);
	}
	
	public boolean convalidaAula(String aula)
	{
		valBC = new Validazione();
		return valBC.convalidaAula(aula);
	}
	
	
	
	
	
}
