/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanEvento;
import edu.ifba.hibernate.entidade.Evento;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageExclusaoEvento implements LogicaOperacao{
    BeanEvento bean = new BeanEvento();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
     
        int acao = Integer.parseInt(req.getParameter("acao"));
        Evento e = bean.getEvento(acao);
        req.setAttribute("evento", e);
        req.getRequestDispatcher("evento/finalizarexclusao.jsp").forward(req, res);
        
        return true; //To change body of generated methods, choose Tools | Templates.
    }
    
}
