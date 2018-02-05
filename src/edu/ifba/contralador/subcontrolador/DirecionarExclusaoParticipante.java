/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanParticipante;
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
public class DirecionarExclusaoParticipante implements LogicaOperacao {

    BeanParticipante bean = new BeanParticipante();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        int acao = Integer.valueOf(req.getParameter("acao"));
        Participante p = bean.getParticipante(acao);
        try {
            req.setAttribute("participante", p);
            req.getRequestDispatcher("participante/finalizarexclusao.jsp").forward(req, res);
        } catch (Exception e) {
           List lista = (List<Participante>) bean.getParticipantes();
            req.setAttribute("participantesInfo", lista);
            req.getRequestDispatcher("participante/paginaParticipante.jsp").forward(req, res);
      
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
