/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.bean.BeanCategoriaAtividade;
import edu.ifba.hibernate.entidade.Atividade;
import edu.ifba.hibernate.entidade.CategoriaAtividade;
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
public class DirecionarCadastroCategoria implements Serializable, LogicaOperacao {

    BeanAtividade beanAtividade = new BeanAtividade();
    BeanCategoriaAtividade bean = new BeanCategoriaAtividade();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {

            String descricao = req.getParameter("txtDescricao").toUpperCase();
            String id = req.getParameter("codigo");

            String erros[] = {descricao};
            String msg;
            String page;
            System.out.println("Eros" + erros[0]);
            if (listaErros(erros)) {
                CategoriaAtividade c = new CategoriaAtividade();
                c.setDescricao(descricao);
                c.setIdCatAtividade(Integer.parseInt(id));
                bean.setCategoria(c);
                if (Integer.parseInt(id) == 0) {
                    if (bean.salvar());
                    msg = "Cadastrado";

                } else {
                    msg = "Atualizado";

                }

                req.setAttribute("msg", "Categoria " + c.getDescricao() + " " + msg + " com sucesso");;
              //  List<Atividade> lista = (List<Atividade>) beanAtividade.getAtividades();
             //   req.setAttribute("atividades", lista);
                page = "adm/restritoAdministrador.jsp";
              
            } else {
                
                req.setAttribute("erros", erros);
                page="categoria/cadastrarCategoria.jsp";
               
            }
            req.getRequestDispatcher(page).forward(req, res);
            return true;
        } catch (NumberFormatException | ServletException | IOException e) {
           res.getOutputStream().print(e.getLocalizedMessage());
            return false;
        }
        
        //To change body of generated methods, choose Tools | Templates.
    }

    public boolean listaErros(String lista[]) {
        try {
            boolean erro = false;
            if (lista[0].equals("")) {
                lista[0] = "Falha, Informaçao em branco para categoria";
                erro = true;
            }
            return !erro;
        } catch (Exception e) {
        }

        return true;
    }

}
