/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanTipoParticipante;
import edu.ifba.hibernate.entidade.TipoParticipante;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarCadastroParticipacao implements LogicaOperacao{
    BeanTipoParticipante bean = new BeanTipoParticipante();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String tipo = req.getParameter("tipo");
            TipoParticipante tp = new TipoParticipante(0, tipo);
            bean.setTp(tp);
            String msg="";
           if( bean.salvar() ){
               msg="O tipo participação foi cadastro com sucesso";
           }else{
               msg="O tipo participação não foi cadastro com sucesso";
           }
             req.setAttribute("msg",msg);
              req.getRequestDispatcher("adm/restritoAdministrador.jsp").forward(req, res);

            return true;
        } catch (Exception e) {
            return false;
        }
  
    }
    
}
