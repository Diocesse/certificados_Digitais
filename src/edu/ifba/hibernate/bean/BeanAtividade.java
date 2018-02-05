/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.bean;

import edu.ifba.hibernate.cruddao.CrudDaoATividade;
import edu.ifba.hibernate.entidade.Atividade;
import java.util.List;

/**
 *
 * @author diocesse
 */
public class BeanAtividade {

    private CrudDaoATividade daoATividade = new CrudDaoATividade();
    private Atividade atividade = new Atividade();

    

    public Atividade getAtividade() {
        return atividade;
    }
    
     public Atividade getAtividade(int id) {
         atividade =(Atividade)daoATividade.getFiltroUnico(id);
        return atividade;
    }
    

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }
    
    public boolean salvar(){
        try {
            daoATividade.salvar(atividade);
            setAtividade(null);
            return true;
        } catch (Exception e) {
            return true;
        }
        
    }
    public boolean update(){
        try {
            daoATividade.update(atividade);
            setAtividade(null);
            return true;
        } catch (Exception e) {
            return true;
        }
        
    }
    

    public List<Atividade> getAtividades() {
        return daoATividade.listaInfoAll();
    }
    
   public List<Atividade> getFiltroAtividades(String busca) {
        return daoATividade.listaInfoFiltroAll(busca);
    }
     
    

}
