/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.bean.BeanParticipacao;
import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.entidade.Atividade;
import edu.ifba.hibernate.entidade.Participante;
import java.io.IOException;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarCadastroParticipanteListaAtividade implements LogicaOperacao{
    BeanParticipacao bean = new BeanParticipacao();
    BeanAtividade beanA = new BeanAtividade();
    BeanParticipante beanP = new BeanParticipante();
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       
        
        try {
            
            String palavras[] = req.getParameterValues("colecao");
            Atividade a  = beanA.getAtividade(Integer.parseInt(req.getParameter("codigo")));
            Participante[] lista = new Participante[palavras.length];
            
            for (int i = 0; i < palavras.length; i++) {
                lista[i]= beanP.getParticipante(Integer.parseInt(palavras[i]));
                
            }
            System.out.println(""+Arrays.toString(lista));
           if(bean.salvarColecaoPartipanteAtividade(lista, a)){
               System.err.println("Lista de Participantes salva com sucesso");
           }
           
            return true;
        } catch (Exception e) {
            res.getOutputStream().print(e.getLocalizedMessage());
            return false;
        }
        
         //To change body of generated methods, choose Tools | Templates.
    }
    
}
