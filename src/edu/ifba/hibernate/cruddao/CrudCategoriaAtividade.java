/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.cruddao;

import edu.ifba.hibernate.entidade.CategoriaAtividade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author diocesse
 */
public class CrudCategoriaAtividade extends DaoGenericoMetodo{

     public CrudCategoriaAtividade() {
        emf = FactoryConexao.getEmf();

    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    @Override
    public void salvar(Object obj) {
        
         EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro" + e.getLocalizedMessage());
        }
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object obj) {
         EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro" + e.getLocalizedMessage());
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Object obj) {
         EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro" + e.getLocalizedMessage());
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CategoriaAtividade> listaInfoAll() {
        try {
             EntityManager em = getEntityManager();
            Query query;

            query = em.createQuery("SELECT  a FROM CategoriaAtividade a", CategoriaAtividade.class);

            List<CategoriaAtividade> lista = (List<CategoriaAtividade>) query.getResultList();
            return lista;
        } catch (Exception e) {
            return null;
        }
 //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<?> listaInfoFiltroAll(String busca) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CategoriaAtividade getFiltroUnico(int id) {
          EntityManager em = getEntityManager();
        try {
            return em.find(CategoriaAtividade.class, id);
        } finally {
            em.close();
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    
    public static void main(String atgs[]){
        CategoriaAtividade c = new CategoriaAtividade();
        c.setDescricao("Mini Curso");
        new CrudCategoriaAtividade().salvar(c);
        System.err.println(""+new CrudCategoriaAtividade().getFiltroUnico(1));
                
    }
    
}
