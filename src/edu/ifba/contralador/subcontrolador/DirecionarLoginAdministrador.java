/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAdministrador;
import edu.ifba.hibernate.bean.BeanEvento;
import edu.ifba.hibernate.entidade.Administrador;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diocesse
 */
public class DirecionarLoginAdministrador implements LogicaOperacao {

    BeanAdministrador beanAdministrador = new BeanAdministrador();
    BeanEvento bean = new BeanEvento();
    int codigo = 0;

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        //     req.getRequestDispatcher("logar.jsp").forward(req, res);

        String login = req.getParameter("usuario");
        codigo = Integer.parseInt(req.getParameter("codigo"));
        String senha = req.getParameter("senha");
        Administrador adm = beanAdministrador.autenticacaoAdm(login, senha);
        HttpSession session = criarSessao(req, adm);
        String msg;
        String page;
        try {
            if (validarSessao(adm) || session != null) {
                msg = "Você esta logado, " + adm.getNome() + "! Seja bem vindo!";
                page = "adm/restritoAdministrador.jsp";
            } else {
                msg = "Login senha invalidos!";
                page = "logar.jsp";
            }

        } catch (Exception e) {
            msg = "Login senha invalidos!";
            page = "logar.jsp";
        }

        session.setAttribute("msg", msg);
        req.getRequestDispatcher(page).forward(req, res);

        return true;

    }

    public HttpSession criarSessao(HttpServletRequest req, Administrador adm) {
        try {
            HttpSession session;
            req.getSession().invalidate();
            session = req.getSession(true);
            session.setAttribute("adm", adm);
            return session;
        } catch (Exception e) {
            return null;
        }
    }

    public boolean validarSessao(Administrador adm) {
        boolean erro = false;

        try {
            if (adm == null) {
                erro = true;

            }
            if (erro) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            return false;
            // TODO: handle exception
        }

    }
}
