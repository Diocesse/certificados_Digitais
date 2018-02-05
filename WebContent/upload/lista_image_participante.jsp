<%-- 
    Document   : inserir_image_participante
    Created on : 08/09/2016, 15:26:21
    Author     : diocesse
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../face.jsp" %>
    <body>
        <%@include file="../menu_restrito.jsp"  %>
        <%@include file="../divInicio.jsp" %>
        <div class="container">
            <fieldset style="height: 90%; width: 85%; border: none" class=""><fieldset style="width: 15%; border: none;"></fieldset>
 <table> 
                    <tr>
                        <td> <a  href="Controller?operacao=DirecionarPageCadastroParticipante"
                    class="br- a" id="facecorpo"><img class="br" src="images/novo.svg" width="30" height="30" />
                    Novo participante</a></td>
                        <td><a id="facecorpo" class="br- a" href="Controller?operacao=DirecionarPageCadastroEvento"
                               class="br" id="facecorpo"><img src="images/novo.svg" width="30" class="br"
                                                           height="30" />Novo Evento</a></td>
                        <td><a id="facecorpo" class="br- a"
                               href="Controller?operacao=DirecionarCadastroAtividade"><img
                                    src="images/ativ.svg" width="30" class="br" height="30"
                                    title="Cadastrar atividade" /> Nova atividade</a></td>

                        <td><a id="facecorpo" class="br- a"
                               href="Controller?operacao=DirecionarPageCadastroCategoria"><img
                                    src="images/atividade.png" class="br" width="30" height="30"
                                    title="Cadastrar categoria" />Cadastrar categoria</a></td>
                    </tr>
                </table>
                
                <table class="container" style="width: 100%">
                    <tr  class="br" id="facecorpo">
                        <td> Id: </td>
                        <td> Image:</td>
                        <td>Nova image:</td>
                    </tr>

                    <c:forEach var="p" items="${lista_image}">
                        <tr>
                            <td class="corT"><label><c:out value="${p.idParticipante}"/></label> </td>
                           
                            <td style="width: 600.45px; color: #1B1B1B" ><img src="FileDownload?acao=participanteImage&id=${p.idParticipante}" title="" width="100" height="100" style="text-align: center;" /><br><c:out value="${p.nome}"/> </td>
                            <td><a class="br" id="facecorpo" href="Controller?operacao=DirecionarPageUploadParticipanteImage&acao=<c:out value="${p.idParticipante}"/>"> <c:out value="Proximo"/></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </fieldset>
            <h2 class="h1s">Atenção: Atualize a imagem do participante no lik ao lado</h2>
        </div>
        <jsp:include page="../divFim.jsp"></jsp:include>
        <jsp:include page="../finalPage.jsp"></jsp:include>
    </body>
</html>
