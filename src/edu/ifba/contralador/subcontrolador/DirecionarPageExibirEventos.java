/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanEvento;
import edu.ifba.hibernate.dataFormatar.FormatarData;
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
public class DirecionarPageExibirEventos implements LogicaOperacao{
    BeanEvento beanEvento = new BeanEvento();
    FormatarData format = new FormatarData();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            List<Evento> eventos = beanEvento.getListaEventos();
            req.setAttribute("eventos", eventos);
            String page = "evento/exibireventos.jsp";
            
            req.getRequestDispatcher(page).forward(req, res);
        } catch (Exception e) {
        }
       return true; //To change body of generated methods, choose Tools | Templates.
    }
    
}
