<%-- 
    Document   : certificados_participante
    Created on : 19/10/2016, 11:01:06
    Author     : diocesse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../face.jsp" %>
    <body>
        <%@include file="../menuAdm.jsp" %>
        <%@include file="../divInicio.jsp" %>
        <fieldset style="border-radius: 0.5cm; border-width: 1px; width: 90%;" class="container">

            <fieldset class="" style="border-width: 1px; border-radius: 0.4cm;">
                <table>
                    <tr>
                        <td><img class="h1s" id="" src="images/logoIFBA.png" width="40" height="40" /></td>
                        <td><h3> Lista de atividades do participante:<c:out value="${participante.nome}"/></h3></td>

                    </tr>

                </table>
            </fieldset>
            <div>
                <fieldset style="border-width: 0.1px; border-radius: 0.5cm; background: white ;">
                    <form action="Controller" name="form" method="post">
                        <table class="container" style="width: 100%;" >

                            <tr >
                                <td class="br" id="br" style="text-align: center; color: white;"><h3 style="color: white;">Codigo autenticidade:</h3></td>
                                <td style="text-align: center;" class="br" id="br" colspan="2"><h3 style="color: white;"> Nome atividade</h3></td>
                                <td class="msg"></td>
                            </tr>
                            <c:if test="${not empty certificados}">
                                <c:forEach var="c" items="${certificados}">
                                    <tr>
                                        <td class="msg2" style="text-align: center;">${c.codigoAutenticacao}</td>
                                        <td style="text-align: center;" class="msg2">${c.participacao.atividade.descricao}</td>
                                        <td class="msg"><a href="Controller?operacao=DirecionarPageImpressaoCertificadoCPF&acao=${c.codigoAutenticacao}"> <img width="30" height="30" title="Imprimir certificado ${participante.nome}" alt="Imprimir certificado" src="images/pdfI.svg" /></a> </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty certificados}">
                                <tr>
                                    <td colspan="3"><h3  style="color: red;">Não existe Certificados para impressão</h3></td>
                                </tr>
                            </c:if>
                            <tr>
                                <td colspan="3" style="background: #F3F3F3;"><h3>Todos os certificados para impressão das atividades referente a eventos ocorrido na instituição que você participou estão aqui neste local.</h3></td>
                            </tr>
                            <tr>
                            <td class="msg2" style="text-align: center;" colspan="2"><a href="<c:url value="Controller?operacao=DirecionarPageIndex"/> ">Voltar para pagina principal</a></td>
                        </tr>
                        </table>
                    </form>
                </fieldset>

            </div>



        </div>
        <!--fim container-->
    </fieldset>
                        
    <%@include file="../divFim.jsp" %>
</body>
</html>
