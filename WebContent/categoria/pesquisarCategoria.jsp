<%-- 
    Document   : pesquisarEvento
    Created on : 02/05/2016, 21:29:24
    Author     : diocesse
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="edu.ifba.hibernate.entidade.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="edu.ifba.hibernate.entidade.CategoriaAtividade"%>

<c:if test="${adm != null }">
<html>
    <jsp:include page="../face.jsp"></jsp:include>
        <body>


        
        <jsp:include page="../menu_restrito.jsp"></jsp:include>
        <jsp:include page="../divInicio.jsp"></jsp:include>

            <fieldset class="container" id="" style="width: 90%; border-width: 1px;">
                <legend class="br" > Links de cadastro</legend>
                <fieldset class="br" style="width: 97%; border-width: 1px;">  

                    <table>
                        <tr>
                            <td><a id="facecorpo" class="br- a" href="Controller?operacao=DirecionarCadastroAtividade"><img class="br" src="images/ativ.svg" alt="" width="40" height="40"/> Nova atividade</a></td>
                            <td><a id="facecorpo" class="br- a" href="Controller?operacao=DirecionarPageCadastroCategoria"><img class="br" src="images/atividade.png" alt="" width="40" height="40"/> Cadastrar
                                    categoria<a></td>
                                        </tr>
                                        </table>
                                        </fieldset>
                                        <fieldset class="" style="width: 97%; border-width: 1px;"> 
                                            <table>
                                                <table style="width: 100%;" border="0" id="" class="container">
                                                    <tbody>
                                                        <tr>
                                                    <form method="post" action="Controller" id="banner">
                                                        <td class="corT">Pesquisar:</td>
                                                        <td><input name="txtPesquisar" class="" size="70"
                                                                   type="text" /><br></td>
                                                        <td><input value="Pesquisar" class="button-small"
                                                                   name="btPesquisar" type="submit"> <input
                                                                   value="DirecionarFiltroAtividade" name="operacao"
                                                                   type="hidden" /> <br></td>
                                                        <td><br></td>
                                                    </form>
                                                    </tr>

                                                    </tbody>
                                                </table>
                                        </fieldset>
                                        <table border="0" style="width: 100%" id="" class="container">


                                            <tr class="br" id="facecorpo">
                                                <td>ID</td>
                                                <td>Categorias das atividades</td>

                                            </tr>


                                        <c:if test="${categorias != null}">

                                            <c:forEach var="cat" items="${categorias}">
                                                <tr class="fundo" id="facecorpo">
                                                    <td style="width: 30.90px;" class="corT"><c:out value="${cat.idCatAtividade}"/></td>
                                                    <td style="width: 300.90px;" class="corT"><c:out value="${cat.descricao}"/></td>
                                                    <td style="width: 30.90px;"><a href="#"><img
                                                                src="images/edit.png" width="20" height="20" /> </a></td>
                                                    <td style="width: 30.90px;"><a href="#"><img
                                                                src="images/excluir.png" width="20" height="20" /></td>
                                                    <td style="width: 30.90px;"><a
                                                            href="Controller?operacao=DirecionarPageAtividadePorCategoria&acao=<c:out value="${cat.idCatAtividade}"/>"><img
                                                                src="images/ativ.svg" width="20" height="20" /></td>

                                                </tr>
                                            </c:forEach>

                                        </c:if>


                                    </table>
                                    </table>
                                    <fieldset style="border-width: 1px;">
                                        <h1>

                                            PESQUISAR
                                            AS INFORMAÇÕES POR FILTRO :
                                        </h1> <jsp:include page="../divFim.jsp"></jsp:include>

                                    </fieldset>
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