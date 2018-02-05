
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
                        <td><h3> Formulario de cadastro do autor para geração do certificado.</h3></td>

                    </tr>

                </table>
            </fieldset>
            <div>
                <fieldset style="border-width: 0.1px; border-radius: 0.5cm; background: white ;">
                    <form action="Controller" name="form" method="post">
                    <table class="container">
                       
                        <tr>
                            <td class="msg2" style="text-align: right;">Nome:</td>
                            <td style="text-align: left;"><input type="text" name="nome" class="select1" value="${autor.nome}" size="30"/> </td>
                            <td class="msg">*</td>
                        </tr>

                        <tr>
                            <td class="msg2" style="text-align: right;">Email:</td>
                            <td style="text-align: left;"><input type="email" class="select1" name="email" value="${autor.email}" size="30"/> </td>
                            <td class="msg">*</td> 
                        </tr>
                        
                         <tr>
                            <td class="msg2" style="text-align: right;">Contato:</td>
                            <td style="text-align: left;"><input type="tel" required="required" class="select1" name="contato" value="${autor.contato}" size="30"/> </td>
                        <td class="msg">*</td> 
                         </tr>
                        <tr>
                            <td class="msg2" style="text-align: right;"><input required="required"  value="DirecionarPageCadastrarAutor" type="hidden" name="operacao"/> </td>
                            <td style="text-align: left;"><input type="submit" class="button" value="Cadastrar autor"/>|<input type="reset" class="button" value="Limpar"/> </td>
                            <td class=""></td> 
                        </tr>
                        

                    </table>
                    </form>
                </fieldset>

            </div>

    </fieldset>
</body>
</html>
