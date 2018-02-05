/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanEvento;
import edu.ifba.hibernate.entidade.Evento;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarListaEventos implements LogicaOperacao{
    BeanEvento bean = new BeanEvento();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            
            List<Evento> eventos = (List<Evento>)bean.getListaEventos();
            req.setAttribute("eventos", eventos);
            req.getRequestDispatcher("evento/pesquisarevento.jsp").forward(req, res);
            
            return true;
            
        } catch (Exception e) {
            return false;
        }
        
       //To change body of generated methods, choose Tools | Templates.
    }
    
}
