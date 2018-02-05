/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.sessions.Session;

import edu.ifba.hibernate.entidade.Administrador;

/**
 *
 * @author diocesse
 */
public class DirecionarPageLogout implements LogicaOperacao{

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
        	Administrador adm =(Administrador)req.getSession().getAttribute("adm");
           	adm = null;
        	req.getRequestDispatcher("logout.jsp").forward(req, res);
        } catch (Exception e) {
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
