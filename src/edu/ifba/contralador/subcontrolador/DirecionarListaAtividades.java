/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.entidade.Atividade;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarListaAtividades implements LogicaOperacao{
    BeanAtividade beanAtividade = new BeanAtividade();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            //Controller?operacao=DirecionarCadastroAtividade
            List<Atividade> lista = (List<Atividade>)beanAtividade.getAtividades();
           
            req.setAttribute("atividades", lista);
            
            req.getRequestDispatcher("atividade/pesquisarAtividade.jsp").forward(req, res);
        } catch (Exception e) {
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
