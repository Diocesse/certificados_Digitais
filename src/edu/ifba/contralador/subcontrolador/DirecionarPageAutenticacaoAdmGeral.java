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
public class DirecionarPageAutenticacaoAdmGeral implements  LogicaOperacao{
private BeanAdministrador bean = new BeanAdministrador();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String page;
        String login = req.getParameter("usuario");
         String senha = req.getParameter("senha");
         Administrador admGeral =(Administrador) bean.autenticacaoAdmGeral(login, senha);
           System.out.println("Ok: "+admGeral+ " login: "+login+ " senha: "+senha);
         String msg="ok";
        try {
            List<Administrador> lista = (List<Administrador>)bean.listaAdministradores();
            
            if (admGeral != null ){
                msg ="Este setor so pode acessada pelo Admistrador Geral.";
                page = "adm/pesquisarAdm.jsp";
                
                
            }else{
                msg = "Falha em autenticação.";
                page = "adm/administrador_autenticacao.jsp";
            }
           req.setAttribute("adms",lista);       
            req.setAttribute("msg",msg); 
            req.getRequestDispatcher(page).forward(req, res);
            return true;
        } catch (Exception e) {
            return false;
        }
        //To change body of generated methods, choose Tools | Templates.
    }
    
}
