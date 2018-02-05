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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author diocesse
 */
@Entity
@Table(name = "Trabalho")
public class Trabalho implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "idTrabalho")
    private int idTrabalho;

    public void setIdTrabalho(int idTrabalho) {
        this.idTrabalho = idTrabalho;
    }

    public int getIdTrabalho() {
        return idTrabalho;
    }
   @Column(name = "imagemAssinatura")
   private byte [] imagemAssinatura;

    public void setImagemAssinatura(byte[] imagemAssinatura) {
        this.imagemAssinatura = imagemAssinatura;
    }

    public byte[] getImagemAssinatura() {
        return imagemAssinatura;
    }
   
    
    @OneToOne
    //@Column(name = "idAutor",table = "autor")
    private Autor autor;
   
    @OneToOne
   // @Column(name = "idAtividade",table = "atividade")
    private Atividade atividade;

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    
    
}
