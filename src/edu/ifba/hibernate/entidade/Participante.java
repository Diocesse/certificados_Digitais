/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
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
@Table(name = "participante")
public class Participante implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idParticipante")
    private Integer idParticipante;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "sexo")
    private String sexo;
    @Basic(optional = false)
    @Column(name = "cpf", unique = true)
    private String cpf;
    @Basic(optional = false)
    @Column(name = "email", unique = true)
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    @Column(name = "dataNascimeto")
    private Date dataNascimento;
    @Basic(optional = false)
    @Column(name = "statusP")
    private boolean statusP;
    
    @Column(name = "imagePerfil")
    private byte [] image_Perfil;

    public byte[] getImage_Perfil() {
        return image_Perfil;
    }

    public void setImage_Perfil(byte[] image_Perfil) {
        this.image_Perfil = image_Perfil;
    }
    
    @OneToOne 
    private TipoParticipante tipoParticipante;

    public TipoParticipante getTipoParticipante() {
        return tipoParticipante;
    }

    public void setTipoParticipante(TipoParticipante tipoParticipante) {
        this.tipoParticipante = tipoParticipante;
    }

    public Participante(Integer idParticipante, String nome, String sexo, String cpf, String email, Date dataNascimento, boolean statusP, TipoParticipante tipoParticipante) {
        this.idParticipante = idParticipante;
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.statusP = statusP;
       
        this.tipoParticipante = tipoParticipante;
    }
    
    
    public Participante(Integer idParticipante, String nome, String sexo, String cpf, Date dataNascimento,String email) {
        this.idParticipante = idParticipante;
        this.nome = nome;
        this.sexo = sexo;
        this.cpf = cpf;
        this.email = email;

        this.dataNascimento = dataNascimento;

    }
    

    public Participante() {
    }

    public Participante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Integer getIdParticipante() {
        return idParticipante;
    }

    public void setIdParticipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getStatusP() {
        return statusP;
    }

    public void setStatusP(boolean statusP) {
        this.statusP = statusP;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idParticipante != null ? idParticipante.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Participante)) {
            return false;
        }
        Participante other = (Participante) object;
        if ((this.idParticipante == null && other.idParticipante != null) || (this.idParticipante != null && !this.idParticipante.equals(other.idParticipante))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Participante{" + "idParticipante=" + idParticipante + ", nome=" + nome + ", sexo=" + sexo + ", cpf=" + cpf + ", email=" + email + ", dataNascimento=" + dataNascimento + ", statusP=" + statusP + ", image_Perfil=" + image_Perfil + ", tipoParticipante=" + tipoParticipante + '}';
    }

    

}
