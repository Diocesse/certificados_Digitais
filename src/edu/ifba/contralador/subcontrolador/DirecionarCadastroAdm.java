/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAdministrador;
import edu.ifba.hibernate.cruddao.CrudDaoAdministrador;
import edu.ifba.hibernate.entidade.Administrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarCadastroAdm implements LogicaOperacao {

    public BeanAdministrador bean = new BeanAdministrador();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            String nome = req.getParameter("txtNome").toUpperCase();
            String senha = req.getParameter("txtSenha");
            String senhaConf = req.getParameter("txtConfSenha");
            String login = req.getParameter("txtLogin");
            bean.getAdministrador().setNome(nome);
            bean.getAdministrador().setLogin(login);
            bean.getAdministrador().setSenha(senha);
            Administrador adm =(Administrador)req.getSession().getAttribute("adm");
            adm = null;
            if (senha.equals(senhaConf)) {
                bean.salvar();
                 req.getRequestDispatcher("logar.jsp").forward(req, res);
            } else {
                req.getRequestDispatcher("cadastrarAdm.jsp").forward(req, res);
            }
            req.getRequestDispatcher("index.jsp").forward(req, res);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
