package edu.ifba.contralador.relatorios;

import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;

import conexao.Mysql;
import edu.ifba.hibernate.cruddao.FactoryConexao;
import edu.ifba.hibernate.entidade.Teste;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import net.sf.jasperreports.data.DataSourceCollection;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class GerarPDF {

    Mysql entrada = Mysql.getInstance();
    Connection con ;

    public GerarPDF() {
        // TODO Auto-generated constructor stub
           con = entrada.getConexao();
       // con = entrada.getConexao();
       // emf = FactoryConexao.getEmf();
    }
    
    public boolean salvar(Teste t){
        String sql="insert into teste(cpf) values ('"+t.getNome()+"')";
        
        return entrada.salvar(sql);
    }
   
    
    //private EntityManagerFactory emf = null;

    public boolean gerarPDFSaida(String jasper, Map<String, Object> parametros, OutputStream saida) {
        // TODO Auto-generated constructor stub

        try {
            // preenche relatorio
          //  JRDataSource source = new DataSourceCollection(new ArrayList<>());
            
            JasperReport run = JasperCompileManager.compileReport(jasper);
            JasperPrint print = JasperFillManager.fillReport(run, parametros, con);
            JRExporter exporter;
            exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);
            exporter.exportReport();
            con.close();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e.getMessage());
            return false;
        }
    }

}
