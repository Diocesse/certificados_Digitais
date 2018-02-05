<%-- 
    Document   : certificado
    Created on : 30/04/2016, 10:32:32
    Author     : diocesse
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../face.jsp"></jsp:include>
        <body>
        <jsp:include page="../menuAdm.jsp"></jsp:include> 
        <jsp:include page="../divInicio.jsp"></jsp:include>

            <h2 ><img height="40"width="40" src="images/logoIFBA.png" class="arrow-down" />Consultar certificados por CPF ou  codigo de verificação</h2>
             <fieldset style="background: green; border-radius: 0.3cm; height: 10px; border: none;">
            </fieldset>
            <form method="get" action="Controller">
                <fieldset style="border-width: 0px;">

                    <table style="width: 70%;" class="">
                        <tr>
                            <td colspan="2"><h3 style="text-align: left; color: red;"><c:out value="${msg}"/></h3></td>
                        </tr> 
                        <tr>
                           
                            <td id="ajustarTabela" style="font-size: 0.6cm;"></td>
                            <td style="text-align: left;" colspan="0"><input maxlength="50" name="codigoAutenticidade"  style="height: 2cm; font-size: 0.9cm;  text-transform: uppercase;" size="20" placeholder="Digite o codigo verificador ou CPF" type="text" id="fontsize" class="select1" /> </td>

                        </tr>
                        <br>

                        
                        <tr>
                            <td><input name="operacao" value="DirecionarPageCertificado" type="hidden"></td>
                            <td style="text-align: left;"><input class="" id=""  style=" border-radius: 0.3cm; border-width: 0px; background: green; color: white; height: 2cm; font-size: 0.9cm; text-transform: uppercase; font-family: '';"  type="submit" name="gravar" value="Gerar Certificado" />|
                                <input  style=" border-radius: 0.3cm; background: red; color: white; border-width: 0px; height: 2cm; font-size: 0.9cm; text-transform: uppercase; font-family: '';"  name="limpar" type="reset" value="Limpar dados" /></td>

                        </tr>


                    </table>

                </fieldset>
                
            </form>
            <fieldset style="border-width: 0px;">
                <fieldset style="border: none;">
                    <h1 class="button1" id="p"> OBJETIVO:</h1>
                    <p class="" id="p">
                        Geração automática de certificados de eventos (minicursos, cursos, bancas de TCC, visitas técnicas, participação em atividades, etc) com código de verificação de autenticidade, de forma que para alguém verificar a autenticidade de um certificado, basta entrar no site e inserir o código de autenticação que será gerado automaticamente o certificado em formato PDF, para ser utilizado em todas as coordenações e departamentos do IFBA.
                    </p>
                </fieldset>
                <fieldset style="border: none;">
                    <h1 class="button1" id="p">  Justificativas:</h1>
                    <p id="p">


                        Hoje, a confecção de certificados de eventos no IFBA campus Santo Amaro é feita manualmente, um por um, e o registro de autenticidade é anotado em livro e arquivado na Coordenação de Extensão do campus. 
                        Esta confecção é trabalhosa, ocupa muito tempo do servidor que está realizando esta tarefa, demorando a ser entregue ao interessado.
                        Como o registro de autenticidade é realizado em livro, a verificação de autenticidade é difícil de ser realizada a distância.
                        Com a elaboração deste sistema online, qualquer pessoa poderá fazer download de seu próprio certificado e os interessados poderão verificar a autenticidade do mesmo pela internet.
                        Este sistema irá economizar ao IFBA impressões de certificados, e poupar tempo do servidor que confecciona os mesmos, uma vez que será entregue ao participante do evento somente o código de autenticação para que a própria pessoa possa fazer o download de seu próprio certificado em PDF.  
                    </p>

                </fieldset>

            </fieldset>

        <jsp:include page="../divFim.jsp"></jsp:include>
    </body>
</html>
