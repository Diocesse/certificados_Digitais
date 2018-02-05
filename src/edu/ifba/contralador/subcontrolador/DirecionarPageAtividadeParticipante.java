/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.bean.BeanEvento;
import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.entidade.Atividade;
import edu.ifba.hibernate.entidade.Evento;
import edu.ifba.hibernate.entidade.Participante;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageAtividadeParticipante implements LogicaOperacao{
    BeanAtividade bean = new BeanAtividade();
    BeanEvento beanE = new BeanEvento(); 
    BeanParticipante beanP = new BeanParticipante();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String acao = req.getParameter("acao");
            Participante p = beanP.getParticipante(Integer.parseInt(acao));
            List<Evento> listaE = beanE.getListaEventos();
            List<Atividade> atividades =(List<Atividade>) bean.getAtividades();
            req.setAttribute("atividades", atividades);
            req.setAttribute("eventos", listaE);
            req.setAttribute("participante", p);
            req.getRequestDispatcher("inscricao/iniciarinscricao.jsp").forward(req, res);
            return true;
        } catch (Exception e) {
            res.getOutputStream().print(e.getLocalizedMessage());
        }
        return  false;//To change body of generated methods, choose Tools | Templates.
    }
    
}
