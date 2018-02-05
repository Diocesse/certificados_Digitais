/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.entidade.Atividade;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageExclusaoAtividade implements LogicaOperacao{
    BeanAtividade bean = new BeanAtividade();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       
        int acao = Integer.parseInt(req.getParameter("acao"));
        Atividade a =(Atividade) bean.getAtividade(acao);
        try {
            req.setAttribute("atividade", a);
            req.getRequestDispatcher("atividade/finalizarexclusao.jsp").forward(req, res);
            return true;
        } catch (Exception e) {
            return false;
        }
       
    }
    
}
