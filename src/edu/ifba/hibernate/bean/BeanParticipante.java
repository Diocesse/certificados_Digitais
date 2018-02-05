/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.bean;

import edu.ifba.hibernate.cruddao.CrudDaoParticipante;
import edu.ifba.hibernate.entidade.Participante;
import java.util.List;

/**
 *
 * @author diocesse
 */
public class BeanParticipante {

    private Participante participante = new Participante();
    private CrudDaoParticipante controller = new CrudDaoParticipante();

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public boolean atualizarParticipante() {
        try {
            System.err.println("PNew: "+participante);
            controller.edit(participante);
            setParticipante(null);
             return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean salvar() {
        try {
            controller.create(participante);
            setParticipante(null);
            return true;
        } catch (Exception e) {
            System.out.println("Dados já existe.");
            return false;
        }
    }

    public List<Participante> getParticipantes() {
        return controller.participantesInfo();
    }

    public List<Participante> getParticipantes(String nome) {
        return controller.participantesInfo(nome);
    }

    public Participante getParticipante(int id) {
        participante = controller.findParticipante(id);
        return participante;
    }
    
    public Participante getParticipanteCPF(String cpf) {
        participante = controller.findParticipanteCPF(cpf);
        return participante;
    }

    public boolean remove() {
        try {
            controller.destroy(participante.getIdParticipante());
            setParticipante(null);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
