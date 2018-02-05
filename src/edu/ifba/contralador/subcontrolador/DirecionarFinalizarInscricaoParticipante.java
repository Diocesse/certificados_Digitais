/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.hibernate.bean.BeanAtividade;
import edu.ifba.hibernate.bean.BeanCertificado;
import edu.ifba.hibernate.bean.BeanParticipacao;
import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.dataFormatar.FormatarData;
import edu.ifba.hibernate.entidade.Atividade;
import edu.ifba.hibernate.entidade.Certificado;
import edu.ifba.hibernate.entidade.Participacao;
import edu.ifba.hibernate.entidade.Participante;
import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarFinalizarInscricaoParticipante implements LogicaOperacao {

    BeanParticipacao beanParticipacao = new BeanParticipacao();
    BeanAtividade beanA = new BeanAtividade();
    BeanParticipante beanP = new BeanParticipante();
    BeanCertificado beanCertificado = new BeanCertificado();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String btFinalizar = req.getParameter("btFinalizar");
        String idA = req.getParameter("atividade");
        Participante p = beanP.getParticipante(Integer.parseInt(req.getParameter("participante")));

        Atividade a = beanA.getAtividade(Integer.parseInt(idA));
        Date dataParticipacao = new Date(System.currentTimeMillis());
        Participacao ap = new Participacao(0, p, a, dataParticipacao);
        beanParticipacao.setAtividadeParticipante(ap);
        int cod = 0;
        String msg = "";
        String pagina = "adm/restritoAdministrador.jsp";
        try {
            if (btFinalizar.equals("Finalizar")) {

                if (cod == 0) {

                    if (!beanParticipacao.verificarInscricao() && beanParticipacao.salvar()) {
                        //Gerar certificado para texte
                        System.out.println("Processando construção de certificado aguarde...");
                        String codigoAutenticacao = beanCertificado.gerarCodigoAutenticidade(ap);
                        Certificado c = new Certificado();
                        c.setCodigoAutenticacao(codigoAutenticacao);
                        c.setDataCriacao(new Date());
                        Participacao ps = beanParticipacao.getParticipacao(beanCertificado.capturarUltimoIdParticipacao());
                        c.setParticipacao(ps);
                        c.setTexto(criarTexto(ps));
                        c.setGerado(true);
                        //carrega a informações do certificado 
                        beanCertificado.setCertificado(c);
                        //Grava as informações no banco
                        beanCertificado.criarCertificado();
                        msg = "Meus Parabéns seu pedido de participação foi aceito com sucesso, " + p.getNome() + " na atividade " + a.getDescricao() + " seu certificado foi gerado também, mais você so recebera se estiver presente na atividade. ";

                        System.out.println("Certificado gerado finalizado");
                        //------------------------------------------------------
                    } else {
                        msg = "O participante já esta cadastrado em atividade " + a.getDescricao();

                    }
                } else if (cod > 0) {

                    if (beanParticipacao.atualizar()) {
                        msg = "Inscrição atualizada com sucesso";
                    } else {
                        msg = "Não foi possivel realizar a atualização da inscrição com sucesso";
                    }
                }

                pagina = "adm/restritoAdministrador.jsp";
                
            } else if (btFinalizar.equals("Encerra")) {
                msg = "Tentativa de inscrição cancelada";
                pagina = "adm/restritoAdministrador.jsp";

            }
        } catch (Exception e) {
            msg = "Participante cadastrado sem atividade. ";

        }
        req.setAttribute("msg", msg);
        req.getRequestDispatcher(pagina).forward(req, res);
        return false;

        //To change body of generated methods, choose Tools | Templates.
    }

    public static String criarTexto(Participacao ps) {
        try {
           // + ps.getParticipante().getTipoParticipante().getTipo() +
            String texto;
            if (ps.getAtividade() != null) {
                texto = "Certificamos que " + ps.getParticipante().getNome()
                        + " participou do(a) " + ps.getAtividade().getEvento().getDescricao() + "  participando do(a) "  + ps.getAtividade().getCategoriaAtividade().getDescricao() + " com(o) " +ps.getParticipante().getTipoParticipante().getTipo()+" da atividade "   + ps.getAtividade().getDescricao()
                        + " realizado no " + ps.getAtividade().getEvento().getLocalEvento() + " de " + ps.getAtividade().getEvento().getCidade() + FormatarData.pegarDiaInicioDataEvento(FormatarData.ddMMyyyyVisao(ps.getAtividade().getEvento().getDataEvento()), FormatarData.ddMMyyyyVisao(ps.getAtividade().getEvento().getDataFim())) + ".";

            } else {
                texto = null;
            }

            return texto;
        } catch (Exception e) {
            return null;
        }
    }

}
