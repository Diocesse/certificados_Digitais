/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author diocesse
 */
@Entity
@Table(name = "carrinho")
public class Carrinho implements Serializable {

    @Id
    @OneToOne
    Participante participante;
    
    @OneToOne
    Atividade atividade;

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Atividade getAtividade() {
        return atividade;
    }

    public Carrinho(Participante participante, Atividade atividade) {
        this.participante = participante;
        this.atividade = atividade;
    }

    public Carrinho() {
    }

    @Override
    public String toString() {
        return "Carrinho{" + "participante=" + participante + ", atividade=" + atividade + '}';
    }
    

}
