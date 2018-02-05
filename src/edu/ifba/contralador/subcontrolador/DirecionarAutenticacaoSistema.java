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

/**
 *
 * @author diocesse
 */
public class DirecionarAutenticacaoSistema implements LogicaOperacao{

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            //req.getRequestDispatcher("logar.jsp").forward(req, res);
           res.sendRedirect("logar.jsp");
            return true;
        } catch (Exception e) {
            return false;
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
