/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.dataFormatar.FormatarData;
import edu.ifba.hibernate.entidade.Participante;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageEditarParticipante implements LogicaOperacao{
    BeanParticipante bean = new BeanParticipante();
   
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        try {
            int acao = Integer.parseInt(req.getParameter("acao"));
            Participante p = bean.getParticipante(acao);
            req.setAttribute("participante", p);
           FormatarData formatador = new FormatarData();
           req.setAttribute("tratarData", formatador);
            req.getRequestDispatcher("participante/cadastrarP.jsp").forward(req, res);
            return true;
        } catch (Exception e) {
        	  req.getRequestDispatcher("logar.jsp").forward(req, res);
              return false;
        }
        
       //To change body of generated methods, choose Tools | Templates.
    }
    
}
