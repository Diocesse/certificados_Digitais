/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAdministrador;
import edu.ifba.hibernate.entidade.Administrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageEditarAdm implements LogicaOperacao{
    BeanAdministrador bean = new BeanAdministrador();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
        Administrador adm =(Administrador)req.getSession().getAttribute("adm");
        
       // Administrador admConsulta = bean.autenticacaoAdm(senha, senha);   	
        
       
            req.getRequestDispatcher("adm/verificarLog.jsp").forward(req, res);
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
