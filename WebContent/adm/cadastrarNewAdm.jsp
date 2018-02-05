<%-- 
    Document   : cadastrarNewAdm
    Created on : 05/05/2016, 11:48:32
    Author     : diocesse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../face.jsp" %>

    <body>
        <%@include file="../menu_restrito.jsp"  %>
        <%@include file="../divInicio.jsp" %>
        <fieldset style="border-radius: 0.5cm; border-width: 1px; width: 40%;" class="container">

            <fieldset class="" style="border-width: 1px; border-radius: 0.4cm;">
                <table>
                    <tr>
                        <td><img class="h1s" id="" src="images/logoIFBA.png" width="40" height="40" /></td>
                        <td><h3> Formulario de cadastro de uma administrador para o portal.</h3></td>

                    </tr>

                </table>
            </fieldset>
            <div>
                <fieldset style="border-width: 0.1px; border-radius: 0.5cm; background: white ;">
                    <form name="formE" action="Controller" method="post">

                        <table class="container">
                            <tbody>
                                <tr>
                                    <td id="ajustarTabela">Nome:</td>
                                    <td  style="text-align: left;"><input type="text" name="txtNome" required="required" style="width: 15cm;" class="select1" /></td>
                                    <td style="width: 500.10px"class="" ><br></td>
                                </tr>
                                <tr>
                                    <td id="ajustarTabela">Login:</td>
                                    <td style="text-align: left;" ><input type="text" style="width: 50%;" required="required" name="txtLogin" class="select1" /></td>
                                    
                                </tr>  
                                <tr><br>
                            <td id="ajustarTabela">Senha:</td>
                            <td style="text-align: left;" ><input type="password" required="required" name="txtSenha" style="width: 30%;" class="select1" /></td>
                            
                            </tr>
                            <tr>
                                <td id="ajustarTabela">Confirma senha:</td>
                                <td style="text-align: left;" ><input type="password" required="required" style="width: 30%;" name="txtConfSenha" class="select1" /></td>
                                
                            </tr>

                            <tr >
                                <td><input type="hidden" value="DirecionarCadastroAdm" name="operacao"/><br></td>
                                <td style="text-align: left;"><input class="" id="" style="width: 5cm; height: 2cm; color: green;"  type="submit" value="Salvar" />|<input class="" id="" style="width: 5cm; height: 2cm; color: red;"  type="reset" value="Limpar" /></td>
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
