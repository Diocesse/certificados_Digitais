/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.entidade.Participante;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageUploadParticipanteImage implements LogicaOperacao{
    BeanParticipante bean = new BeanParticipante();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            Participante p = bean.getParticipante(Integer.parseInt(req.getParameter("acao")));
            
            req.setAttribute("participante", p);
            req.getRequestDispatcher("upload/participante_img.jsp").forward(req, res);
            return true;
        } catch (Exception e) {
             throw new UnsupportedOperationException("Not supported yet."); 
        }
       //To change body of generated methods, choose Tools | Templates.
    }
    
}
