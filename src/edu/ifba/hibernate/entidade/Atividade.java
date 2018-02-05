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
import javax.persistence.TemporalType;

/**
 *
 * @author diocesse
 */
@Entity
@Table(name = "atividade")
public class Atividade implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idAtividade")
    private int idAtividade;
    @Column(name = "descricao",unique = true)
    private String descricao;
    @Temporal(TemporalType.DATE)
    @Column(name = "dataAtividade")
    private Date dataAtividade;
    @Temporal(javax.persistence.TemporalType.TIME)
    @Column(name = "horaAtividadeInicio")
    private Date horaAtividadeInicio;
    @Temporal(javax.persistence.TemporalType.TIME)
    @Column(name = "horaAtividadeFinal")
    private Date horaAtividadeFinal;
    @Column(name = "statusAtividade")
    private boolean status;
    @Column(name = "quantidade")
    private int quantidade; 
    @OneToOne
    private Evento evento;
    @Column(name = "localAtiv")
    private String local;
    @Column(name = "cargaHoraria")
    private float CargaHoraria;

    public void setCargaHoraria(float CargaHoraria) {
        this.CargaHoraria = CargaHoraria;
    }

    public float getCargaHoraria() {
        return CargaHoraria;
    }

    
    public Atividade(int idAtividade, String descricao, Date dataAtividade, Date horaAtividadeInicio, Date horaAtividadeFinal, boolean status, int quantidade, Evento evento, String local, CategoriaAtividade categoriaAtividade) {
        this.idAtividade = idAtividade;
        this.descricao = descricao;
        this.dataAtividade = dataAtividade;
        this.horaAtividadeInicio = horaAtividadeInicio;
        this.horaAtividadeFinal = horaAtividadeFinal;
        this.status = status;
        this.quantidade = quantidade;
        this.evento = evento;
        this.local = local;
        this.categoriaAtividade = categoriaAtividade;
    }

    public Atividade() {
    }
    
    public Atividade(int id) {
        this.idAtividade = id;
    }
    
    

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocal() {
        return local;
    }
    
    @Override
    public String toString() {
        return "Atividade{" + "idAtividade=" + idAtividade + ", descricao=" + descricao + ", dataAtividade=" + dataAtividade + ", horaAtividadeInicio=" + horaAtividadeInicio + ", horaAtividadeFinal=" + horaAtividadeFinal + ", status=" + status + ", quantidade=" + quantidade + ", categoriaAtividade=" + categoriaAtividade + '}';
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Evento getEvento() {
        return evento;
    }
    

    public CategoriaAtividade getCategoriaAtividade() {
        return categoriaAtividade;
    }

    public void setCategoriaAtividade(CategoriaAtividade categoriaAtividade) {
        this.categoriaAtividade = categoriaAtividade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    @OneToOne
   
    private CategoriaAtividade categoriaAtividade;
   
    public int getIdAtividade() {
        return idAtividade;
    }

    public void setIdAtividade(int idAtividade) {
        this.idAtividade = idAtividade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataAtividade() {
        return dataAtividade;
    }

    public void setDataAtividade(Date dataAtividade) {
        this.dataAtividade = dataAtividade;
    }

    public Date getHoraAtividadeInicio() {
        return horaAtividadeInicio;
    }

    public void setHoraAtividadeInicio(Date horaAtividadeInicio) {
        this.horaAtividadeInicio = horaAtividadeInicio;
    }

    public Date getHoraAtividadeFinal() {
        return horaAtividadeFinal;
    }

    public void setHoraAtividadeFinal(Date horaAtividadeFinal) {
        this.horaAtividadeFinal = horaAtividadeFinal;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }



}
