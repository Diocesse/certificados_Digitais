/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.entidade.Participante;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarFinalizarExclusao implements Serializable, LogicaOperacao {

    BeanParticipante bean = new BeanParticipante();
    Participante p;

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        
            String excluir = req.getParameter("txtExcluir");
            String btExcluir = req.getParameter("btExclusao");
           
            p = bean.getParticipante(Integer.parseInt(excluir));
            String msg="";
            try{
            if (btExcluir.equals("Finalizar")) {
                if (bean.remove()) {
                    msg="removido com sucesso";
                } else {
                    msg=" esta participando de uma atividade, exclusao foi negada";
                }
            }else{
                msg="Exclusao cancelada"; 
            }
            
            req.setAttribute("msg", "Participante " + p.getNome() + " "+msg+"");
            req.getRequestDispatcher("adm/restritoAdministrador.jsp").forward(req, res);
       return true;
            } catch (Exception e) {
           return false;
        }
    }

}
