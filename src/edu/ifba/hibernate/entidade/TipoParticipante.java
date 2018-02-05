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

@Entity
@Table(name = "TipoParticipante")
public class TipoParticipante implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTP;
    @Column(name = "tipo")
    private String tipo;

    public int getIdTP() {
        return idTP;
    }

    public void setIdTP(int idTP) {
        this.idTP = idTP;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TipoParticipante() {
    }

    public TipoParticipante(int idTP, String tipo) {
        this.idTP = idTP;
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoParticipante{" + "idTP=" + idTP + ", tipo=" + tipo + '}';
    }
    
    
    
}
