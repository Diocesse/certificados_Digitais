/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.hibernate.cruddao;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.bean.BeanParticipacao;
import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.entidade.Atividade;
import edu.ifba.hibernate.entidade.Certificado;
import edu.ifba.hibernate.entidade.Participacao;
import edu.ifba.hibernate.entidade.Participante;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author diocesse
 */
public class CrudDaoCertificados extends DaoGenericoMetodo {

    public CrudDaoCertificados() {
        emf = FactoryConexao.getEmf();
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private static int inscremente = 0;

    public String gerarCodigoAutenticacaoAutomatico(Participacao a) {
        try {

            String arrayEvento[] = a.getAtividade().getEvento().getDescricao().split(" +");
            String arrayAtividade[] = a.getAtividade().getDescricao().split(" +");
            return arrayEvento[0].toUpperCase() + a.getAtividade().getEvento().getSigla().toUpperCase() + "-" + "IFBA-STA-" + "00" + a.getParticipante().getIdParticipante() + "-" + arrayAtividade[0].toUpperCase().substring(0, 2) + arrayAtividade[2].toUpperCase().substring(0, 3) + "-" + "12-13-2013";
        } catch (Exception e) {
            System.out.println("Erro " + e.getLocalizedMessage());
            return null;
        }
    }

    public static int autoIndice() {
        try {
            inscremente++;
            return inscremente;
        } catch (Exception e) {
            return 0;
        }
    }

    public boolean gerarCertificadoAutomatico(Participacao atp) {
        try {
            String codigo = gerarCodigoAutenticacaoAutomatico(atp);
            Certificado c = new Certificado();
            Participante p = atp.getParticipante();
            Atividade a = atp.getAtividade();
            String texto;
            if (p.getTipoParticipante().getTipo().equals("Ouvinte")) {
                texto = "";
            } else {
                texto = "";
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void salvar(Object obj) {
        try {
            EntityManager em;
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Exsessao ocorrendo!" + e.getLocalizedMessage());
        }
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
        }
    }

    @Override
    public void remove(Object obj) {
        EntityManager em = null;
        try {
            Certificado c = (Certificado) obj;
            em = getEntityManager();
            em.getTransaction().begin();
            c = em.find(Certificado.class, c.getIdCertificado());
            em.remove(c);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Erro: " + e.getLocalizedMessage());

        }
    }

    public List<Certificado> listaCertificadosParticipante(String cpf) {
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Certificado> query;
            query = em.createQuery("From Certificado p where p.participacao.participante.cpf like :busca", Certificado.class);
            query.setParameter("busca", cpf);

            List<Certificado> lista = (List<Certificado>) query.getResultList();

            return lista;

        } catch (Exception e) {
            return null;
        }
    }
    public Certificado getCertificado(String codigoAutenticidade) {
        try {
            EntityManager em = getEntityManager();
            TypedQuery<Certificado> query;
            query = em.createQuery("From Certificado p where p.codigoAutenticacao like :codigoAutenticacao", Certificado.class);
            query.setParameter("codigoAutenticacao", codigoAutenticidade);
            Certificado certificado =null;
            List<Certificado> lista = (List<Certificado>) query.getResultList();
            for (Iterator<Certificado> iterator = lista.iterator(); iterator.hasNext();) {
                Certificado c = iterator.next();
                certificado = c;
                
            }
            return certificado;

        } catch (Exception e) {
            return null;
        }
    }

    public int capturarUltimoId() {
        EntityManager em = getEntityManager();
        try {

            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Participacao> rt = cq.from(Participacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();

        } catch (Exception e) {
            return 0;
        }
    }

    public static void main(String args[]) {
        CrudDaoCertificados cdc = new CrudDaoCertificados();
        /* Participante p = new BeanParticipante().getParticipante(1);
         Atividade a = new  BeanAtividade().getAtividade(2);
         Participacao pp = new BeanParticipacao().getParticipacao(2);
     
         pp.setParticipante(p);
         pp.setAtividade(a);*/
        System.out.println(cdc.getCertificado("IIISNTC-IFBA-STA-003-PREJB-12-13-2013"));

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
