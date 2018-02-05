
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <%@include file="../face.jsp" %>
    <body>
        <%@include file="../menu_restrito.jsp"  %>
        <%@include file="../divInicio.jsp" %>
         
        <fieldset style="border-radius: 0.5cm; border-width: 1px; width: 60%;" class="container">

            <fieldset class="" style="border-width: 1px; border-radius: 0.4cm;">
                <table>
                    <tr>
                        <td><img class="h1s" id="" src="images/logoIFBA.png" width="40" height="40" /></td>
                        <td><h3> Formulario de cadastro de uma categorias.</h3></td>
 
                    </tr>

                </table>
            </fieldset>
            <div>
                <fieldset style="border-width: 0.1px; border-radius: 0.5cm; background: white ;">
                    <form action="Controller" name="form" method="post">
                        <table>
                            <tbody>
                               
                            <br>
                            <td id="ajustarTabela">Descricão:</td>
                            <td ><input type="text" name="txtDescricao" required="required" class="select1" size="40" /></td>

                            <br></td>
                            </tr>

                            <tr><td><br></td></tr>
                            <tr>
                                <td><input type="hidden" value="DirecionarCadastroCategoria" name="operacao"/></td>
                                <td><input class="button" id=""  type="submit" value="Salvar" />|<input class="button" id=""  type="reset" value="Limpar" /></td>
                                <td><input type="hidden" value="0" name="codigo"/></td>
                            </tr>
                            </tbody>
                        </table>
                    </form>
                </fieldset>

            </div>

        </fieldset>
    </body>
</html>
