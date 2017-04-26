/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fitec.service;

import java.util.List;

import fitec.dba.dao.IDao;
import fitec.dba.metier.Metier;



/**
 *
 * @author Fitec
 */
public abstract class Services<T extends Metier> {


    protected IDao<T> dao;

    public void insert(T m) {
        dao.insert(m);
    }

    public void update(T m) {
        dao.update(m);
    }

    public List<T> liste(T m) {
        List<T> l = dao.selectAll();
        return l;
    }

    public IDao<T> getDao() {
        return dao;
    }
    
    public List<T> selectLike(String str) {
        List<T> l = dao.searchLike(str);
        return l;
    }

}
