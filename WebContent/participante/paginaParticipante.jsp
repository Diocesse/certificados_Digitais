<%-- 
    Document   : paginaParticipante
    Created on : 21/04/2016, 11:57:13
    Author     : diocesse
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<c:if test="${adm != null}">
<html>

    <jsp:include page="../face.jsp"></jsp:include>
        <body>

        <jsp:include page="../menu_restrito.jsp"></jsp:include>
        <jsp:include page="../divInicio.jsp"></jsp:include>
            <fieldset style="height: 35px; width: 100%; border-width: 0.1px; text-align: left; border:solid; " class="">
                <a  href="Controller?operacao=DirecionarPageCadastroParticipante"
                    class="br- a" id="facecorpo"><img class="br" src="images/seta.jpg" width="20" height="20" />
                   Novo,  </a>
                <label class="msg">É preciso informar CPF ou nome para busca.</label>
            </fieldset>
  <form method="post" action="Controller" id="banner">
              
       
        <fieldset style=" border-width: 0px;">
            <table style="width: 90%;" border="0" id="face" class="container">
                
                <tr>
                   <td class="msg2">Buscar </td>   
                </tr>  
                 
                <td><input name="txtPesquisar" placeholder="Pesquisar participante" class="select1" size="70"
                               type="text" /><br></td>
                    <td><input value="Pesquisar" class="select1" name="btPesquisar"
                               type="submit"> <input
                               value="DirecionarFiltroParticipantes" name="operacao"
                               type="hidden" /> <br></td>
                    <td><br></td>
                
                </tr>

            </table>
        </fieldset>
      </form>
        
        <c:if test="${participantesInfo != null}">
        <fieldset style=" border-width: 0px;">
            <table style="width: 95%;" border="0" class="container">
                <tbody>
                    <tr class="br" id="br"  ><td colspan="4"></td> </tr>
                    <tr class="br" id="br">
                        <td style="width: 48.883px; height: 19px;">ID</td>
                        <td>Nome</td>
                        <td>Sexo</td>
                        <td>E-mail</td>

                    </tr>
                    <c:forEach var="p" items="${participantesInfo}">
                    
                    <tr id="facecorpo" class="br">
                        <td class="corT"><c:out value="${p.idParticipante}"/> <br></td>
                        <td style="width: 500.45px;" class="msg"><c:out value="${p.nome}"/><br>
                        </td>
                        <td style="width: 285px;" class="msg"><c:out value="${p.sexo}"/><br></td>
                        <td style="width: 350px;" class="msg"><c:out value="${p.email}"/></td>
                        <td style="width: 50px;"><a
                                href="Controller?operacao=DirecionarExclusaoParticipante&acao=<c:out value="${p.idParticipante}"/>"><img
                                    alt="Deleta" title="Deleta <c:out value="${p.nome}"/> "
                                    src="images/remover.png" width="20" height="20" /> </a><br></td>
                        <td style="width: 50px;"><a
                                href="Controller?operacao=DirecionarPageEditarParticipante&acao=<c:out value="${p.idParticipante}"/>"><img
                                    title="Editar <c:out value="${p.nome}"/>" src="images/edit.png" height="20"
                                    width="20" /> </a></td>
                        <td style="width: 70px;"><a
                                href="Controller?operacao=DirecionarPageAtividadeParticipante&acao=<c:out value="${p.idParticipante}"/>"><img
                                    src="images/novo1.png"
                                    title="criar atividade para <c:out value="${p.nome}"/>" height="20"
                                    width="20" /></a></td>

                    </tr>
                   
                    </c:forEach>
                </tbody>
            </table>
            <fieldset style=" border-width: 0px;">
                <h1 class="lab"> INFORMAÇÃO DOS PARTICIPANTES CADASTRADOS</h1>
                <a href="<c:url value="Controller?operacao=DirecionarPageRestritoAdm"/> " class="salvar" id="br">Voltar para painel de notificaçoes</a>
            </fieldset>
        </fieldset>
        </c:if>
        
        <br>


        <jsp:include page="../divFim.jsp"></jsp:include>

        </body>
    </html>
</c:if>
<c:if test="${adm == null}">
    <%
     
     String msg = "Autenticaçao e necessaria!";   
     request.setAttribute("msg", msg);
     request.getRequestDispatcher("../logar.jsp").forward(request, response);
   
    %>
</c:if>   
