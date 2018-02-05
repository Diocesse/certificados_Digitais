/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.cruddao.CrudDaoParticipante;
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
public class DirecionarFiltroParticipantes implements LogicaOperacao{

    CrudDaoParticipante controller = new CrudDaoParticipante();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            
            String pesquisa = req.getParameter("txtPesquisar");
             List<Participante> lista;
            lista = (List<Participante>) controller.participantesInfo(pesquisa);
            req.setAttribute("participantesInfo", lista);
        
        req.getRequestDispatcher("participante/paginaParticipante.jsp").forward(req, res);
        } catch (Exception e) {
        }
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
