/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.cruddao;

import edu.ifba.hibernate.entidade.Evento;
import edu.ifba.hibernate.entidade.Participacao;
import edu.ifba.hibernate.entidade.TipoParticipante;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author diocesse
 */
public class CrudDaoTipoParticipante implements Serializable{

    public CrudDaoTipoParticipante() {
         emf = FactoryConexao.getEmf();
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public List<TipoParticipante> listaCategoriasParticipantes () {
        try {
            EntityManager em = getEntityManager();
            TypedQuery<TipoParticipante> query;
            query = em.createQuery("from TipoParticipante p ", TipoParticipante.class);
            List<TipoParticipante> lista = (List<TipoParticipante>) query.getResultList();
            return lista;
        } catch (Exception e) {
        }
        return null;
    }
    public boolean criar(TipoParticipante p){
         try {
            EntityManager em = null;
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public TipoParticipante getTipoParticipante(int id){
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoParticipante.class, id);
        } finally {
            em.close();
        }
    }
    
    
    
}
