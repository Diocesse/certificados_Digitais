<%-- 
    Document   : pesquisarEvento
    Created on : 02/05/2016, 21:29:24
    Author     : diocesse
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="edu.ifba.hibernate.entidade.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<html>
    <jsp:include page="../face.jsp"></jsp:include>
        <body>
        <%
            if (session != null) {
        %>

        <%
            List<Administrador> lista = (List<Administrador>) request.getAttribute("adms");
        %>

        <jsp:include page="../menu_restrito.jsp"></jsp:include>
        <jsp:include page="../divInicio.jsp"></jsp:include>
            <fieldset class="container" id="" style="width: 90%; border-width: 1px;">
                <fieldset class="br" style="border-width: 1px; ">	
                    <table  style="width: 70%; text-align: center;" class="container">
                        <tr>
                            <td><a class="br- a" id="facecorpo" href="Controller?operacao=DirecionarPageCadastroAdm"><img src="images/novo.svg" width="20"
                                                                                                                          height="20" /> New Adm </a></td>
                            <td><a  href="Controller?operacao=DirecionarPageCadastroEvento"
                                    class="br- a" id="facecorpo"><img src="images/novo.svg" width="20"
                                                                  height="20" />New Evento</a></td>
                            <td><a id="facecorpo" class="br- a"
                                   href="Controller?operacao=DirecionarCadastroAtividade"><img
                                        src="images/ativ.svg" width="30" height="30"
                                        title="Cadastrar atividade" /> Nova atividade</a></td>

                            <td><a id="facecorpo" class="br- a"
                                   href="Controller?operacao=DirecionarPageCadastroCategoria"><img
                                        src="images/atividade.png" width="30" height="30"
                                        title="Cadastrar categoria" />Cadastrar categoria</a></td>
                        </tr>
                    </table>
                </fieldset>
                <table>     <fieldset class="" style="border-width: 1px; ">	
                        <label class="msg2"><c:if  test="${not empty msg}"> ${msg}</c:if></label>
                        <h2 style="text-align:center;">
                            PESQUISAR
                            AS INFORMAÇÕES POR FILTRO :
                            
                        </h2>
                        
                        <table style="width: 50%;" border="0" id="face" class="container">
                            <tbody>
                            <form method="post" action="Controller" id="">
                                <td class="corT">Pesquisar:</td>
                                <td><input name="txtPesquisar" class="select1" size="30"
                                           type="text" /><br></td>
                                <td><input value="Pesquisar" class="button-small"
                                           name="btPesquisar" type="submit"> <input
                                           value="DirecionarFiltroAtividade" name="operacao" type="hidden" />
                                    <br></td>
                                <td><br></td>
                            </form>
                            </tr>

                            </tbody>
                        </table>

                        <table border="0" style="width: 100%" id="" class="container">
                            <thead id="ajustarTabela">
                                <tr class="" id="">
                                    <th colspan="40"></th>

                                </tr>
                            </thead>

                            <tr class="br" id="facecorpo">
                                <td>ID</td>
                                <td>Nome</td>

                            </tr>

                        <c:if test="${not empty adms}">
                            <%
                                for (Administrador c : lista) {
                            %>
                            <tr class="fundo" id="facecorpo">
                                <td style="width: 40.90px;" class="corT"><%=c.getIdAdm()%></td>
                                <td style="width: 400.90px;" class="corT"><%=c.getNome()%></td>
                                <td style="width: 50.90px;"><a
                                        href="Controller?operacao=DirecionarPageEditarAdm"><img
                                            src="images/edit.png" width="20" height="20" /> </a></td>
                                <td style="width: 50.90px;"><a
                                        href="Controller?operacao=DirecionarPageExcluirAdm"><img
                                            src="images/excluir.png" width="20" height="20" /></td>
                                <td style="width: 50.90px;"><a
                                        href="Controller?operacao=DirecionarPageAtividadePorCategoria&acao=<%=c.getIdAdm()%>"><img
                                            src="images/ativ.svg" width="20" height="20" /></td>

                            </tr>
                            <%
                                }
                            %>


                        </c:if>
                        <tr>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </table>
                </fieldset>
            </table>
            <jsp:include page="../divFim.jsp"></jsp:include>

            <%
            } else {
            %>
            <%
                String msg = "Autenticaçao e necessaria!";
            %>
            <%
                request.setAttribute("msg", msg);
            %>
            <jsp:forward page="../logar.jsp"></jsp:forward>

            <%
                }
            %>

    </body>
</html>