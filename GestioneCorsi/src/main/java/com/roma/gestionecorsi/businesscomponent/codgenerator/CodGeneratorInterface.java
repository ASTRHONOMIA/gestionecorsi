package com.roma.gestionecorsi.businesscomponent.codgenerator;

import java.io.IOException;

import com.roma.gestionecorsi.architecture.dao.DAOException;


public interface CodGeneratorInterface {

	long getNextCod() throws DAOException,IOException,ClassNotFoundException;
	
}
