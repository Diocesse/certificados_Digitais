/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.bean;

import edu.ifba.hibernate.cruddao.CrudDaoAutor;
import edu.ifba.hibernate.entidade.Autor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diocesse
 */
public class BeanAutor {
    private Autor autor = new Autor();
    private final List<Autor> autors = new ArrayList<>();
    private final CrudDaoAutor daoAutor;

    public BeanAutor() {
        this.daoAutor = new CrudDaoAutor();
    }
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    public boolean cadastrarAutor(){
        try {
            daoAutor.salvar(autor);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
