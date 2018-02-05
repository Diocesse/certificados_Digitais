/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.bean;

import edu.ifba.hibernate.cruddao.CrudDaoCarrinho;
import edu.ifba.hibernate.entidade.Carrinho;
import java.util.List;

/**
 *
 * @author diocesse
 */
public class BeanCarrinho {

    private CrudDaoCarrinho carrinho = new CrudDaoCarrinho();
    private Carrinho carro= new Carrinho();

    public Carrinho getCarrinho() {
        return carro;
    }

    public void setCarro(Carrinho carro) {
        this.carro = carro;
    }
    public boolean salvar(){
        try {
            carrinho.salvar(carro);
            setCarro(null);
            return true;
        } catch (Exception e) {
            return true;
        }
        
    }
    public boolean update(){
        try {
            carrinho.update(carro);
            setCarro(carro);
            return true;
        } catch (Exception e) {
            return true;
        }
        
    }
    
    public int getCarrinhoMaxId(){
        return carrinho.getMaximaId();
    }
    
    public Carrinho getCarrinho(int idAtividade){
        try {
            
            return carrinho.getFiltroUnico(idAtividade);
        } catch (Exception e) {
            return null;
        }
    }
    
    public void truncarCarrinho(){
        carrinho.truncarTableCarrinho();
    }
    
    public List<Carrinho> getCarrinhos() {
        return carrinho.listaInfoAll();
    }
    
   public List<Carrinho> getFiltroAtividades(String busca) {
        return carrinho.listaInfoFiltroAll(busca);
    }
     
    

}
