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
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author diocesse
 */
@Entity
@Table(name = "evento")
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEvento")
    private int idEvento;
    @Column(name = "descricao",unique = true)
    private String descricao;
    @Column(name = "logoMarca")
    private byte []logoMarca;
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "localEvento")
    private String localEvento;    
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dataEvento")
    private Date dataEvento;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dataFim")
    private Date dataFim;
    
    @Temporal(javax.persistence.TemporalType.TIME)
    @Column(name = "horaEvento")
    private Date horaEvento;
    @Column(name = "statusEvento")
    private boolean statusEvento;
    @Column(name = "cidade")
    private String cidade;
    @Column(name = "estado")
    private String estado;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "endereco")
    private String endereco;

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public Date getDataFim() {
        return dataFim;
    }
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setLogoMarca(byte[] logoMarca) {
        this.logoMarca = logoMarca;
    }

    public byte[] getLogoMarca() {
        return logoMarca;
    }
  
    
    
    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public boolean isStatusEvento() {
        return statusEvento;
    }

    public void setStatusEvento(boolean statusEvento) {
        this.statusEvento = statusEvento;
    }
    
    public Date getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Date getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(Date horaEvento) {
        this.horaEvento = horaEvento;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
    
    @Override
    public String toString() {
        return "Evento{" + "idEvento=" + idEvento + ", descricao=" + descricao + ", logoMarca=" + logoMarca + ", sigla=" + sigla + ", localEvento=" + localEvento + ", dataEvento=" + dataEvento + ", horaEvento=" + horaEvento + ", statusEvento=" + statusEvento + '}';
    }
    
    

}
