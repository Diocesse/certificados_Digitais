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
public class DirecionarPageEditarEvento implements LogicaOperacao{
    BeanEvento beanEvento = new BeanEvento();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String acao = req.getParameter("acao");
            int id = Integer.parseInt(acao);
            Evento evento = beanEvento.getEvento(id);
            req.setAttribute("evento", evento);
            req.getRequestDispatcher("evento/cadastrarEventoNew.jsp").forward(req, res);
        } catch (Exception e) {
        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
