/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.bean;

import edu.ifba.hibernate.cruddao.CrudDaoEvento;
import edu.ifba.hibernate.entidade.Evento;
import java.util.List;

/**
 *
 * @author diocesse
 */
public class BeanEvento {

    private Evento evento = new Evento();
    private final CrudDaoEvento crud = new CrudDaoEvento();

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public boolean salvar() {
        try {
            crud.salvarEvento(evento);
            setEvento(null);
            return true;
        } catch (Exception e) {
            System.err.println("Evento esta associado a tividade");
            return false;
        }
    }

    public boolean remover() {
        try {
            if (crud.delete(evento)) {
                setEvento(null);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public Evento getEvento(int id) {
        evento = crud.findEvento(id);
        return evento;
    }

    public List<Evento> getListaEventos() {
        return crud.listaInfoEventos();
    }

    public List<Evento> getListaEventos(String descricao) {
        return crud.listaInfoEventosBusca(descricao);
    }

    public boolean atualizar() {
        try {
            if (crud.atualizar(evento)) {
                setEvento(null);
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }
}
