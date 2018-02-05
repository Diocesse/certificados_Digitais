/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.contralador.relatorios.GerarPDF;
import edu.ifba.contralador.subcontrolador.LogicaOperacao;
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
public class DirecionarPageRelatorioPDFEventos implements LogicaOperacao{

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
       
         String path = req.getRealPath("/WEB-INF/eventos/eventos_1.jrxml");

        String caminho = "/WEB-INF/" + "logoIFBA.png";
        @SuppressWarnings("rawtypes")   
        Map<String, Object> parametros = new HashMap();
        parametros.put("image", req.getRealPath(caminho));
        System.err.println("Simmmmmm");
        try {
            GerarPDF gerar = new GerarPDF();
            if (gerar.gerarPDFSaida(path, parametros, res.getOutputStream())) {
                System.out.println("Sucesso exibir relatorio");
            } else {
                res.getOutputStream().println("erro");
            }

        } catch (Exception e) {
            // TODO: handle exception
            res.getOutputStream().println(e.getLocalizedMessage());
            e.printStackTrace();
        }

    return true;
    }
    
}
