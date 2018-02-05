/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.cruddao;

import edu.ifba.hibernate.entidade.Autor;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author diocesse
 */
public class CrudDaoAutor extends DaoGenericoMetodo {

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CrudDaoAutor() {
        emf = FactoryConexao.getEmf();
    }

    @Override
    public void salvar(Object obj) {
        //To change body of generated methods, choose Tools | Templates.
        try {
            EntityManager em = null;
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    @Override
    public void update(Object obj) {
        //To change body of generated methods, choose Tools | Templates.
        try {
            EntityManager em = null;
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    @Override
    public void remove(Object obj) {
        //To change body of generated methods, choose Tools | Templates.
        try {
            EntityManager em = null;
            em = getEntityManager();
            em.getTransaction().begin();
            Autor autor = (Autor)obj;
            autor = em.find(Autor.class,autor.getIdAutor());
            em.remove(autor);
            em.getTransaction().commit();
        } catch (Exception e) {
        }
    }

    @Override
    public List<?> listaInfoAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> listaInfoFiltroAll(String busca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getFiltroUnico(int id) {
        try {
             EntityManager em = null;
            em = getEntityManager();
            return em.find(Object.class, id);
        } catch (Exception e) {
            return null;
        }
      }

}
