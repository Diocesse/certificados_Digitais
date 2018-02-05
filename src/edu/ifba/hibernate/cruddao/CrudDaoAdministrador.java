/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.cruddao;

import edu.ifba.hibernate.entidade.Administrador;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.eclipse.persistence.annotations.Properties;

/**
 *
 * @author diocesse
 */
public class CrudDaoAdministrador implements Serializable {

    public CrudDaoAdministrador() {
        this.emf = FactoryConexao.getEmf();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Administrador administrador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(administrador);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Administrador administrador) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            administrador = em.merge(administrador);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = administrador.getIdAdm();
                if (findAdministrador(id) == null) {
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Administrador administrador = null;
            try {
                administrador = em.getReference(Administrador.class, id);
                administrador.getIdAdm();
            } catch (Exception e) {
            }
            em.remove(administrador);
            em.getTransaction().commit();
        } catch(Exception e) {
            if (em != null) {
                em.close();
            }
        }
    }

    public Administrador getAutenticacaoAdm(String login, String senha) {
        try {
            EntityManager em = getEntityManager();
            Query query;
            query = em.createQuery("FROM Administrador  a WHERE a.login  LIKE :login AND a.senha LIKE :senha ", Administrador.class);
            query.setParameter("login", login);
             query.setParameter("senha", senha);
            List<Administrador> lista = (List<Administrador>) query.getResultList();
            Administrador administrador = lista.get(0);
            return administrador;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getLocalizedMessage());
            return null;
        }
    }
    
    public Administrador autenticacaoAdmGeral(String login, String senha) {
        try {
            EntityManager em = getEntityManager();
            Query query;
            query = em.createQuery("FROM Administrador  a WHERE a.login  LIKE :login AND a.senha LIKE :senha AND a.idAdm = 1", Administrador.class);
            query.setParameter("login", login);
             query.setParameter("senha", senha);
            List<Administrador> lista = (List<Administrador>) query.getResultList();
            Administrador administrador = lista.get(0);
            return administrador;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getLocalizedMessage());
            return null;
        }
    }

    public List<Administrador> findAdministradorEntities() {
        return findAdministradorEntities(true, -1, -1);
    }

    public List<Administrador> findAdministradorEntities(int maxResults, int firstResult) {
        return findAdministradorEntities(false, maxResults, firstResult);
    }

    private List<Administrador> findAdministradorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Administrador.class));
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

    public Administrador findAdministrador(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Administrador.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdministradorCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Administrador> rt = cq.from(Administrador.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public static void main(String args[]) {
        Administrador adm = new Administrador();
        adm.setNome("LEANDRO DE SOUZA");
        adm.setLogin("diocesse");
        adm.setSenha("1010010");
        System.err.println(new CrudDaoAdministrador().findAdministradorEntities());

    }

}
