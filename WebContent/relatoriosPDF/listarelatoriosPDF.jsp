<%-- 
    Document   : listarelatoriosPDF
    Created on : 23/05/2016, 10:46:50
    Author     : diocesse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <%@include file="../face.jsp" %>

    <body>
        <%@include file="../menu_restrito.jsp"%>
        <%@include file="../divInicio.jsp" %>
        <%
           String relatorios[] = {"Eventos", "Participantes", "Atividades", "Inscrições por atividade", "Atividade por evento", "Atividade por participante", "Certificados por participante", "Atividade por  categoria"};
           String relatoriosClasse[] = {"DirecionarPageRelatorioPDFEventos", "DirecionarPageRelatorioPDFParticipante", "Atividades", "Inscrições por atividade", "DirecionarPageRelatorioPDFAtividadeEvento", "Atividade por participante", "Certificados por participante", "Certificados por atividade"};
        %>
        <form name="formE" action="Controller" method="post">
            <fieldset class="container" id="" style="width: 90%; "><legend id="face"class="br">RELATORIOS PDF:</legend>
                <table>
                    <h1> </h1>
                    <table border="0" style="width:100% " id="" class="container">
                        <thead id="ajustarTabela">
                            <tr class="br" id="facecorpo" >
                                <th colspan="40"> <br></th>

                            </tr>
                        </thead>
                    </table>

                    <table style="width: 100%">


                        <tbody class="fundoT">
                            <%for (int i = 0; i < relatorios.length; i++) {
                            %> 
                            <tr>
                                <td><br> <a class="br" id="facecorpo" href="Controller?operacao=<%=relatoriosClasse[i]%>"><img src="images/pdfI.svg" width="50" height="50" /></a></td>
                                <td style="font-size: 18px;" class="corT" colspan="6">Exibir ralatorio PDF em <%=relatorios[i]%>   </td>
                            </tr>
                            <%}%>

                        </tbody>
                    </table>
                </table>
                </table>
            </fieldset>
        </form>
    </body>
</html>
</html>
