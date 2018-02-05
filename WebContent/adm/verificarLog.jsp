<%-- 
    Document   : logarAdm
    Created on : 27/05/2016, 11:04:19
    Author     : diocesse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 
    
        <body>
        
            <div class="container" id="header" >
                <form name="formE" action="Controller" method="get" style="height: auto;">
                    <fieldset class="container" style="width: 30%; border-width: 1px; "><legend class="br">Aguarde...</legend>
                        <table >
                            <h1><img height="60"width="60" src="images/logoIFBA.png" />Consultar autenticaçao</h1>
                            <table border="0" style="width:200% " id="" class="container">
                                <thead id="ajustarTabela">
                                    <tr class="br" id="facecorpo" >
                                        <th colspan="20"></th>

                                    </tr>
                                </thead>
                            </table>
                        <%String msg = (String) request.getAttribute("msg");%>
                        <table class="container"style="width:60% " >
                            <%if (msg != null) {%><tr class="corT"><td class="corT"></td><td><%=msg%></td> </tr> <%}%>
                            <tbody>
                                <tr>
                            <td id="ajustarTabela">Login:</td>
                            <td ><input type="text" name="usuario" class="select1" /></td>
                            <td style="width: 300.10px"class="select1" ><br></td>
                            </tr>
                            <tr>
                            <td id="ajustarTabela">Senha:</td>
                            <td ><input type="password" name="senha" class="select1" /></td>
                            <td style="width: 300.10px"class="select1" ><br></td>
                            </tr>            
                            <tr><td><br></td></tr>
                            <tr>
                                <td><input name="operacao" value="DirecionarConsultaAdm" id=""
                                           type="hidden"></td>
                                <td><input class="salvar" id=""  type="submit" value="Verificar" /></td>
                                <td><input type="hidden" value="0" name="codigo"/></td>
                            </tr>
                            </tbody>
                        </table>
                    </table>
                    </table>
                </fieldset>
            </form>
        </div>
        

    </body>
</html>
