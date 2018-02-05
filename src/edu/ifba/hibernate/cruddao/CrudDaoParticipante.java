/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.cruddao;


import edu.ifba.hibernate.entidade.Participante;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author diocesse
 */
public class CrudDaoParticipante implements Serializable {

    public CrudDaoParticipante() {
        this.emf = FactoryConexao.getEmf();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Participante participante) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(participante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Participante participante) throws  Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(participante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println("Erro: "+ex.getLocalizedMessage());
        } 
    }

    public void destroy(Integer id)  {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Participante participante = null;
            try {
                participante = em.getReference(Participante.class, id);
                participante.getIdParticipante();
            } catch (EntityNotFoundException enfe) {
            }
            em.remove(participante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Participante> findParticipanteEntities() {
        return findParticipanteEntities(true, -1, -1);
    }

    public List<Participante> findParticipanteEntities(int maxResults, int firstResult) {
        return findParticipanteEntities(false, maxResults, firstResult);
    }

    public List<Participante> participantesInfo() {
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Participante> query;
            query = em.createQuery("from Participante p where p.idParticipante > 0 ", Participante.class);
            List<Participante> lista = (List<Participante>) query.getResultList();
            return lista;
        } catch (Exception e) {
        }
        return null;
    }

    public List<Participante> participantesInfo(String nome) {
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Participante> query;
            query = em.createQuery("From Participante p WHERE p.nome LIKE :busca or p.email like :busca", Participante.class);
            query.setParameter("busca", nome);
            
            List<Participante> lista = (List<Participante>) query.getResultList();
            return lista;
        } catch (Exception e) {
        }
        return null;
    }

    private List<Participante> findParticipanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();

            cq.select(cq.from(Participante.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Participante findParticipante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Participante.class, id);
        } finally {
            em.close();
        }
    }
    
     public Participante findParticipanteCPF(String cpf) {
        EntityManager em = getEntityManager();
        try {
          
            TypedQuery<Participante> query;
            query = em.createQuery("From Participante p WHERE p.cpf LIKE :cpf", Participante.class);
            query.setParameter("cpf", cpf);
            List<Participante> lista = (List<Participante>) query.getResultList();
            Participante participanteNew=null;
            for (Iterator<Participante> iterator = lista.iterator(); iterator.hasNext();) {
                Participante participante = iterator.next();
                participanteNew = participante;
            }
            return participanteNew;
        } finally {
            em.close();
        }
    }

    public int getParticipanteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Participante> rt = cq.from(Participante.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    

    public static void main(String args[]) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("CertificadosDigitaisPU");

        System.err.println(new CrudDaoParticipante().findParticipanteCPF("123.000.566-32"));
    }
}
