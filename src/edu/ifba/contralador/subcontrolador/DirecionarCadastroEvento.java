/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanEvento;
import edu.ifba.hibernate.dataFormatar.FormatarData;
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
public class DirecionarCadastroEvento implements LogicaOperacao {

    BeanEvento bean = new BeanEvento();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {

            String codigo = req.getParameter("codigo");
            String descricao = req.getParameter("txtDescricao");
            String sigla = req.getParameter("txtSigla");
            String localEvento = req.getParameter("txtLocalEvento");
            String cidade = req.getParameter("txtCidade");
            String estado = req.getParameter("txtEstado");
            String bairro = req.getParameter("txtBairro");
            String dataEvento = req.getParameter("txtDataEvento");
             String dataFim = req.getParameter("txtDataFim");
            String horaEvento = req.getParameter("txtHoraEvento");
            String endereco = req.getParameter("txtEndereco");
            System.out.println("Data: "+dataFim);
            
            Evento e = new Evento();
            e.setIdEvento(Integer.parseInt(codigo));
            e.setBairro(bairro);
            e.setCidade(cidade);
            e.setDataEvento(FormatarData.ddMMyyyyBancoDados(dataEvento));
            e.setSigla(sigla);
            e.setEndereco(endereco);
            e.setLocalEvento(localEvento);
            e.setDescricao(descricao);
            e.setHoraEvento(FormatarData.horaBancoDados(horaEvento));
            e.setEstado(estado);
            e.setDataFim(FormatarData.ddMMyyyyBancoDados(dataFim));
            e.setLogoMarca(null);
             // Não altera a image do logo na da atualização do evento
            if (Integer.parseInt(codigo) > 0){
                Evento imageL = bean.getEvento(Integer.parseInt(codigo));
                e.setLogoMarca(imageL.getLogoMarca());  
            }
            bean.setEvento(e);
            String msg;
            System.out.println("COD: "+codigo);
            if (Integer.parseInt(codigo) == 0) {
                if (bean.salvar()){
                msg = "cadastrado";
                }else{
                    msg = "evento já está cadastrado";
                }

            } else {
                
                if (bean.atualizar());
                msg = "atualizado";
            }
            req.setAttribute("msg", "Evento " + e.getDescricao() + " " + msg + " com sucesso");
           
            req.getRequestDispatcher("adm/restritoAdministrador.jsp").forward(req, res);
            return true;
        } catch (NumberFormatException | ServletException | IOException e) {
            res.getOutputStream().print(e.getMessage());
            return false;
        }

        //To change body of generated methods, choose Tools | Templates.
    }

}
