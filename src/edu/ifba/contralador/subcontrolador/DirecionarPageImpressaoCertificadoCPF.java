/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.contralador.relatorios.GerarPDF;
import edu.ifba.hibernate.bean.BeanCertificado;
import edu.ifba.hibernate.entidade.Certificado;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author diocesse
 */
public class DirecionarPageImpressaoCertificadoCPF implements LogicaOperacao {

    BeanCertificado bean = new BeanCertificado();

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            
            String codigoAutenticidade = req.getParameter("acao");
            Certificado certificado = bean.getCertificado(codigoAutenticidade);
            GerarPDF gerarPDF = new GerarPDF();
            Map<String, Object> parametros = new HashMap();
           
                String path = req.getRealPath("/WEB-INF/" + "teste.jrxml");
                String caminho = "/WEB-INF/" + "ifba.gif";//obtem image logo IFBA
                String caminho2 = "/WEB-INF/" + "sntc.png";//obtem image logo Evento
                String caminho3 = "/WEB-INF/" + "certificado.jpg";//obtem image certificado para o fundo
                parametros.put("imageLogo", req.getRealPath(caminho) );
                parametros.put("imageEvento", req.getRealPath(caminho2));
                parametros.put("imageFundo", req.getRealPath(caminho3));
                parametros.put("codigoAutenticacao", certificado.getCodigoAutenticacao());
                parametros.put("dataCriacao", "Santo Amaro/BA 21 de Outubro 2016");
                parametros.put("evento", certificado.getParticipacao().getAtividade().getEvento().getDescricao());

            if (gerarPDF.gerarPDFSaida(path, parametros, res.getOutputStream())) {

                System.out.println("Certificado gerado.");
            } else {
                res.getOutputStream().println("PDF nao foi gerado...");
            }
        } catch (Exception e) {
        }

        return true; //To change body of generated methods, choose Tools | Templates.
    }

}
