<%-- 
    Document   : participante_img
    Created on : 08/09/2016, 16:13:49
    Author     : diocesse
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inserir image do participante</title>
    </head>
    <body>
        <h1>Ola! <c:out value="${participante.nome}"/> </h1>
        <p>Será carregado uma imagem em seu perfil</p>
        <form action="FileUploadServer" method="post" enctype="multipart/form-data" >
        <table>
            <tr>
                <td><input name="participante" value="participante" type="hidden"/> </td>
                <td><input  name="codigo" value="${participante.idParticipante}" type="hidden"/></td>
                <td><input type="file" name="file" /></td>
                <td><input value="Carregar imagem" name="btSave" type="submit"/></td>
            </tr>
            <tr>
                
                <td> </td>
               
                <td></td>
            </tr>
            
        </table>
        </form>
    </body>
</html>
