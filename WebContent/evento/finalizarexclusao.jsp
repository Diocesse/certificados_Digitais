<%-- 
    Document   : finalizarexclusao
    Created on : 04/05/2016, 08:43:21
    Author     : diocesse
--%>

<%@page import="edu.ifba.hibernate.dataFormatar.FormatarData"%>
<%@page import="edu.ifba.hibernate.entidade.Evento"%>

<!DOCTYPE html>
<html>
    <%Evento e = (Evento) request.getAttribute("evento");%>
    <jsp:include page="../face.jsp"></jsp:include>
        <body>
        <jsp:include page="../menu_restrito.jsp"></jsp:include>
        <jsp:include page="../divInicio.jsp"></jsp:include>
        <h2 class="h1s" id="">Finalizar exclusão do evento <%=e.getDescricao()%></h2>
        <form action="Controller" method="get">   
            <table class="container">
                <tr class="br" id="facecorpo">
                    <td id="">
                        ID 
                    </td>
                    <td id="">
                        Nome do evento 
                    </td>
                    <td id="">
                        Data do evento 
                    </td>
                    <td id="">
                        Hora do evento 
                    </td>
                </tr>

                <tr id="facecorpo" class="">
                    <td id="corT" >
                        <%=e.getIdEvento()%> 
                    </td>
                    <td id="corT"style="width: 400.45px;" >
                        <%=e.getDescricao()%>  
                    </td>
                    <td id="corT" style="width: 299.45px;">
                        <%=FormatarData.ddMMyyyyVisao(e.getDataEvento())%>  
                    </td>
                    <td id="corT">
                        <%=FormatarData.hhMMVisao(e.getHoraEvento())%>  
                    </td>
                    
                </tr>
                <tr>
                    <td>
                        <input name="txtExcluir" value="<%=e.getIdEvento()%>" type="hidden"/>
                        <input name="operacao" value="DirecionarFinalizarExclusaoEvento" type="hidden"/>
                    </td>
                    <td>
                        <input name="btExclusao" id="gerar" value="Finalizar" type="submit"class="" />
                    </td>

                    <td>
                        <input name="btExclusao" id="gerar" value="Cancelar" type="submit"class="" />
                    </td>
                    <td>

                    </td>

                </tr>

            </table>


        </table>

    </form>




    <jsp:include page="../divFim.jsp"></jsp:include>

</body>
</html>
