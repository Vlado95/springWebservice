package fitec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fitec.dba.factory.HbnFactory;
import fitec.dba.metier.Auteur;

@Service
public class ServiceAuteur extends Services<Auteur>{

	   @Autowired
	    public void setDao(HbnFactory dao) {
	        this.dao = dao.getDaoAuteur();
	    }
	
}
