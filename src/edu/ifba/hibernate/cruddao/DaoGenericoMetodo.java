/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.cruddao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author diocesse
 */
public abstract class DaoGenericoMetodo implements Serializable {

    public abstract void salvar(Object obj);

    public abstract void update(Object obj);

    public abstract void remove(Object obj);

    public abstract List<?> listaInfoAll();

    public abstract List<?> listaInfoFiltroAll(String busca);
    
    public abstract Object getFiltroUnico(int id);

}
