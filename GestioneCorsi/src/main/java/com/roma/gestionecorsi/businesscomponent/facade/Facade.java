package com.roma.gestionecorsi.businesscomponent.facade;

import java.io.IOException;
import java.util.Date;

import com.roma.gestionecorsi.architecture.dao.DAOException;
import com.roma.gestionecorsi.businesscomponent.AmministratoreBC;
import com.roma.gestionecorsi.businesscomponent.CorsistaBC;
import com.roma.gestionecorsi.businesscomponent.CorsoBC;
import com.roma.gestionecorsi.businesscomponent.DocenteBC;
import com.roma.gestionecorsi.businesscomponent.model.Amministratore;
import com.roma.gestionecorsi.businesscomponent.model.Corsista;
import com.roma.gestionecorsi.businesscomponent.model.Corso;
import com.roma.gestionecorsi.businesscomponent.model.Docente;

public class Facade {
	private static Facade f;
	private AmministratoreBC aBC;
	private CorsistaBC cBC;
	private DocenteBC dBC;
	private CorsoBC corBC;

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

	// Inizio Facede per Amministratore

	public Amministratore findAmministratoreByid(long cod) throws ClassNotFoundException, DAOException, IOException {
		aBC = new AmministratoreBC();
		return aBC.findByID(cod);
	}

	public Amministratore[] getAmministratori() throws DAOException, ClassNotFoundException, IOException {
		aBC = new AmministratoreBC();
		return aBC.getAdmin();
	}

	// Fine Facede per Amministratore

	// Inizio Facede per Docente

	public Docente findDocenteById(long cod) throws ClassNotFoundException, DAOException, IOException {
		dBC = new DocenteBC();
		return dBC.findByCod(cod);
	}

	public Docente[] getDocenti() throws ClassNotFoundException, DAOException, IOException {
		dBC = new DocenteBC();
		return dBC.getDocenti();
	}

	// Fine Face per Docente

	// Inizio Facede per Corso

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

	public int numeroCommenti(Corso corso) throws ClassNotFoundException, DAOException, IOException {
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

}
