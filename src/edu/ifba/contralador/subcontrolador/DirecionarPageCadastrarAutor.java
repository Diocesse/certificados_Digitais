/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAutor;
import edu.ifba.hibernate.entidade.Autor;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageCadastrarAutor implements LogicaOperacao {

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String page="adm/restritoAdministrador.jsp";
        String msg;
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String contato = req.getParameter("contato");
        String codigo = req.getParameter("codigo");
        BeanAutor bean = new BeanAutor();
        try {
            Autor autor = new Autor(nome, email);
            bean.setAutor(autor);
            
            if (Integer.parseInt(codigo)==0){
                msg = "Autor cadastrado com sucesso";
                bean.cadastrarAutor();
            }else{
                 msg = "Autor atualizado com sucesso";
                 
            }
                    

            req.setAttribute("msg", msg);
            req.getRequestDispatcher(page).forward(req, res);
        } catch (Exception e) {
        }

        return true; //To change body of generated methods, choose Tools | Templates.
    }

}
