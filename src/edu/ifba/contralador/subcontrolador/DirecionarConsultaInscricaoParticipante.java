/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.entidade.Atividade;
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
public class DirecionarConsultaInscricaoParticipante implements LogicaOperacao {
     BeanParticipante beanParticipante = new BeanParticipante();
    BeanAtividade beanA = new BeanAtividade();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String busca = req.getParameter("busca");
           String buscar = req.getParameter("buscar");
            List<Participante> lista;
            boolean flog = false;
            List<Atividade> listaP;
            if (busca == null) {
                flog = true;
                lista = (List<Participante>) beanParticipante.getParticipantes();
            } else {
                lista = (List<Participante>) beanParticipante.getParticipantes(busca);
            }
            if (buscar != null) {
                listaP = (List<Atividade>) beanA.getFiltroAtividades(buscar);
            } else {
                listaP = (List<Atividade>) beanA.getAtividades();
            }
         //   System.out.println("" + listaP);
            req.setAttribute("participantes", lista);
            req.setAttribute("participantesAtividades", listaP);
            req.getRequestDispatcher("inscricao/consultarInscricao.jsp").forward(req, res);

            return true;
        } catch (Exception e) {
            res.getOutputStream().print("ERRo animal");
            return false;
        }
    }

}
