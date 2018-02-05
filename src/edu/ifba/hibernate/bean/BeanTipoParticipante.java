/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.bean;

import edu.ifba.hibernate.cruddao.CrudDaoTipoParticipante;
import edu.ifba.hibernate.entidade.TipoParticipante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diocesse
 */
public class BeanTipoParticipante {
    
    private TipoParticipante tp = new TipoParticipante();
    private CrudDaoTipoParticipante crud = new CrudDaoTipoParticipante();
    private List<TipoParticipante> tipoParticipantes = new ArrayList<TipoParticipante>();

    public boolean salvar(){
        try {
            crud.criar(tp);
            tp=null;
            return true;
        } catch (Exception e) {
            return false;
        }
 
    }
    
    public List<TipoParticipante> getTipoParticipantes() {
        tipoParticipantes = crud.listaCategoriasParticipantes();
        return tipoParticipantes;
    }
    public TipoParticipante findTipo(int id){
        tp = crud.getTipoParticipante(id);
        return tp;
    }
    public TipoParticipante getTp() {
        return tp;
    }

    public void setTp(TipoParticipante tp) {
        this.tp = tp;
    }
    
    
    public static void main (String args[]){
        System.out.println( "TP:"+new BeanTipoParticipante().findTipo(1));
    }
     
    
}
