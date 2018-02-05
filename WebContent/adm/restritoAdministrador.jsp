<%-- 
    Document   : restritoAdministrador
    Created on : 20/04/2016, 21:03:05
    Author     : diocesse
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <!--face--><jsp:include page="../face.jsp"></jsp:include>


    <c:if test="${not empty adm}">    

        <body>
            <jsp:include page="../menu_restrito.jsp"></jsp:include>
            <jsp:include page="../divInicio.jsp"></jsp:include>

                <fieldset style="border-radius: 0.5cm; border-width: 1px;" class="container">

                    <fieldset class="" style="border-width: 1px; border-radius: 0.4cm;">
                        <table>
                            <tr>
                                <td><img class="h1s" id="" src="images/logoIFBA.png" width="40" height="40" /></td>
                                <td><h3 style="text-align: justify;"> Painel de notificações: ${msg} <img src="images/sucesso.png"/></h3></td>

                            </tr>

                        </table>
                    </fieldset>
                    <div>
                        <fieldset style="border-width: 0px; border-radius: 0.5cm; background: green ; height: 5cm;">
                            <table class="container">
                               
                            <tr>
                                <td colspan="2"><p class="msg2" style="color: white;">Atenção todos as notificações referente a cadastros atualizações exclusões será exibida neste painel., Para tirar o erro de codificação excluir UF8 </p></td>

                            </tr>
                            

                        </table>
                    </fieldset>

                </div>



            </div>
            <!--fim container-->
            <table class="container">
            <tr>
                <td class=""  style="text-align: center;" colspan="2"><a href="<c:url value="Controller?operacao=DirecionarPageIndex"/> ">Voltar para pagina principal</a></td>
            </tr>
            </table>
        </fieldset>

        <!-- ---------------------------------------------------- -->


    </body>
</c:if>
<c:if test="${empty adm}">
    <c:redirect url="/logar.jsp"></c:redirect>
</c:if>

</html>
