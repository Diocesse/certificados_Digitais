/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.cruddao;
import edu.ifba.hibernate.entidade.Carrinho;
import edu.ifba.hibernate.entidade.Participante;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author diocesse
 */
public class CrudDaoCarrinho extends DaoGenericoMetodo {

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CrudDaoCarrinho() {
        emf = FactoryConexao.getEmf();
    }

    @Override
    public void salvar(Object obj) {
        try {
            EntityManager em = null;
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object obj) {
        try {
            EntityManager em = null;
            em = getEntityManager();
            em.getTransaction().begin();
            em.merge(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove(Object obj) {
        try {
            EntityManager em = null;
            em = getEntityManager();
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carrinho> listaInfoAll() {
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Carrinho> query;
            query = em.createQuery("From Carrinho c", Carrinho.class);
            List<Carrinho> lista = (List<Carrinho>) query.getResultList();
            return lista;
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public List<Carrinho> listaInfoFiltroAll(String busca) {
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Carrinho> query;
            String sql = "FROM Carrinho a WHERE a.participante.cpf LIKE :busca";
            query = em.createQuery(sql,Carrinho.class);
            query.setParameter("busca", busca);
            List<Carrinho> lista =(List<Carrinho>) query.getResultList();
            return lista;
        } catch (Exception e) {
            System.err.println("Falha sql");
            return null;
        }
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carrinho getFiltroUnico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Carrinho.class, id);
        } finally {
            em.close();
        }
    }

    public void truncarTableCarrinho(){
         try {
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
             Query q = em.createNativeQuery("truncate table carrinho");
             q.executeUpdate();
             em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Falha sql "+e.getLocalizedMessage());
          
        }
    }
    
     public int getCarrinhoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Carrinho> rt = cq.from(Carrinho.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
      public int getMaximaId() {
        EntityManager em = getEntityManager();
        try {
           //1 String query = " SELECT MAX ( livro . preco ) FROM Livro livro " ;
            Query q = em.createQuery("SELECT MAX (c.atividade.idAtividade) FROM Carrinho c");
            Object info =(Object) q.getResultList().get(0);
            return (int)info;
        } finally {
            em.close();
        }
    }
     
    public static void main(String arga[]){
        System.out.println( new CrudDaoCarrinho().getMaximaId());
    }

}
