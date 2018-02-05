/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.cruddao;

import edu.ifba.hibernate.entidade.Atividade;
import edu.ifba.hibernate.entidade.Participacao;
import edu.ifba.hibernate.entidade.Participante;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author diocesse
 */
public class CrudDaoParticipacao extends DaoGenericoMetodo {

    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public CrudDaoParticipacao() {
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
    public List<Participacao> listaInfoAll() {
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Participacao> query;
            query = em.createQuery("from Participacao a WHERE a.idAtpa <= 14 ORDER BY a.participante.nome ", Participacao.class);
            List<Participacao> lista = (List<Participacao>) query.getResultList();
            return lista;
        } catch (Exception e) {
            return null;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String args[]) {
        CrudDaoParticipacao participacao = new  CrudDaoParticipacao();
        Participante p = new Participante(1);
        Atividade a = new Atividade(1);
        
        System.out.println("Verdade: "+participacao.verificarInscricaoAtividade(p, a));
    }

    @Override
    public List<Participacao> listaInfoFiltroAll(String busca) {
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Participacao> query;
            String sql = "FROM Participacao ap WHERE ap.atividade.descricao LIKE :busca";
            query = em.createQuery(sql,Participacao.class);
            query.setParameter("busca", busca);
            List<Participacao> lista =(List<Participacao>) query.getResultList();
            return lista;
        } catch (Exception e) {
            System.err.println("Falha sql");
            return null;
        }
//To change body of generated methods, choose Tools | Templates.
    }

    public boolean verificarInscricaoAtividade(Participante p, Atividade a) {
        try {
            boolean erro = false;
            EntityManager em = getEntityManager();
            TypedQuery<Participacao> query;
            String execute = "FROM Participacao a WHERE a.atividade.idAtividade = :idAtiv AND  a.participante.idParticipante = :idPar";
            query = em.createQuery(execute, Participacao.class);
            query.setParameter("idAtiv", a.getIdAtividade());
            query.setParameter("idPar", p.getIdParticipante());
            List<Participacao> existeParticipantes = (List<Participacao>) query.getResultList();
           boolean verificar=false;
            for (Participacao ap : existeParticipantes) {
                verificar = true;
                break;
            }

            
            return verificar;
            

        } catch (Exception e) {
            System.out.println("Codigo Exception: " + e.getLocalizedMessage());
            return false;
        }
    }

    @Override
    public Participacao getFiltroUnico(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Participacao.class, id);
        } finally {
            em.close();
        }
    }
    
    public boolean salvarColecaoParticipantesParaAtividade(Participante[] indices, Atividade a) {
        try {
            //salvando uma colecão de participantes
            Participacao ap;
            for (Participante p : indices) {
                ap = new Participacao();
                ap.setParticipante(p);
                ap.setAtividade(a);
               if(!verificarInscricaoAtividade(p, a)){salvar(ap);}
            }

            return true;
        } catch (Exception e) {
            System.err.println("Erro em tentar salvar a lista...");
            return false;
        }
    }
    
    

}
