<%-- 
    Document   : pesquisarevento
    Created on : 04/05/2016, 13:48:33
    Author     : diocesse
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
 
<c:if test="${adm != null }">
<html>
    <jsp:include page="../face.jsp"></jsp:include>
    <body>
        <jsp:include page="../menu_restrito.jsp"></jsp:include> 
        <jsp:include page="../divInicio.jsp"></jsp:include> 
            <div class="container">
            
          
            <fieldset style="height: 90%; width: 95%; border-width: 1px" class="">
                <fieldset class="" style="width: 98%; border-width: 1px;">
            <table> 
                <tr class="msg" id="facecorpo">
			
				<td><a id="facecorpo" class="br- a" href="Controller?operacao=DirecionarPageCadastroEvento"
                                       class="br- a" id="facecorpo"><img  src="images/seta.jpg" class="br" width="20"
						height="20" /> Novo Evento</a></td>
				<td><a id="facecorpo" class="br- a"
					href="Controller?operacao=DirecionarCadastroAtividade"><img
						src="images/seta.jpg" class="br" width="20" height="20"
						title="Cadastrar atividade" /> Nova atividade</a></td>

				<td><a id="facecorpo" class="br- a"
					href="Controller?operacao=DirecionarPageCadastroCategoria"><img
						src="images/seta.jpg" class="br" width="20" height="20"
						title="Cadastrar categoria" /> Cadastrar categoria</a></td>
			</tr>
            </table>
            </fieldset>
               
            <table  style="width: 50%;" border="0"id="face" class="" >
                <tbody>
                    <tr>
                <form method="post" action="Controller" id="banner">
                    <td  class="corT">Filtrar descrição</td>
                    <td><input name="txtPesquisar" class="" size="50" type="text"/><br>
                    </td>
                    <td><input value="Pesquisar" class="button-small" name="btPesquisar"
                               type="submit"> <input value="DirecionarFiltroEventos" name="operacao" type="hidden"/> <br>
                    </td>
                    <td><br>
                    </td>
                </form>
                </tr>

                </tbody>
            </table>     

            <table style="width: 100%;" border="0" class="container">
                <tbody>
                    <tr class="br" id="facecorpo" >
                        <td style="width: 48.883px; height: 19px;">ID</td>
                        <td>Descricao</td>
                        <td>Data Evento </td>
                        <td>Hora Evento<br>
                        </td>
                        <td>Local</td>

                    </tr >
                    
                    <c:if test="${eventos != null}">
                        <c:forEach var="e" items="${eventos}">
                
                    <tr id="" class="br">
                        <td class="h11"><c:out value="${e.idEvento}"/> <br>
                        </td>
                        <td style="width: 600.45px;" class="msg"><c:out value="${e.descricao}"/><br>
                        </td>
                        <td style="width: 150px;" class="msg"><fmt:formatDate value="${e.dataEvento}" pattern="dd/MM/yyyy"/> <br>
                        </td>
                        <td style="width: 150px;" class="msg"><fmt:formatDate value="${e.horaEvento}" pattern="HH:mm:ss"/><br>
                        </td>
                        <td style="width: 325px;" class="msg"><c:out value="${e.localEvento}"/><br>
                        </td>
                        <td style="width: 50px;"><a href="Controller?operacao=DirecionarPageExclusaoEvento&acao=<c:out value="${e.idEvento}"/>"><img alt="Deleta" title="Deleta <c:out value="${e.descricao}"/>" src="images/remover.png" width=20"" height="20"/> </a><br>
                        </td>
                        <td style="width:50px;"><a href="Controller?operacao=DirecionarPageEditarEvento&acao=<c:out value="${e.idEvento}"/>"><img title="Editar <c:out value="${e.descricao}"/>" src="images/edit.png" height="25" width="25" /> </a> </td>
                        <td style="width:50px;"><a href="Controller?operacao=DirecionarPageCadadastrarAtividade&acao=<c:out value="${e.idEvento}"/>"><img src="images/ativ.svg" title="criar atividade para <c:out value="${e.descricao}"/>" height="20" width="20"/></a> </td>
                         </tr>
                        </c:forEach>
                    </c:if>
                    

                </tbody>
            </table>
            <br>
            <fieldset style="border-width: 1px;">
                <h1 class="lab" >Pesquisa dos eventos usando filtro de informações</h1>
            </fieldset>
            </fieldset>
        </div>  

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