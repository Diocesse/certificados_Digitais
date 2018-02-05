
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
    <%@include file="face.jsp" %>
    <body>
        <%@include file="menuAdm.jsp" %>
        <%@include file="divInicio.jsp" %>
        <fieldset style="border-radius: 0.5cm; border-width: 0px; width: 60%;"  class="container">
            <fieldset class="" style="border-width: 0px; border-radius: 0.4cm;">
                
            
            <div>
                <fieldset style="border-width: 0.0px; border-radius: 0.5cm; background: white ;">
                    <form name="Controller" action="Controller" method="get">
                    <table class="">
                         <tr>
                        <td style="text-align: center;" colspan="2"><h3> Acesso restrita:Portal de Certificados.</h3></td>

                    </tr>
                        
                        <tr>
                           
                            <td class="msg2" colspan="2" style="text-align: left;color: red;"><c:if test="${not empty msg}">${msg}</c:if> </td>
                        </tr>
                        
                        <tr>
                            <td class="msg2" style="text-align: right;">Usuario:</td>
                            <td style="text-align: left;"><input type="text" placeholder="usuario" name="usuario" required="required" style="width: 10cm;" class="select1" size="30"/> </td>
                        </tr>

                        <tr>
                            <td class="msg2" style="text-align: right;">Senha:</td>
                            <td style="text-align: left;"><input type="password" placeholder="password" name="senha" required="required"  style="width: 10cm;" class="select1" size="30"/> </td>
                        </tr>
                        <tr>
                            <td class="msg2" style="text-align: right;"></td>
                            <td style="text-align: left;"><input type="submit" style="width: 5cm; height: 2cm; background: beige; color: green; border-radius: 0.3cm; border-width: 0px;" value="Autorizar"/>|<input type="reset" style="width: 5cm;  background: beige; height: 2cm; color: green; border-radius: 0.3cm; border-width: 0px;" value="Limpar"/> </td>
                        </tr>

                        <tr>
                            <td><input name="operacao" value="DirecionarLoginAdministrador" id=""
                                               type="hidden">
                            <input type="hidden" value="0" name="codigo"/>
                            </td>
                        </tr>
                        <tr>
                            <td class="msg2" style="text-align: left;" colspan=32"><a href="<c:url value="Controller?operacao=DirecionarPageIndex"/> ">Voltar para pagina principal</a></td>
                        </tr>

                    </table>
                    </form>
                </fieldset>

            </div>



        </div>
        <!--fim container-->
    </fieldset>

    <!-- ---------------------------------------------------- -->


</body>
</html>
