/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.bean.BeanEvento;
import edu.ifba.hibernate.cruddao.CrudCategoriaAtividade;
import edu.ifba.hibernate.entidade.Atividade;
import edu.ifba.hibernate.entidade.CategoriaAtividade;
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
public class DirecionarPageEditarAtividade implements LogicaOperacao {
    BeanAtividade beanA = new BeanAtividade();
    BeanEvento bean = new BeanEvento();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
         int cod = Integer.parseInt(req.getParameter("acao"));
         Atividade atividade = beanA.getAtividade(cod);
                  
         try {
            List<CategoriaAtividade> lista = (List<CategoriaAtividade>) new CrudCategoriaAtividade().listaInfoAll();
            req.setAttribute("categorias", lista);
            List<Evento> eventos = (List<Evento>) bean.getListaEventos();
            req.setAttribute("eventos", eventos);
             req.setAttribute("atividade", atividade);
             req.getRequestDispatcher("atividade/updateAtividade.jsp").forward(req, res);
             
            return true;
        } catch (Exception e) {
            res.getOutputStream().println(e.getLocalizedMessage());
            return false;
        }
        
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
