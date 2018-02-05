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

/**
 *
 * @author diocesse
 */
@Entity
@Table(name = "certificado")
public class Certificado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCertificado")
    private int idCertificado;
    
    @Column(name = "codigoAutenticacao",unique = true, nullable = true)
    private String codigoAutenticacao;
    @Column(name = "texto",nullable = true ,length = 1000)
    private String texto;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "data_criacao")
    private Date dataCriacao;
    @OneToOne
     private Participacao participacao;
    @Column(name = "gerado") 
    private boolean gerado;

    public boolean isGerado() {
        return gerado;
    }

    public void setGerado(boolean gerado) {
        this.gerado = gerado;
    }
    
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }


    public Participacao getParticipacao() {
        return participacao;
    }

    public void setParticipacao(Participacao participacao) {
        this.participacao = participacao;
    }
     
    public int getIdCertificado() {
        return idCertificado;
    }

    public void setIdCertificado(int idCertificado) {
        this.idCertificado = idCertificado;
    }

    public String getCodigoAutenticacao() {
        return codigoAutenticacao;
    }

    public void setCodigoAutenticacao(String codigoAutenticacao) {
        this.codigoAutenticacao = codigoAutenticacao;
    }

    @Override
    public String toString() {
        return "Certificado{" + "idCertificado=" + idCertificado + ", codigoAutenticacao=" + codigoAutenticacao + ", texto=" + texto + ", dataCriacao=" + dataCriacao + ", participacao=" + participacao + '}';
    }

    
   
    

}
