/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanParticipante;
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
public class DirecionarPageUploadParticipante implements LogicaOperacao{
   public BeanParticipante bean = new BeanParticipante();
   
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
             List<Participante> lista =(List<Participante>) bean.getParticipantes();
            req.setAttribute("lista_image", lista);
            req.getRequestDispatcher("upload/lista_image_participante.jsp").forward(req, res);
            
            return true;
        } catch (Exception e) {
            return false;
        }
//To change body of generated methods, choose Tools | Templates.
    }
    
}
