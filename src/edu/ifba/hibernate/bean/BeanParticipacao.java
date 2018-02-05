/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.bean;

import edu.ifba.hibernate.cruddao.CrudDaoParticipacao;
import edu.ifba.hibernate.entidade.Atividade;
import edu.ifba.hibernate.entidade.Participacao;
import edu.ifba.hibernate.entidade.Participante;
import java.util.List;

/**
 *
 * @author diocesse
 */
public class BeanParticipacao {

    private CrudDaoParticipacao crudDaoParticipacao;
    private Participacao participacao = new Participacao();

    public BeanParticipacao() {
        crudDaoParticipacao = new CrudDaoParticipacao();
    }

    public Participacao getAtividadeParticipante() {
        return participacao;
    }

    public void setAtividadeParticipante(Participacao participacao) {
        this.participacao = participacao;
    }
    
    public boolean verificarInscricao(){
        try {
            return crudDaoParticipacao.verificarInscricaoAtividade(participacao.getParticipante(), participacao.getAtividade());
        } catch (Exception e) {
            return false;
        }
    }

    public void setParticipacao(Participacao participacao) {
        this.participacao = participacao;
    }

    public Participacao getParticipacao(int id) {
        participacao = crudDaoParticipacao.getFiltroUnico(id);
        return participacao;
    }
    
    

    public boolean salvar() {
        try {

            if (!verificarInscricao()) {
                crudDaoParticipacao.salvar(participacao);
            }
            setAtividadeParticipante(null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean atualizar() {
        try {
            crudDaoParticipacao.update(participacao);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public List<Participacao> buscarListaInscritosAtividades(String busca){
        try {
            List<Participacao> lista = crudDaoParticipacao.listaInfoFiltroAll(busca);
            return lista;
        } catch (Exception e) {
            return null;
        }
       
    }
    
    public boolean salvarColecaoPartipanteAtividade(Participante[] lista, Atividade a){
        try {
            return crudDaoParticipacao.salvarColecaoParticipantesParaAtividade(lista, a);
        } catch (Exception e) {
            return false;
        }
    }

    public List<Participacao> getListaInfo() {
        return (List<Participacao>) crudDaoParticipacao.listaInfoAll();
    }

}
