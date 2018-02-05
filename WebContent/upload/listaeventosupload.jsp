<%-- 
    Document   : listaeventosupload
    Created on : 17/05/2016, 21:37:19
    Author     : diocesse
--%>

<%@page import="edu.ifba.hibernate.dataFormatar.FormatarData"%>
<%@page import="edu.ifba.hibernate.entidade.Evento"%>
<%@page import="java.util.List"%>
<%@page import="edu.ifba.hibernate.entidade.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<% Administrador sessao = (Administrador) session.getAttribute("adm");%>
<%if (sessao != null) {%> 
<html>
    <jsp:include page="../face.jsp"></jsp:include>
        <body>
        <jsp:include page="../menu_restrito.jsp"></jsp:include> 
        <jsp:include page="../divInicio.jsp"></jsp:include> 
            <div class="container">
           

            <fieldset style="height: 90%; width: 85%; border: none" class=""><fieldset style="width: 15%; border: none;"></fieldset>
                <table> 
                    <tr>

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

                <%List<Evento> eventos = (List<Evento>) request.getAttribute("eventos"); %>
                <table style="width: 100%;" border="0" class="container">
                    <tbody>
                        <tr class="br" id="facecorpo" >
                            <td style="width: 48.883px; height: 19px;">Id</td>
                            <td>Image</td>

                            <td>Upload image</td>

                        </tr>
                        <%if (eventos != null) { %>
                        <%for (Evento e : eventos) {%>
                        <tr id="facecorpo" class="">
                            <td class="corT"><%=e.getIdEvento()%> <br>
                            </td>
                            <td style="width: 600.45px;" id=""> <img src="FileDownload?acao=eventoImage&id=<%=e.getIdEvento()%>" title="<%=e.getDescricao()%>" width="100" height="100" style="text-align: center;" /><br>
                                <%=e.getDescricao()%>
                            </td>

                            <td><a class="br" id="facecorpo" href="Controller?operacao=DirecionarPageUploadEventoImage&acao=<%=e.getIdEvento()%>">Inserir image logo evento</a> </td>
                        </tr>
                        <%}%>
                        <%}%>

                    </tbody>
                </table>
                <br>
                <h1 class="h1s">Upload da imagem para inserir ao evento</h1>
            </fieldset>
        </div>  

        <jsp:include page="../divFim.jsp"></jsp:include>
        <jsp:include page="../finalPage.jsp"></jsp:include>
        </body>
    </html>
<%} else {%>
<% String msg = "Autenticaçao e necessaria!";%>
<% request.setAttribute("msg", msg);  %>   
<jsp:forward page="../logar.jsp"></jsp:forward>
<%}%>
