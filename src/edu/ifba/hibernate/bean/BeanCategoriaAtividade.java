/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.bean;

import edu.ifba.hibernate.cruddao.CrudCategoriaAtividade;
import edu.ifba.hibernate.entidade.CategoriaAtividade;
import java.util.List;

/**
 *
 * @author diocesse
 */
public class BeanCategoriaAtividade {

    CrudCategoriaAtividade categoriaAtividade = new CrudCategoriaAtividade();
    private CategoriaAtividade categoria = new CategoriaAtividade();

    public boolean salvar(){
        try {
            categoriaAtividade.salvar(categoria);
            setCategoria(null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void setCategoria(CategoriaAtividade categoria) {
        this.categoria = categoria;
    }

    public CategoriaAtividade getCategoria() {
        return categoria;
    }
    
    public CategoriaAtividade getCategoriaAtividade(int id) {
        categoria = categoriaAtividade.getFiltroUnico(id);
        return categoria;
    }
    
    public List<CategoriaAtividade> getFiltroCategorias(){
        return categoriaAtividade.listaInfoAll();
    }

}
