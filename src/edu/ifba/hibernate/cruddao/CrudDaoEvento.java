/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.cruddao;

import edu.ifba.hibernate.entidade.Evento;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author diocesse
 */
public class CrudDaoEvento implements Serializable {

    public CrudDaoEvento() {
        emf = FactoryConexao.getEmf();
    }

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public boolean salvarEvento(Evento evento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(evento);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erro" + e.getLocalizedMessage());
            return false;
        }
    }

    public boolean atualizar(Evento evento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(evento);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erro" + e.getLocalizedMessage());
            em.close();
            return false;
        }
    }

    public boolean delete(Evento evento) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Evento e = em.find(Evento.class, evento.getIdEvento());
            em.remove(e);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.getLocalizedMessage());
            return false;
        }
    }

    public List<Evento> listaInfoEventosBusca(String descricao) {

        try {

            EntityManager em = getEntityManager();
            TypedQuery<Evento> query;
            query = em.createQuery("select e from Evento e WHERE e.descricao LIKE '" + descricao + "%' ", Evento.class);
            List<Evento> lista = (List<Evento>) query.getResultList();
            return lista;

        } catch (Exception e) {
            return null;
        }
    }

    public List<Evento> listaInfoEventos() {

        try {

            EntityManager em = getEntityManager();
            Query query;

            query = em.createQuery("From Evento e where e.idEvento < 7 and e.statusEvento is not null", Evento.class);
            System.err.println(query);
            List<Evento> lista = (List<Evento>) query.getResultList();
            return lista;

        } catch (Exception e) {
            return null;
        }
    }

    public Evento findEvento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Evento.class, id);
        } finally {
            em.close();
        }
    }

    public List<Evento> listaUpload() {
        try {
            EntityManager em = getEntityManager();
            Query query;
            query =(Query) em.createQuery("From Evento e WHERE e.logoMarca NOT NULL", Evento.class);
            System.err.println(query);
            List<Evento> lista = (List<Evento>) query.getResultList();

            return lista;
        } catch (Exception e) {
            return null;
        }
    }

    public void updateLogo(Evento evento) {
        try {
            EntityManager em = getEntityManager();

        } catch (Exception e) {

        }
    }

    public static void main(String tags[]) {
        System.out.println(new CrudDaoEvento().listaInfoEventos());

    }

}
