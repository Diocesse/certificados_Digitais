/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.contralador.relatorios.GerarPDF;
import edu.ifba.hibernate.bean.BeanCertificado;
import edu.ifba.hibernate.bean.BeanParticipante;
import edu.ifba.hibernate.dataFormatar.FormatarData;
import edu.ifba.hibernate.entidade.Certificado;
import edu.ifba.hibernate.entidade.Teste;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageCertificado implements LogicaOperacao {

    BeanCertificado beanCertificado = new BeanCertificado();
    BeanParticipante beanParticipante = new BeanParticipante();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        try {
            String page = "index.jsp";
            String codigoAutenticidade = req.getParameter("codigoAutenticidade").trim();
            Certificado certificado = beanCertificado.getCertificado(codigoAutenticidade);
            System.out.println("Graca: " + codigoAutenticidade);
            System.out.println("Cert: " + certificado);

            //gerarPDF.salvar(new Teste(codigoAutenticidade));
            if (certificado != null) {
                //Gerar certifcado por codigo de autenticidade
                GerarPDF gerarPDF = new GerarPDF();
                Map<String, Object> parametros = new HashMap();
                String path = req.getRealPath("/WEB-INF/" + "teste.jrxml");
                String caminho = "/WEB-INF/" + "ifba.gif";//obtem image logo IFBA
                String caminho2 = "/WEB-INF/" + "sntc.png";//obtem image logo Evento
                String caminho3 = "/WEB-INF/" + "certificado.jpg";//obtem image certificado para o fundo
                parametros.put("imageLogo", req.getRealPath(caminho));
                parametros.put("imageEvento", req.getRealPath(caminho2));
                parametros.put("imageFundo", req.getRealPath(caminho3));
                parametros.put("codigoAutenticacao", certificado.getCodigoAutenticacao());
                parametros.put("dataCriacao", FormatarData.dataCertificadoCriacao(certificado));
                parametros.put("evento", certificado.getParticipacao().getAtividade().getEvento().getDescricao());

                if (gerarPDF.gerarPDFSaida(path, parametros, res.getOutputStream())) {

                    System.out.println("Certificado gerado.");
                } else {
                    res.getOutputStream().println("PDF nao foi gerado");
                }
            } else {
                //Exibir todos os certificados impressos pelo participante
                //  String codigoCPF = req.getParameter("codigoCPF").trim();
                List<Certificado> certificados = beanCertificado.getCertificados(codigoAutenticidade);
                req.setAttribute("participante", beanParticipante.getParticipanteCPF(codigoAutenticidade));
                page = "/certificado/certificados_participante.jsp";
                req.setAttribute("certificados", certificados);
                req.getRequestDispatcher(page).forward(req, res);
            }
            req.setAttribute("msg", "Informe o numero do CPF para geraçao do certificado.");
            req.getRequestDispatcher("index.jsp").forward(req, res);
            return true;
        } catch (Exception e) {
            req.setAttribute("msg", "Informe o numero do CPF para geraçao do certificado. ");
            req.getRequestDispatcher("index.jsp").forward(req, res);
            return false;
        }
        //To change body of generated methods, choose Tools | Templates.
    }

}
