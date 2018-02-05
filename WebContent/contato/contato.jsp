<%-- 
    Document   : contato
    Created on : 19/10/2016, 11:01:06
    Author     : diocesse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@include file="../face.jsp" %>
    <body>
        <%@include file="../menuAdm.jsp" %>
        <%@include file="../divInicio.jsp" %>
        <fieldset style="border-radius: 0.5cm; border-width: 0px; width: 100%;" class="container">

            <fieldset class="" style="border-width: 0px; border-radius: 0.4cm;">
                <table>
                    <tr class="br">
                        <td><img class="h1s" id="" src="images/logoIFBA.png" width="40" height="40" /></td>
                        <td><h2 style="color: white;"> Informações sobre o Portal de  Certificados Online.</h2></td>

                    </tr>

                </table>
            </fieldset>
            <div>
                <fieldset style="border-width: 0.0px; border-radius: 0.5cm; background: white ;">
                    <form action="Controller" name="form" method="post">
                        <table class="container" style="width: 100%;" >

                            <tr>
                                <td colspan="1" style="text-align: right;">
                                    <img height="170"  width="170" src="images/autor.jpg"/>

                                </td>
                                <td>
                                    <table class="column2" style="width: 200%;">
                                       <tr >
                                            <td colspan="1" class="msg2" style="text-align: right; color: red;">Instituição: </td>
                                            <td class="msg2" colspan="3" style="text-align: left;"> IFBA-UND Santo Amaro</td>

                                        </tr>
                                        <tr >
                                            <td colspan="1" class="msg2" style="text-align: right; color: red;">Densenvolvedor: </td>
                                            <td class="msg2" colspan="3" style="text-align: left;"> Leandro de Souza</td>

                                        </tr>
                                        <tr >
                                            <td colspan="1" class="msg2" style="text-align: right; color: red;">Orientador: </td>
                                            <td class="msg2" colspan="3" style="text-align: left;"> Leandro de Mirando</td>

                                        </tr>
                                        <tr >
                                            <td colspan="1" class="msg2" style="text-align: right; color: red;">Orientador: </td>
                                            <td class="msg2" colspan="3" style="text-align: left;"> Elvio</td>

                                        </tr>
                                        <tr >
                                            <td colspan="1" class="msg2" style="text-align: right; color: red;">Participação: </td>
                                            <td class="msg2" colspan="3" style="text-align: left;"> Adriano de Jesus</td>

                                        </tr>
                                        <tr >
                                            <td colspan="1" class="msg2" style="text-align: right; color: red;">Versão: </td>
                                            <td class="msg2" colspan="3" style="text-align: left;"> 1.0</td>

                                        </tr>
                                    </table>
                                </td>

                            </tr>


                            <tr>
                                <td colspan="3" style="background: #F3F3F3;"><h3>Tecnologias utilizdas para construção do Portal de Certificados Online.</h3></td>
                                <td colspan="3" style="background: #F3F3F3; text-align: justify;"><h3>IDE: Netbeans 8.0.2 - Hibernate JPA Eclipse - Linguaguagem para construção do portal Java - JTSL - JSP - Banco de dados Mysql - Ireport para geração de relatorios PDF.</h3></td>
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
