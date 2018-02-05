<%-- 
    Document   : exibireventos
    Created on : 17/09/2016, 00:08:22
    Author     : diocesse
--%>

<%@page import="edu.ifba.hibernate.dataFormatar.FormatarData"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../face.jsp" %>
    <body>
        <%@include file="../menuAdm.jsp" %>
        <%@include file="../divInicio.jsp" %>
       <fieldset style="border-radius: 0.5cm; border-width: 0px; width: 100%;" class="container">

            <fieldset  style="border-width: 0px; border-radius: 0.4cm;">
                <table >
                    <tr style="border-radius: 0.5cm;" >
                        <td><img class="h1s"  id="" src="images/logoIFBA.png" width="40" height="40" /></td>
                        <td><h2 style="color: red;"> Eventos que ocorreram na Instituição.</h2></td>

                    </tr>

                </table>
            </fieldset>
            <div>
                <fieldset style="border-width: 0.0px; border-radius: 0.5cm; background: white ;">
                    <form action="Controller" name="form" method="post">
                        <table class="container" style="width: 100%;" >
                            <c:forEach var="e" items="${eventos}">
                            <tr>
                                <td colspan="1" style="text-align: right;">
                                    <img height="230"   width="300" src="FileDownload?acao=eventoImage&id=${e.getIdEvento()}"/>

                                </td>
                                <td>
                                    <table  style="width: 100%;">
                                       <tr >
                                            <td colspan="1" class="msg2" style="text-align: right;  color: red;">Nome evento: </td>
                                            <td class="msg2" colspan="3" style="text-align: left; text-transform: none;"> ${e.descricao}</td>

                                        </tr>
                                        <tr >
                                            <td colspan="1" class="msg2" style="text-align: right; color: red;">Instituição: </td>
                                            <td class="msg2" colspan="3" style="text-align: left;"> ${e.localEvento}</td>

                                        </tr>
                                        
                                        <tr >
                                            <td colspan="1" class="msg2" style="text-align: right; color: red;">Data do evento: </td>
                                            <td class="msg2" colspan="3" style="text-align: left;"> <fmt:formatDate value="${e.dataEvento}" pattern="dd/MM/yyyy"/></td>

                                        </tr>
                                        <tr >
                                            <td colspan="1" class="msg2" style="text-align: right; color: red;">Hora do evento: </td>
                                            <td class="msg2" colspan="3" style="text-align: left;"> <fmt:formatDate value="${e.horaEvento}" pattern="HH:mm:ss"/></td>

                                        </tr>
                                        <tr >
                                            <td colspan="1" class="msg2" style="text-align: right; color: red;">Ativo: </td>
                                            <td class="msg2" colspan="3" style="text-align: left;"> sim</td>

                                        </tr>
                                        <tr >
                                            <td colspan="1" class="msg2" style="text-align: right; color: red;">Versão: </td>
                                            <td class="msg2" colspan="3" style="text-align: left;"> 1.0</td>

                                        </tr>
                                        <tr class="br" id="br"><td colspan="2"></td></tr>
                                    </table>
                                </td>

                            </tr>
                            
                            </c:forEach>

                            <tr>
                                <td colspan="3" style="background: #F3F3F3;"><h3>Pesquisar eventos que estão cadastrados no Portal de Certificados Online.</h3></td>
                                <td colspan="3" style="background: #F3F3F3; text-align: justify;"><h3>.</h3></td>
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
