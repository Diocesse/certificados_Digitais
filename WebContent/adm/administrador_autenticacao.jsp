<%-- 
    Document   : administrador_autenticacao
    Created on : 01/10/2016, 14:56:11
    Author     : diocesse
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../face.jsp" %>
    <body>
        <jsp:include page="../menu_restrito.jsp"></jsp:include>
        <jsp:include page="../divInicio.jsp"></jsp:include>

        <fieldset style="border-radius: 0.5cm; border-width: 1px; width: 50%;" class="container">

            <fieldset class="" style="border-width: 1px; border-radius: 0.4cm;">
                <table>
                    <tr>
                        <td><img class="h1s" id="" src="images/logoIFBA.png" width="40" height="40" /></td>
                        <td><h3> Autenticação é necessaria novamente.</h3></td>

                    </tr>

                </table>
            </fieldset>
            <div>
                <fieldset style="border-width: 0.1px; border-radius: 0.5cm; background: white ;">
                    <form action="Controller" name="form" method="post">
                    <table class="container">
                    
                         <tr>
                            
                             <td style="text-align: center; color: red;"  class="msg2" colspan="2"><c:if test="${not empty msg}">${msg}</c:if></td>
                        </tr>
                        <tr>
                            <td class="msg2" style="text-align: right;">User:</td>
                            <td style="text-align: left;"><input type="text" name="usuario" size="30"/> </td>
                        </tr>

                        <tr>
                            <td class="msg2" style="text-align: right;">Password:</td>
                            <td style="text-align: left;"><input type="password" name="senha" size="30"/> </td>
                        </tr>
                        <tr>
                            <td class="msg2" style="text-align: right;"><input  value="DirecionarPageAutenticacaoAdmGeral" type="hidden" name="operacao"/> </td>
                            <td style="text-align: left;"><input type="submit" value="Autorizar"/>|<input type="reset" value="Limpar"/> </td>
                        </tr>

                        <tr>
                            <td colspan="2"><p class="msg2">Para acessar está área desejada faça sua autenticação. </p></td>

                        </tr>

                    </table>
                    </form>
                </fieldset>

            </div>



        </div>
        <!--fim container-->
    </fieldset>
</body>
</html>
