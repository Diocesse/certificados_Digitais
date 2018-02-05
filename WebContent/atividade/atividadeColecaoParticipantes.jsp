<%-- 
    Document   : atividadeColecaoParticipantes
    Created on : 10/05/2016, 13:43:53
    Author     : diocesse
--%>
<!DOCTYPE html>
<html>
    <%@include file="../face.jsp" %>
    <body>
        <%@include file="../menu_restrito.jsp" %>
        <%@include file="../divInicio.jsp" %>

        <fieldset style="border-radius: 0.5cm; border-width: 1px; width: 100%;" class="container">

            <fieldset class="" style="border-width: 1px; border-radius: 0.4cm;">
                <table>
                    <tr>
                        <td><img class="h1s" id="" src="images/logoIFBA.png" width="40" height="40" /></td>
                        <td><h3> Consulte os participantes desejado para a atividade: <c:out value="${atividade.descricao}"/> <c:if test="${not empty mensagem}">${mensagem}</c:if> </h3></td>
                    </tr>
                    <tr>
                        <td colspan="2"><h4 style=" text-align: center; color: red;">Busca será realizada pelo o CPF do participante</h4></td>
                        <td> </td>
                    </tr>
                    <tr>
                        <td></td>
                    </tr>

                </table>
            </fieldset>
            <div>
                <fieldset style="border-width: 0.1px; border-radius: 0.5cm; background: white ;">
                    <form action="Controller" name="form" method="get">
                        <table class="container">

                            <tr>
                                <td class="msg2" style="text-align: right;">Pesquisar:</td>
                                <td style="text-align: left;">
                                    <input type="text" name="pesquisar" class="select1" placeholder="Pesquisar participante cadastrados" size="50"/>
                                </td>
                                <td>
                                    <input value="${atividade.idAtividade}" name="codAtiv" type="hidden"/>
                                    <input type="submit" name="buscar" style="width: 120%; color: wheat; background: darkorchid;" class="select1" value="Pesquisar" size="30"/>
                                </td>
                            </tr>


                            <tr>
                                <td class="msg2" style="text-align: right;"><input required="required"  value="DirecionarPageCarrinho" type="hidden" name="operacao"/> </td>
                            </tr>


                        </table>
                    </form>



            </div>
            <%@include file="../lista_para_atividade.jsp" %>
        </fieldset>



        <%@include file="../divFim.jsp" %>




    </body>
</html>
