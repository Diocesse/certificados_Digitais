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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageFinalizarInscricao implements LogicaOperacao{
    BeanParticipante bean = new BeanParticipante();
    BeanAtividade beanAtv = new BeanAtividade();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String radio = req.getParameter("txtRadio");
            String idParticipante = req.getParameter("participante");
            Participante p = bean.getParticipante(Integer.parseInt(idParticipante));
            Atividade a = beanAtv.getAtividade(Integer.parseInt(radio));
            System.out.println("Tiv: "+a);
            req.setAttribute("participante", p);
            req.setAttribute("atividade", a);
            req.getRequestDispatcher("inscricao/finalizarInscricao.jsp").forward(req, res);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
