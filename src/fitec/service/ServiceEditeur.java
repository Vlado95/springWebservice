package fitec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fitec.dba.factory.HbnFactory;
import fitec.dba.metier.Editeur;



@Service
public class ServiceEditeur  extends Services<Editeur>{

    @Autowired
    public void setDao(HbnFactory dao) {
        this.dao = dao.getDaoEditeur();
    }
}
