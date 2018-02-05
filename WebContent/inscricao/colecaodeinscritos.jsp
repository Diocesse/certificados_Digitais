<%-- 
    Document   : colecaodeinscritos
    Created on : 17/05/2016, 15:35:09
    Author     : diocesse
--%>

<%@page import="java.util.List"%>
<%@page import="edu.ifba.hibernate.entidade.Participacao"%>
<!DOCTYPE html>
<%List<Participacao> lista = (List<Participacao>) request.getAttribute("participantesAtividades");%>

<html>
    <%@include file="../face.jsp" %>

    <body>
        <%@include file="../menu_restrito.jsp"  %>
        <%@include file="../divInicio.jsp" %>

        <form name="formE" action="Controller" method="post">
            <fieldset class="container" id="" style="width: 90%; "><legend id="face"class="br">CADASTRAR:</legend>
                <table>
                    <h1><img height="60"width="60" src="images/logoIFBA.png" />  ORGANIZAR CADASTRO DE CATEGORIA PARA ATIVIDADE</h1>
                    <label class="corT" style="text-align: center">Obs. Todos os campos devem ser preenchido obrigatoriamente.</label>
                    <table border="0" style="width:100% " id="" class="container">
                        <thead id="ajustarTabela">
                            <tr class="br" id="facecorpo" >
                                <th colspan="40"><br></th>

                            </tr>
                        </thead>
                    </table>
                    <table style="width: 100%">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Participante</th>
                                <th>Atividade</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:if test="${participantesAtividades != null}">
                           
                            <% for (Participacao a : lista) {%>

                            <tr>
                                <td><br> <%=a.getIdAtpa()%></td>
                                <td><%=a.getParticipante().getIdParticipante()%> <br></td>
                                <td><%=a.getAtividade().getIdAtividade()%><br></td>
                                <td><a href="" class="br" id="facecorpo"> Consultar inscriçao </a> </td>
                                <td></td>
                            </tr>
                            <%} %>
                         
                            </c:if>
                        </tbody>
                    </table>
                </table>
                </table>
            </fieldset>
        </form>
    </body>
</html>
