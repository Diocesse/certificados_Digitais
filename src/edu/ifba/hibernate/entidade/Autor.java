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
@Table(name = "autor")

public class Autor implements Serializable{
    @Id
    @Column(name = "idAutor")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAutor;
    @Column(name = "nome",nullable = false)
    private String nome;
    @Column(name = "email",nullable = false, unique = true)
    private String email;
    @Column(name = "assinatura" )
    private byte [] assinatura;

    public void setIdAutor(int idAutor) {
        this.idAutor = idAutor;
    }

    public int getIdAutor() {
        return idAutor;
    }
  
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(byte[] assinatura) {
        this.assinatura = assinatura;
    }

    public Autor(String nome, String email) {
        
        this.nome = nome;
        this.email = email;
     
    }

    public Autor() {
    }
     
}
