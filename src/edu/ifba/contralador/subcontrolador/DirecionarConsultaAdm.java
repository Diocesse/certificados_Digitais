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
public class DirecionarConsultaAdm implements LogicaOperacao {

    BeanAdministrador bean = new BeanAdministrador();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        Administrador adm = (Administrador) req.getSession().getAttribute("adm");
        String login = req.getParameter("usuario");
        String senha = req.getParameter("senha");
        String erros[] = {login, senha};
        Administrador admC = bean.autenticacaoAdm(login, senha);
        System.out.println("Logib:   " + admC.getLogin());
        try {
            if (adm != null) {
                if (listaErros(erros)) {
                    if (admC.getLogin().equals(adm.getLogin()) && admC.getSenha().equals(adm.getSenha())) {
                        req.getRequestDispatcher("adm/cadastrarNewAdm_1.jsp").forward(req, res);
                    }
                } else {
                    req.setAttribute("erros", senha);
                }
            }
        } catch (ServletException | IOException e) {
            req.setAttribute("msg", "Login e senha diferentes!");
            req.getRequestDispatcher("adm/verificarLog.jsp").forward(req, res);
        }

        return true;//To change body of generated methods, choose Tools | Templates.
    }

    public boolean listaErros(String lista[]) {
        try {
            boolean erro = false;
            if (lista[0].equals("")) {
                lista[0] = "Falha " + lista[0] + " em branco";
                erro=true;
            } else if (lista[1].equals("")) {
                lista[1] = "Falha " + lista[1] + " em branco";
                erro=true;
            }
            return !erro;
        } catch (Exception e) {
        }

        return true;
    }

}
