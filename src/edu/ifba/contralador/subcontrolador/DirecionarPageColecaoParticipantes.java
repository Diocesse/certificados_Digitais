/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.entidade.Atividade;
import edu.ifba.hibernate.entidade.Participante;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageColecaoParticipantes implements LogicaOperacao {
     BeanParticipante beanParticipante = new BeanParticipante();
     BeanAtividade bean = new BeanAtividade();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            int acao = Integer.parseInt(req.getParameter("acao"));
            Atividade a = bean.getAtividade(acao);
            req.setAttribute("atividade", a);
            //obs sera uma lista de participantes sem atividade.
            List<Participante> lista =(List<Participante>) beanParticipante.getParticipantes();
            req.setAttribute("participantes", lista);
            req.getRequestDispatcher("atividade/atividadeColecaoParticipantes.jsp").forward(req, res);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
