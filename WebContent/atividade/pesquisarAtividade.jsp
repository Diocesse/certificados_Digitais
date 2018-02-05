<%-- 
    Document   : pesquisarEvento
    Created on : 02/05/2016, 21:29:24
    Author     : diocesse
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${adm != null }">
    <html>
        <jsp:include page="../face.jsp"></jsp:include>
            <body>

            <jsp:include page="../menu_restrito.jsp"></jsp:include>
            <jsp:include page="../divInicio.jsp"></jsp:include>
            
            <fieldset class="container" id="" style="width: 90%; border-width: 1px;">
                <fieldset class="br" style="border-width: 1px;">
                    <table>
                        <tr>

                            <td><a id="facecorpo" class="br- a" href="Controller?operacao=DirecionarCadastroAtividade"><img class="br" src="images/ativ.svg" width="30" height="30" title="Cadastrar atividade"/> Nova atividade</a>|</td>

                            <td><a id="facecorpo" class="br- a" href="Controller?operacao=DirecionarPageCadastroCategoria"><img class="br" src="images/atividade.png" width="30" height="30" title="Cadastrar categoria"/>Cadastrar categoria</a></td>
                        </tr>
                    </table>

                </fieldset>      

                <table>
                    <tr>

                        <td>
                            <fieldset  style="border-width: 1px; width: 120%">
                                <table style="width: 100%;" border="0" id="face" class="container">
                                    <tbody>
                                        <tr>
                                    <form method="post" action="Controller" id="banner">
                                        <td></td>
                                        <td style="color: darkred; font-size: 16px;">Pesquisar:</td>
                                        <td><input name="txtPesquisar" class="" size="60"
                                                   type="text" /></td>
                                        <td><input value="Pesquisar" class="button-small"
                                                   name="btPesquisar" type="submit"> <input
                                                   value="DirecionarFiltroAtividade" name="operacao"
                                                   type="hidden" /> </td>
                                        <td><br></td>
                                    </form>


                                    </tbody>
                                    </td>
                                    </tr>
                                </table>
                            </fieldset>
                    </tr>


                    <table border="0" style="width: 100%" id="" class="container">
                        <thead id="ajustarTabela">
                            <tr class="">
                                <th colspan="5"><br></th>

                            </tr>
                        </thead>

                        <tr class="br" id="facecorpo">
                            <td>Id</td>
                            <td>Atividades disponiveis para os participantes</td>
                            <td>Data Inicio</td>
                            <td>Hora Inicial</td>
                            <td>Hora Final</td>
                        </tr>

                        <c:if test="${atividades != null}">
                            <c:forEach var="a" items="${atividades}">
                                <tr id="facecorpo" class="fundo">
                                    <td class="corT"><c:out value="${a.idAtividade}"/> </td>
                                    <td  class="corT"><c:out value="${a.descricao}"/></td>
                                    <td  class="corT"><fmt:formatDate value="${a.dataAtividade}" pattern="dd/MM/yyyy"/> </td>
                                    <td  class="corT"><fmt:formatDate value="${a.horaAtividadeInicio}" pattern="HH:mm:ss"/></td>
                                    <td  class="corT"><fmt:formatDate value="${a.horaAtividadeFinal}" pattern="HH:mm:ss"/></td>
                                    <td style="width: 30.90px; height: 30.34px"><a
                                            href="Controller?operacao=DirecionarPageEditarAtividade&acao=<c:out value="${a.idAtividade}"/>"><img
                                                src="images/edit.png" width="20" height="20" /> </a></td>
                                    <td><a href="Controller?operacao=DirecionarPageExclusaoAtividade&acao=<c:out value="${a.idAtividade}"/>"><img src="images/ativ.svg" width="20" height="20"/></td>
                                    <td><a
                                            href="Controller?operacao=DirecionarPageColecaoParticipantes&acao=<c:out value="${a.idAtividade}"/>"><img title="Adicionar uma lista de participantees"
                                                                                                                                                  src="images/novo.png" width="30" height="30" /></td>

                                </tr>
                            </c:forEach>
                        </c:if>

                    </table>
                </table>
                <fieldset style="border-width: 1px;"><h1 class="h11">FILTRAR AS ATIVIDADES CADASTRATATAS EM EVENTOS.</h1>
                </fieldset>
            </fieldset>
            <jsp:include page="../divFim.jsp"></jsp:include>
            </body>
        </html>
</c:if>
<c:if test="${adm == null }">
    <%
        String msg = "Login e senha e necessario";
        request.setAttribute("msg", msg);
        request.getRequestDispatcher("../logar.jsp").forward(request, response);

    %>
</c:if>
