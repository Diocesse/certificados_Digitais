
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <%@include file="../face.jsp" %>

    <body>
        <%@include file="../menu_restrito.jsp"  %>
        <%@include file="../divInicio.jsp" %>

        <form name="formE" action="Controller" method="post">
            <fieldset class="" id="" style="width: 100%; border-width: 0px; "><legend id=""class="msg2">Inscriçoes</legend>
                <table>
                    <fieldset  class="" style="text-align: left; border-width: 0px; height: 70px; " >
                        <h3 style="font-size: 1cm;"><img height="60"width="60" src="images/logoIFBA.png" /> Criar participaçao.</h3>
                    </fieldset>

                    <table border="0" style="width:100% " id="" class="container">
                        <thead id="ajustarTabela">
                            <tr class="" id="facecorpo" >
                                <th colspan="40"><br></th>

                            </tr>
                        </thead>
                    </table>
                    <fieldset style="border-width: 0px;">
                        <form method="post" action="Controller" >
                            <table>
                                <tr>
                                   
                                    <td>
                                        <input name="operacao"  value="DirecionarConsultaInscricaoParticipante" type="hidden" />
                                        <input name="busca" placeholder="Buscar participante para criar sua participação em uma atividade" value="" class="select1" size="70" type="text" />
                                    </td>
                                    <td>
                                        <input name="btEnviar" class="select1" s value="Buscar" type="submit" />
                                    </td>
                              
                                </tr>

                            </table>  
                        </form>
                    </fieldset>
                    <fieldset style="border-width: 0px; b">
                        <table style="width: 100%">

                            <tbody>
                                <tr class="br" id="br">
                                    <td class="br" colspan="1">  Id </td>
                                    <td class="br" colspan="2" style="text-align: center;">  Participante </td>
                                    
                                </tr>
                                <c:if test="${participantes != null}">
                                    <c:forEach var="a" items="${participantes}">
                                        <tr>
                                            <td class="msg2" id="br" colspan="1">   ${a.idParticipante}  </td>
                                            <td class="msg2" style="text-align: center;" colspan="2">   ${a.nome}  </td>
                                            <td class="msg2"><a class="a" href="<c:url value="Controller?operacao=DirecionarPageAtividadeParticipante&acao=${a.idParticipante}"/>"> <img class="br" id="br"  src="<c:url value="FileDownload?acao=participanteImage&id=${a.idParticipante}"></c:url>" width="50" height="50"  /></a></td>
                                            </tr>
                                    </c:forEach>
                                </c:if>

                            </tbody>
                        </table>
                    </fieldset>

                    <fieldset style="border-width: 0px; ">
                        <form>
                            <table style="font-size: xx-large; width: 100%;" >



                                <tr>
                                    
                                    <td>
                                        <input name="operacao"  value="DirecionarConsultaInscricaoParticipante" type="hidden" />

                                        <input name="buscar" placeholder="Buscar atividade para adicionar uma coleção de participantes" size="50" class="select1" value="" type="text" />
                                    </td>
                                    <td>
                                        <input name="btEnviar"  class="select1" value="Pesquisar" type="submit" />
                                    </td>

                                </tr>

                            </table>


                        </form>
                        
                    </fieldset>
                </table>
                <fieldset style="border-width: 0px; "> 
                    <table style="width: 100%">
                        <thead>

                        </thead>
                        <tbody>
                            <c:if test="${participantesAtividades != null}">
                                <tr class="br" id="br" >
                                            
                                            <td class="msg2" >Id</td>
                                            <td class="msg2" style="text-align: center;">Participante com atividades resgistradas </td>
                                            <td></td>
                                        </tr>
                                <c:forEach var="a" items="${participantesAtividades}">
                                    <c:if test="${not empty a}">
                                        <tr >
                                            <td class="br" id="br" colspan="0">${a.idAtividade} </td>
                                            <td class="msg2" id="" style="text-align: center;"><a href="<c:url value="Controller?operacao=DirecionarPageColecaoParticipantes&acao=${a.idAtividade}"/> " class="a"> <br> <img height="20" src="images/seta.jpg" alt="" width="20" class="br" id="br"  />
                                                    [<c:out value="${a.categoriaAtividade.descricao}"/>] - [<c:out value="${a.descricao}"/>]</a><br></td>
                                            <td></td>

                                        </tr>
                                    </c:if>
                                </c:forEach>
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
