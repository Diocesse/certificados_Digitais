/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import static edu.ifba.contralador.subcontrolador.DirecionarFinalizarInscricaoParticipante.criarTexto;
import edu.ifba.hibernate.bean.BeanCarrinho;
import edu.ifba.hibernate.bean.BeanCertificado;
import edu.ifba.hibernate.bean.BeanParticipacao;
import edu.ifba.hibernate.entidade.Carrinho;
import edu.ifba.hibernate.entidade.Certificado;
import edu.ifba.hibernate.entidade.Participacao;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageFinalizarCarrinho implements LogicaOperacao {

    BeanCarrinho bean = new BeanCarrinho();
    BeanParticipacao beanP = new BeanParticipacao();
    BeanCertificado beanCertificado = new BeanCertificado();

    public void criarCertificado(Certificado c, Participacao p,int valor_Id_Participacao) {
        try {

            String codigoAutenticacao = beanCertificado.gerarCodigoAutenticidade(p);
            // Certificado c = new Certificado();
            c.setCodigoAutenticacao(codigoAutenticacao);
            c.setDataCriacao(new Date(System.currentTimeMillis()));
            Participacao ps = beanP.getParticipacao(valor_Id_Participacao);
            c.setParticipacao(ps);
            c.setTexto(criarTexto(ps));
            c.setGerado(true);
            //carrega a informações do certificado 
            beanCertificado.setCertificado(c);
            //Grava as informações no banco
            beanCertificado.criarCertificado();

        } catch (Exception e) {
        }
    }

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String page = "index.jsp";
        try {
            if (req.getParameter("bt").equals("Gerar colecao")) {
                List<Carrinho> carro = bean.getCarrinhos();
                Participacao p = null;
                for (int i = 0; i < carro.size(); i++) {
                    Carrinho c = carro.get(i);
                    p = new Participacao(0, c.getParticipante(), c.getAtividade(), new Date(System.currentTimeMillis()));
                    beanP.setParticipacao(p);
                    beanP.salvar();
                    //Certificado gerar automatico
                   // criarCertificado(new Certificado(),p,0);
                    //Truncar tabela carrinho;
                    bean.truncarCarrinho();
                }

                req.setAttribute("msg", "Processo de informações realizado com sucesso. " );
                page = "adm/restritoAdministrador.jsp";

            } else if (req.getParameter("bt").equals("Limpar lista de participantes")) {
                bean.truncarCarrinho();
                req.setAttribute("carrinho", bean.getCarrinhos());
                page = "atividade/atividadeColecaoParticipantes.jsp";

            }

            req.getRequestDispatcher(page).forward(req, res);

            return true;
        } catch (Exception e) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

        }
    }

}
