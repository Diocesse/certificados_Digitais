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
public class DirecionarPageCertificadoAutomatico implements LogicaOperacao{
  private BeanParticipacao bean = new BeanParticipacao();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            
            String page = "certificado/criarcertificadoautomatico.jsp";
            req.setAttribute("atividadesparticipantes", bean.getListaInfo());
            req.getRequestDispatcher(page).forward(req, res);
            return true;
        } catch (Exception e) {
            return false;
        }
        
      }
    
}
