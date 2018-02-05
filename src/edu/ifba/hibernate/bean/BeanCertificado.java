/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.bean;

import edu.ifba.hibernate.cruddao.CrudDaoCertificados;
import edu.ifba.hibernate.entidade.Certificado;
import edu.ifba.hibernate.entidade.Participacao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diocesse
 */
public class BeanCertificado {
    private Certificado certificado = new Certificado();
    private CrudDaoCertificados daoCertificados;
    private List<Certificado> certificados = new ArrayList<Certificado>();

    public List<Certificado> getCertificados(String cpf) {
        certificados = daoCertificados.listaCertificadosParticipante(cpf);
        return certificados;
    }

    public int capturarUltimoIdParticipacao(){
        return daoCertificados.capturarUltimoId();
    }
    public void setCertificados(List<Certificado> certificados) {
        this.certificados = certificados;
    }

    public BeanCertificado() {
        daoCertificados = new CrudDaoCertificados();
    }

    public void setCertificado(Certificado certificado) {
        this.certificado = certificado;
    }
    public String gerarCodigoAutenticidade(Participacao p){
        return daoCertificados.gerarCodigoAutenticacaoAutomatico(p);
    }

    public Certificado getCertificado() {
        return certificado;
    }
    
    public Certificado getCertificado(String codigoAutenticidade){
        return daoCertificados.getCertificado(codigoAutenticidade);
    }
    
    public boolean criarCertificado(){
        try {
            daoCertificados.salvar(certificado);
            certificado=null;
            return true;
        } catch (Exception e) {
            return true;
        }
    }
     
    
}
