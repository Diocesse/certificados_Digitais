/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAdministrador;
import edu.ifba.hibernate.entidade.Administrador;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageListaAdm implements LogicaOperacao{
    BeanAdministrador beanAdministrador = new BeanAdministrador();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //To change body of generated methods, choose Tools | Templates.
        try {
            List<Administrador> lista =(List<Administrador>) beanAdministrador.listaAdministradores();
            req.setAttribute("adms", lista);
            
            req.getRequestDispatcher("adm/administrador_autenticacao.jsp").forward(req, res);
        } catch (Exception e) {
        	 req.getRequestDispatcher("adm/administrador_autenticacao.jsp").forward(req, res);
             
        } 
    
        return true;
    }
    
}
