/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.entidade;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author diocesse
 */
@Entity
@Table(name = "categoriaAtividade")
public class CategoriaAtividade implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCatAtividade")
    private int idCatAtividade;
    @Column(name="descricao",unique = true)
    private String descricao;

    public int getIdCatAtividade() {
        return idCatAtividade;
    }

    public void setIdCatAtividade(int idCatAtividade) {
        this.idCatAtividade = idCatAtividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public CategoriaAtividade() {
    }

    public CategoriaAtividade(int idCatAtividade, String descricao) {
        this.idCatAtividade = idCatAtividade;
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "CategoriaAtividade{" + "idCatAtividade=" + idCatAtividade + ", descricao=" + descricao + '}';
    }
    
    
    
    
}
