/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.bean.BeanCarrinho;
import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.entidade.Atividade;
import edu.ifba.hibernate.entidade.Carrinho;
import edu.ifba.hibernate.entidade.Participante;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageCarrinho implements LogicaOperacao {

    BeanParticipante bean = new BeanParticipante();
    BeanCarrinho carrinho = new BeanCarrinho();
    BeanAtividade beanAtividade = new BeanAtividade();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {

            Participante p = bean.getParticipanteCPF(req.getParameter("pesquisar"));
            Atividade atividade = beanAtividade.getAtividade(Integer.valueOf(req.getParameter("codAtiv")));
            Carrinho carro = new Carrinho();
            carro.setAtividade(atividade);
            carro.setParticipante(p);
            carrinho.setCarro(carro);
            carrinho.salvar();
            int atividadeCod = carrinho.getCarrinhoMaxId();
            if (atividade.getIdAtividade() == atividadeCod) {
                req.setAttribute("carrinho", carrinho.getCarrinhos());
                req.setAttribute("atividade", atividade);
                System.out.println("Processo execuntando... aguarde");
            }else{
                req.setAttribute("mensagem", "Nao existe esta atividade.");
            }

            req.getRequestDispatcher("atividade/atividadeColecaoParticipantes.jsp").forward(req, res);
            return true;
        } catch (Exception e) {
            req.setAttribute("mensagem", "Nao existe esta atividade.");
             req.getRequestDispatcher("atividade/atividadeColecaoParticipantes.jsp").forward(req, res);
            
             return false; //To change body of generated methods, choose Tools | Templates.

        }
    }

}
