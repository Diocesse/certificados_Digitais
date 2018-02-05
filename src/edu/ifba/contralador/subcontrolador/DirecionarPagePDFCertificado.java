/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifba.contralador.subcontrolador;

import edu.ifba.contralador.relatorios.GerarPDF;
import edu.ifba.hibernate.entidade.Participacao;
import edu.ifba.hibernate.entidade.Certificado;
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
public class DirecionarPagePDFCertificado implements LogicaOperacao {

    @Override
    public boolean execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {

            String codigoCPF = req.getParameter("codigoCPF");
            String codigoFICA = req.getParameter("codigoFICA");
           
            System.out.println("CodCPF: " + codigoCPF);
            System.out.println("Codverif: " + codigoFICA);

            if (codigoCPF != null && !codigoCPF.equals("") ) {
                
                System.out.println("Implementar codigo....");

            } else if (codigoFICA != null && !codigoFICA.equals("") ){
                
                Participacao participante = new Participacao();
                participante.setAtividade(null);
                participante.setParticipante(null);
                Certificado c = new Certificado();
                
                
                String path = req.getRealPath("/WEB-INF/certificados/impressao.jrxml");

                String caminho = "/WEB-INF/" + "logoIFBA.png";
                String caminho2 = "/WEB-INF/" + "certificado.jpg";
                @SuppressWarnings("rawtypes")
                Map<String, Object> parametros = new HashMap();
                parametros.put("image", req.getRealPath(caminho));
                parametros.put("certiImg", req.getRealPath(caminho2));
                GerarPDF gerar = new GerarPDF();
                if (gerar.gerarPDFSaida(path, parametros, res.getOutputStream())) {
                    System.out.println("Sucesso exibir relatorio");
                } else {
                    res.getOutputStream().println("erro");
                }
            }
            return true;

        } catch (Exception e) {
            res.getOutputStream().println("erro :"+e.getMessage());
            return false;
        }
        
         //To change body of generated methods, choose Tools | Templates.
    }
    
    public String gerarPDFAutomatico(Participacao a){
        try {
            String texto = "Certificamos que "+a.getParticipante().getNome()+" participou do "+a.getAtividade().getEvento().getDescricao()+ "realiazada "+a.getAtividade().getEvento().getLocalEvento()
                    +"entre os dias"+a.getAtividade().getDataAtividade()+" com a carga horaria "+a.getAtividade().getCargaHoraria();
            return texto;
        } catch (Exception e) {
            return null;
        }
    }

}
