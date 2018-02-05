/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.bean.BeanCategoriaAtividade;
import edu.ifba.hibernate.bean.BeanEvento;
import edu.ifba.hibernate.cruddao.CrudCategoriaAtividade;
import edu.ifba.hibernate.entidade.CategoriaAtividade;
import edu.ifba.hibernate.entidade.Evento;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarCadastroAtividade implements LogicaOperacao {

    BeanEvento bean = new BeanEvento();
    BeanAtividade beanA = new BeanAtividade();
    BeanCategoriaAtividade beanC = new BeanCategoriaAtividade();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            List<CategoriaAtividade> lista = (List<CategoriaAtividade>) new CrudCategoriaAtividade().listaInfoAll();
            req.setAttribute("categorias", lista);
            List<Evento> eventos = (List<Evento>) bean.getListaEventos();
            req.setAttribute("eventos", eventos);

            req.getRequestDispatcher("atividade/cadastrarAtividade.jsp").forward(req, res);

        } catch (Exception e) {
            res.getOutputStream().print("Erro: " + e.getLocalizedMessage());

        }
        return true; //To change body of generated methods, choose Tools | Templates.
    }

}
