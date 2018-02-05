

<%@page import="edu.ifba.hibernate.entidade.Atividade"%>
<%@page import="edu.ifba.hibernate.dataFormatar.FormatarData"%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="edu.ifba.hibernate.entidade.Administrador"%>
<%
	Administrador sessao = (Administrador) session.getAttribute("adm");
%>
<%
	if (sessao != null) {
%>
<html>
<%
	Atividade e = (Atividade) request.getAttribute("atividade");
%>
<jsp:include page="../face.jsp"></jsp:include>
<body>
	<jsp:include page="../menu_restrito.jsp"></jsp:include>
	<jsp:include page="../divInicio.jsp"></jsp:include>
	<h4 class="h1s" id="">
		Qual operação deseja realizar [Remover] [Finalizar] atividade:
		<%=e.getDescricao()%></h4>
	<form action="Controller" method="get">
		<table class="container" style="width: 100%">
			<tr class="br" id="facecorpo">
				<td id="">ID</td>
				<td id="">Nome do atividade</td>
				<td id="">Data do atividade</td>
				<td id="">Inicio</td>
				<td id="">Fim</td>
			</tr>

			<tr id="facecorpo" class="">
				<td id="corT"><%=e.getIdAtividade()%></td>
				<td id="corT" style="width: 90000.45px;"><%=e.getDescricao()%>
				</td>
				<td id="corT" style="width: 500.45px;"><%=FormatarData.ddMMyyyyVisao(e.getDataAtividade())%>
				</td>
				<td id="corT"><%=FormatarData.hhMMVisao(e.getHoraAtividadeInicio())%>
				</td>
				<td id="corT"><%=FormatarData.hhMMVisao(e.getHoraAtividadeFinal())%>
				</td>
			</tr>
			<tr>
				<td><input name="txtExcluir" value="<%=e.getIdAtividade()%>"
					type="hidden" /> <input name="operacao"
					value="DirecionarFinalizarExclusaoEvento" type="hidden" /></td>
				<td><input name="btExclusao" id="gerar"
					value="Remover atividade" type="submit" class="" /></td>

				<td><input name="btExclusao" id="gerar"
					value="Finalizar atividade" type="submit" class="" /></td>
				<td><input name="btExclusao" id="gerar" value="Participantes"
					type="submit" class="" /></td>
				<td><input name="btExclusao" id="gerar" value="Voltar page"
					type="submit" class="" /></td>

			</tr>

		</table>


		</table>

	</form>




	<jsp:include page="../divFim.jsp"></jsp:include>

</body>
</html>
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
