/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table(name = "participacao")
public class Participacao implements Serializable {
    @Id
    @Column(name = "idAtpa")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idAtpa;
    @OneToOne
    private Participante participante;
    @OneToOne
    private Atividade atividade;

    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dataParticipacao")
    private Date dataParticipacao;
   
    @Temporal(javax.persistence.TemporalType.TIME)
    @Column(name = "horaEntrada")
    private Date horaEntrada;
    @Column(name = "criado")
    private boolean criada;

    public boolean isCriada() {
        return criada;
    }

    public void setCriada(boolean criada) {
        this.criada = criada;
    }
 
    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }
    
    
    public void setDataParticipacao(Date dataParticipacao) {
        this.dataParticipacao = dataParticipacao;
    }

    public Date getDataParticipacao() {
        return dataParticipacao;
    }
    
    public int getIdAtpa() {
        return idAtpa;
    }

    public void setIdAtpa(int idAtpa) {
        this.idAtpa = idAtpa;
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

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Participacao() {
    }

    public Participacao(int idAtpa, Participante participante, Atividade atividade) {
        this.idAtpa = idAtpa;
        this.participante = participante;
        this.atividade = atividade;
    }

    public Participacao(int idAtpa, Participante participante, Atividade atividade, Date dataParticipacao) {
        this.idAtpa = idAtpa;
        this.participante = participante;
        this.atividade = atividade;
        this.dataParticipacao = dataParticipacao;
    }

    @Override
    public String toString() {
        return "Participacao{" + "idAtpa=" + idAtpa + ", participante=" + participante + ", atividade=" + atividade + ", dataParticipacao=" + dataParticipacao + '}';
    }
    
    
    
}
