
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <%@include file="../face.jsp" %>

    <body>
        <%@include file="../menu_restrito.jsp"  %>
        <%@include file="../divInicio.jsp" %>

        <form name="formE" action="Controller" method="post">
            <fieldset class="container" id="" style="width: 90%; border-width: 1px; "><legend id="face"class="br">CADASTRAR:</legend>
                <table>
                    <fieldset class="br" style="border-width: 1px; ">
                    <h1><img height="60"width="60" src="images/logoIFBA.png" /> TODOS PARTICIPANTE INSCRITOS EM ATIVIDADES</h1>

                    </fieldset>
                    <table border="0" style="width:100% " id="" class="container">
                        <thead id="ajustarTabela">
                            <tr class="" id="facecorpo" >
                                <th colspan="40"><br></th>

                            </tr>
                        </thead>
                    </table>
                    <fieldset style="border-width: 1px; ">
                        <form>
                            <table style="font-size: xx-large; width: 100%;" >
                                <tr>
                                    <td class="corT">
                                        Buscar pelo atividade:
                                    </td>
                                    <td>
                                        <input name="" class="inp" value="" type="text" />
                                    </td>
                                    <td>
                                        <input name="btEnviar" class="salvar" value="Enviar" type="submit" />
                                    </td>

                                </tr>

                            </table>
                        </form>
                        <table style="font-size: xx-large; width: 100%;" >
                                <tr>
                                    <td style=" width: 100%;" class="corT">Atençao: Nao foi impresso todos os participantes, para vizualiazar bastar informar o nome da atividade o data para encontrar a informaçao desejada. </td>
                                </tr>
                            </table>
                    </fieldset>
                </table>
                <fieldset style="border-width: 1px; ">
                    <table style="width: 100%">
                        <thead>
                            <tr class="br" id="facecorpo">
                                <td colspan="50">Todos participantes inscritos em nas atividades.</td>
                            </tr>
                        </thead>
                        <tbody>

                            <c:if test="${participantesAtividades != null}">
                            <c:forEach var="a" items="${participantesAtividades}">
                            <tr class="tabela">
                                <td class=""><br> <img height="50" src="FileDownload?acao=participanteImage&id=${a.participante.idParticipante}" width="50" /> </td>
                                <td> <a href="#" class="a">Vizualizar inscrição do participante <c:out value="${a.participante.nome}"/> </a> <br></td>

                                <td style="width: 200px;"></td>
                            </tr>
                            </c:forEach>
                            </c:if>
                            <c:if test="${participantesAtividades == null}">
                                <tr>
                                    <td class="corT">Lista esta sem informaçoes...</td>
                                </tr>
                            </c:if>

                        </tbody>
                    </table>
                </fieldset>
                </table>
                </table>
            </fieldset>
        </form>
    </body>
</html>
