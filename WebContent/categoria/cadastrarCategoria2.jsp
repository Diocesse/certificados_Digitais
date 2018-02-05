<%-- 
    Document   : cadastrarAtividade
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
        <%String erros[] = (String[])request.getAttribute("erros");
          out.print(erros[0]);
        %>
        <form name="formE" action="Controller" method="post">
        <fieldset class="container"  id="" style="width: 40%;"><legend id="face"class="br">CADASTRAR:</legend>
            <fieldset>
            <table>
            <h1><img height="60"width="60" src="images/logoIFBA.png" />CADASTRO DE CATEGORIA DE UMA PARA UMA ATIVIDADE</h1>
            <label class="corT" style="text-align: center">Obs. Todos os campos devem ser preenchido obrigatoriamente.</label>
            
            <table border="0" style="width:100% " id="" class="container">
                <thead id="ajustarTabela">
                <tr class="br" id="facecorpo" >
                    <th colspan="4"><br></th>
                    
                </tr>
            </thead>
            </table>
            <table>
            <tbody>
                
                <tr><br>
                    <td id="ajustarTabela">Descricão:</td>
                    <td ><input type="text" name="txtDescricao" class="select1" size="30" /></td>
                    <td style="width: 500.10px; color: red;"class="" ><%if (erros[0]!=null){out.println(erros[0]);}%> <br></td>
                </tr>
                              
                <tr><td><br></td></tr>
                 <tr>
                     <td><input type="hidden" value="DirecionarCadastroCategoria" name="operacao"/></td>
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
