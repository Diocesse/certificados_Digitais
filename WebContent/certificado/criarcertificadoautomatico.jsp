<%-- 
    Document   : criarcertificadoautomatico
    Created on : 22/09/2016, 21:41:39
    Author     : diocesse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../face.jsp" %>
    <body>
        <%@include file="../menu_restrito.jsp" %>
        <%@include file="../divInicio.jsp" %>
        
         <fieldset style="border-radius: 0.5cm; border-width: 1px; width: 90%;" class="container">

            <fieldset class="" style="border-width: 1px; border-radius: 0.4cm;">
                <table>
                    <tr>
                        <td><img class="h1s" id="" src="images/logoIFBA.png" width="40" height="40" /></td>
                        <td><h3> Geração automatica dos relatorios das atividades cadastradas.</h3></td>

                    </tr>

                </table>
            </fieldset>
            <div>
                <fieldset style="border-width: 0.1px; border-radius: 0.5cm; background: white ;">
                    <form action="Controller" name="form" method="post">
                    <table class="container">
                       
                        <tr>
                            <td class="msg2" style="text-align: right;">Atividades:</td>
                            <td style="text-align: left;"><select size="1"><option>selecione</option></select> </td>
                            <td class="msg">*</td>
                        </tr>

                        <tr>
                            <td class="msg2" style="text-align: right;">Codigo de autenticidade:</td>
                            <td style="text-align: left;"><input type="email" name="email" size="30"/> </td>
                            <td class="msg">*</td> 
                        </tr>
                        
                         <tr>
                            <td class="msg2" style="text-align: right;">Autor:</td>
                            <td style="text-align: left;"><input type="tel" name="contato" size="30"/> </td>
                        <td class="msg">*</td> 
                         </tr>
                        <tr>
                            <td class="msg2" style="text-align: right;"><input  value="DirecionarPageCadastrarResponsavel" type="hidden" name="operacao"/> </td>
                            <td style="text-align: left;"><input type="submit" value="Cadastrar autor"/>|<input type="reset" value="Limpar"/> </td>
                            <td class=""></td> 
                        </tr>
                        <tr><td colspan="2" class="br"><br></td></tr> 
                        <tr>
                            <td colspan="2" ><h3 style="color:red;">Atençao: Basta seleciona a atividade desejada para gerar seus certificados. </h3></td>

                        </tr>

                    </table>
                    </form>
                </fieldset>

            </div>



        </div>
        <!--fim container-->
    </fieldset>
        
        <%@include file="../divFim.jsp" %>
    </body>
</html>
