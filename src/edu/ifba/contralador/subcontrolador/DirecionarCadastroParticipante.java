/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.bean.BeanTipoParticipante;
import edu.ifba.hibernate.dataFormatar.FormatarData;
import edu.ifba.hibernate.entidade.Participante;
import edu.ifba.hibernate.entidade.TipoParticipante;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarCadastroParticipante implements LogicaOperacao {

    BeanParticipante bean = new BeanParticipante();
    BeanTipoParticipante beanTp = new BeanTipoParticipante();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String page = "index.jsp";
        String nome = req.getParameter("txtNome").toUpperCase();
        String cpf = req.getParameter("txtCPF");
        String email = req.getParameter("txtEmail");
        String confirmaEmail = req.getParameter("txtConfirmaEmail");
        String sexo = req.getParameter("txtSexo");
        String dataNascimento = req.getParameter("txtDataNascimento");
        int cod = Integer.parseInt(req.getParameter("codigo"));
        String codTP = req.getParameter("idTipo");
        String mensagem = "";

        TipoParticipante tp = beanTp.findTipo(Integer.parseInt(codTP));
        Participante p = new Participante(cod, nome, sexo, cpf, email, FormatarData.ddMMyyyyBancoDados(dataNascimento), true, tp);

        System.err.println("Codigo tp: " + codTP);
        if (cod > 0) {
            System.out.println("Oi: " + p);
            Participante old = bean.getParticipante(cod);
            p.setImage_Perfil(old.getImage_Perfil());
        }
        bean.setParticipante(p);
        String erros[] = {nome, sexo, dataNascimento, cpf, email, confirmaEmail};
        try {
            if (listaErros(erros)) {
               
                if (cod == 0) {

                    if (bean.salvar()) {
                        mensagem = "cadastrado";
                    } else {
                        mensagem = "Não foi possivel cadastrar";
                    }

                } else {

                    if (bean.atualizarParticipante()) {
                        mensagem = "atualizado";
                    } else {
                        mensagem = "não foi possivel atualizar";
                    }

                }

                req.setAttribute("msg", "Participante " +p.getNome()+ " "+mensagem + " com sucesso");
                page = "adm/restritoAdministrador.jsp";
               

            } else {

                req.setAttribute("erros", erros);
                page="participante/cadastrarP.jsp";
              
            }
             req.getRequestDispatcher(page).forward(req, res);
            
        } catch (Exception e) {
            res.getOutputStream().println("não foi possivel cadastrar "+e.getLocalizedMessage());
        }

        return true; //To change body of generated methods, choose Tools | Templates.
    }

    public boolean listaErros(String lista[]) {
        try {
            boolean erro = false;

            if (lista[0].equals(" ")) {
                lista[0] = "Falha, Campo para informaçao do nome esta invalido";
                erro = true;
            } else if (lista[1].equals(" ")) {
                lista[1] = "Falha, Campo para informaçao do sexo esta invalido";
                erro = true;
            } else if (lista[2].equals(" ")) {
                lista[2] = "Falha, Campo para informaçao da data nascimento esta invalido";
                erro = true;
            } else if (lista[3].equals(" ")) {
                lista[3] = "Falha, Campo para informaçao do CPF esta invalido";
                erro = true;
            } else if (lista[4].equals(" ")) {
                lista[4] = "Falha, E-mail não é valido!";
                erro = true;

            } else if (lista[5].equals(" ")) {
                lista[5] = "Falha, E-mail não é valido!";
                erro = true;
            }

            return !erro;
        } catch (Exception e) {
        }

        return true;
    }
}
