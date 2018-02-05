/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.cruddao;

import edu.ifba.hibernate.dataFormatar.FormatarData;
import edu.ifba.hibernate.entidade.Atividade;
import edu.ifba.hibernate.entidade.CategoriaAtividade;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author diocesse
 */
public class CrudDaoATividade extends DaoGenericoMetodo implements Serializable {

    public CrudDaoATividade() {
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
        } //To change body of generated methods, choose Tools | Templates.
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
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atividade> listaInfoAll() {
        try {

            EntityManager em = getEntityManager();
            Query query;

            query = em.createQuery("SELECT  a FROM Atividade a WHERE a.idAtividade <= 15 GROUP BY a.categoriaAtividade.descricao,a.descricao", Atividade.class);

            List<Atividade> lista = (List<Atividade>) query.getResultList();
            return lista;

        } catch (Exception e) {
            System.err.println("Erro" + e.getLocalizedMessage());   
            return null;
        } //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Atividade> listaInfoFiltroAll(String busca) {
        try {

            EntityManager em = getEntityManager();
            Query query;

            query = em.createQuery("SELECT  a FROM Atividade a where a.descricao LIKE '"+busca+"%'OR a.categoriaAtividade.descricao LIKE '"+busca+"%' OR a.evento.descricao LIKE '"+busca+"%'  ", Atividade.class);

            List<Atividade> lista = (List<Atividade>) query.getResultList();
            return lista;

        } catch (Exception e) {
            System.err.println("Erro" + e.getLocalizedMessage());
            return null;
        }
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getFiltroUnico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Atividade.class, id);
        } catch(Exception e) {
            return null;
        }

    }

    public static void main(String args[]) {

        Atividade a = new Atividade();
        CategoriaAtividade ca =(CategoriaAtividade) new CrudCategoriaAtividade().getFiltroUnico(1);
        a.setCategoriaAtividade(ca);
        System.err.println(""+ new CrudCategoriaAtividade().listaInfoAll());
        a.setDataAtividade(FormatarData.ddMMyyyyBancoDados("12/02/2103"));
        a.setDescricao("Hibernnate JPA");
        a.setHoraAtividadeInicio(FormatarData.horaBancoDados("16:00:09"));
        a.setQuantidade(20);
        a.setStatus(true);
        a.setHoraAtividadeFinal(FormatarData.horaBancoDados("20:00:00"));
       
        new CrudDaoATividade().salvar(a);
        System.err.println(new CrudDaoATividade().getFiltroUnico(1));
    }

}
