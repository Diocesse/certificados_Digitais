/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.bean;

import edu.ifba.hibernate.cruddao.CrudDaoAdministrador;
import edu.ifba.hibernate.entidade.Administrador;
import java.util.List;

/**
 *
 * @author diocesse
 */
public class BeanAdministrador {
    private Administrador administrador = new Administrador();
    private CrudDaoAdministrador controller = new CrudDaoAdministrador();
   
    public Administrador getAdministrador() {
        return administrador;
    }
   
    public void setAdministrador(Administrador administrador) {
        this.administrador = administrador;
    }
    
    
    public Administrador autenticacaoAdm(String login, String senha){
        try {
            administrador =(Administrador) controller.getAutenticacaoAdm(login, senha);
            return administrador;
        } catch (Exception e) {
            return null;
        }
    }
    
    public Administrador autenticacaoAdmGeral(String login, String senha){
        try {
            administrador =(Administrador) controller.autenticacaoAdmGeral(login, senha);
            return administrador;
        } catch (Exception e) {
            return null;
        }
    }
    
    public List<Administrador> listaAdministradores(){
        return (List<Administrador>) controller.findAdministradorEntities();
    }
    
    public boolean salvar(){
        try {
            controller.create(administrador);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean atualizar(){
        try {
            controller.edit(administrador);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void main(String args[]){
        BeanAdministrador bean = new BeanAdministrador();
        Administrador adm = bean.autenticacaoAdmGeral("diocesse", "1010");
        
        System.out.println("Ok: "+adm);
    }
}
