<%-- 
    Document   : cadastrarNewAdm
    Created on : 05/05/2016, 11:48:32
    Author     : diocesse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../face.jsp" %>
    <%String erros[] = (String[])request.getAttribute("erros"); %>
    <body>
        <%@include file="../menu_restrito.jsp"  %>
        <%@include file="../divInicio.jsp" %>
        
        <form name="formE" action="Controller" method="post">
        <fieldset class="container" id="" style="width: 90%; "><legend id="face"class="br">CADASTRAR:</legend>
            <table>
            <h1><img height="60"width="60" src="images/logoIFBA.png" /> CADASTRAR NOVO ADMINISTRADOR </h1>
            <label class="corT" style="text-align: center">Obs. Todos os campos devem ser preenchido obrigatoriamente.</label>
            <table border="0" style="width:100% " id="" class="container">
                <thead id="ajustarTabela">
                <tr class="br" id="facecorpo" >
                    <th colspan="40"><br></th>
                    
                </tr>
            </thead>
            </table>
            <table style="width: 100%">
            <tbody>
                <tr>
                    <td id="ajustarTabela">Nome:</td>
                    <td ><input type="text" name="txtNome" accesskey="" value="" class="select1" /></td>
                    <td style="width: 500.10px"class="select1" ><%if(erros[0] != null){%><%=erros[0]%><%}%> <br></td>
                </tr>
                <tr>
                    <td id="ajustarTabela">Login:</td>
                    <td ><input type="text" name="txtLogin" class="select1" /></td>
                    <td style="width: 500.10px"class="select1" ><br></td>
                </tr>  
                <tr><br>
                    <td id="ajustarTabela">Senha:</td>
                    <td ><input type="password" name="txtSenha" class="select1" /></td>
                    <td style="width: 500.10px"class="select1" ><br></td>
                </tr>
                <tr>
                    <td id="ajustarTabela">Confirma senha:</td>
                    <td ><input type="password" name="txtConfSenha" class="select1" /></td>
                    <td style="width: 500.10px"class="select1" ><br></td>
                </tr>
                
                <tr><td><br></td></tr>
                 <tr>
                     <td><input type="hidden" value="DirecionarCadastroAdm" name="operacao"/></td>
                    <td><input class="salvar" id=""  type="submit" value="Salvar" />|<input class="salvar" id=""  type="reset" value="Limpar" /></td>
                    <td><input type="hidden" value="0" name="codigo"/></td>
                </tr>
            </tbody>
        </table>
            </table>
    </table>
    </fieldset>
        </form>
    </body>
</html>
