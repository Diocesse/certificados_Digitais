/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ifba.contralador.relatorios.GerarPDF;
import java.io.File;
public class DirecionarPageRelatorioPDFParticipante implements LogicaOperacao {
    @SuppressWarnings({"rawtypes", "deprecation"})
    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String path = req.getRealPath("/WEB-INF/participante/" + "participantes.jrxml");
       @SuppressWarnings("rawtypes")
        Map<String, Object> parametros = new HashMap();
        String caminho = "/WEB-INF/"+"logoIFBA.png" ;
        parametros.put("image", req.getRealPath(caminho)+File.separator);
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

        return true;//To change body of generated methods, choose Tools | Templates.
    }

}
