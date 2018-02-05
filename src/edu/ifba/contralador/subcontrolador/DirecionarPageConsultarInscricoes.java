/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanParticipacao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageConsultarInscricoes implements LogicaOperacao {

    BeanParticipacao bean = new BeanParticipacao();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {

            req.setAttribute("participantesAtividades", bean.getListaInfo());
            req.getRequestDispatcher("inscricao/consultarInscricao_1.jsp").forward(req, res);
        } catch (Exception e) {
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
