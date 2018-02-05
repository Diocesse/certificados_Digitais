/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.bean.BeanCategoriaAtividade;
import edu.ifba.hibernate.bean.BeanEvento;
import edu.ifba.hibernate.dataFormatar.FormatarData;
import edu.ifba.hibernate.entidade.Atividade;
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
public class DirecionarCadastrarAtividade implements LogicaOperacao {

    BeanAtividade beanAtiv = new BeanAtividade();
    BeanCategoriaAtividade bca = new BeanCategoriaAtividade();
    BeanEvento beanE = new BeanEvento();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            String codigo = req.getParameter("codigo");
            String dataAtividade = req.getParameter("txtDataAtiv");
            String horaInicial = req.getParameter("txtHoraInicial");
            String horaFinal = req.getParameter("txtHoraFinal");
            String descricao = req.getParameter("txtDescricao").toUpperCase();
            String local = req.getParameter("txtLocal").toUpperCase();
            String idEvento = req.getParameter("txtEvento");
            String idCat = req.getParameter("txtCategoria");
            String qtde = req.getParameter("txtQtde");
            CategoriaAtividade categoria = bca.getCategoriaAtividade(Integer.parseInt(idCat));
            Evento evento = beanE.getEvento(Integer.parseInt(idEvento));
            int id = Integer.parseInt(codigo);
            Atividade atividade = new Atividade(id, descricao, FormatarData.ddMMyyyyBancoDados(dataAtividade), FormatarData.horaBancoDados(horaInicial), FormatarData.horaBancoDados(horaFinal), true, Integer.parseInt(qtde), evento, local, categoria);
            beanAtiv.setAtividade(atividade);
            
            String msg="";
            if (id == 0) {
                if (beanAtiv.salvar()){
                    msg = "Cadastrada com sucesso "+atividade.getDescricao();
                }else{
                    msg = "Não foi possivel cadastrar "+atividade.getDescricao();
                }
            }else{
                if (beanAtiv.update()){
                     msg = "Atualizado com sucesso "+atividade.getDescricao();
                }else{
                     msg = "Não foi possivel atualizar "+atividade.getDescricao();
                }
            }
            req.setAttribute("msg", "Atividade " + msg);
            List<Atividade> lista = (List<Atividade>) beanAtiv.getAtividades();
           // req.setAttribute("atividades", lista);
            req.getRequestDispatcher("adm/restritoAdministrador.jsp").forward(req, res);

            return true;
        } catch (Exception e) {
            return false;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

}
