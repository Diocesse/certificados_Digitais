<%-- 
    Document   : uploadimage
    Created on : 16/05/2016, 21:02:40
    Author     : diocesse
--%>

<%@page import="java.util.List"%>
<%@page import="edu.ifba.hibernate.entidade.Evento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="../face.jsp" %>

    <body>
        <%@include file="../menu_restrito.jsp"  %>
        <%@include file="../divInicio.jsp" %>
        <%Evento eventos = (Evento)request.getAttribute("eventos");   %>
        <form name="formUP" action="FileUploadServer" method="post" enctype="multipart/form-data">
            <fieldset class="container" id="" style="width: 90%; "><legend id="face"class="br">CADASTRAR:</legend>
                <table>
                    <h1><img height="60"width="60" src="images/logoIFBA.png" /> CARREGAR UMA IMAGEM PARA LOGOMARCA DO EVENTO :</h1>
                    <label class="corT" style="text-align: center">Obs. OS registros mais importante já estão cadastrados.</label>
                    <table border="0" style="width:100% " id="" class="container">
                        <thead id="ajustarTabela">
                            <tr class="br" id="facecorpo" >
                                <th colspan="40"><br>Evento: <%=eventos.getDescricao()%></th>
                                
                            </tr>
                        </thead>
                    </table>
                    <table style="width: 100%">
                        <tbody>
                            <tr><br>
                        <td id="ajustarTabela"><input name="evento"  value="evento" type="hidden"/> </td>
                        <td> 
                            <input name="<%=eventos.getIdEvento()%>" value="<%=eventos.getIdEvento()%>" type="hidden"/>     
                        </td>
                        <td style="width: 500.10px"class="select1" ><br></td>
                        </tr>

                        <tr><br>
                        <td id="ajustarTabela">Image:</td>
                        <td ><input type="file" name="file" class="select1" /></td>
                        <td style="width: 500.10px"class="select1" ><br></td>
                        </tr>

                        <tr>
                            <td> </td>
                            <td><input class="salvar" id=""  type="submit" value="Enviar" />|<input class="salvar" id=""  type="reset" value="Limpar" /></td>

                        </tr>
                        </tbody>
                    </table>
                </table>
                </table>
            </fieldset>
        </form>
    </body>
</html>
