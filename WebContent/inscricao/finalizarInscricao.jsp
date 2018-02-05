<%-- 
    Document   : cadastrarAtividade
    Created on : 05/05/2016, 11:48:32
    Author     : diocesse
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Date"%>
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
            <fieldset class="container" id="" style="width: 90%; font-family: ''; border: none "><legend id="face"class="br">Finalizar inscrição:</legend>
                <table>
                    <h1><img height="60"width="60" src="images/logoIFBA.png" />  FINALIZAR INSCRIÇÃO DO  PARTICIPANTE :</h1>
                    <label class="corT" style="text-align: center">Obs. Obrigado por ter escolhido esta atividade para o seu crescimento Acadêmico.</label>

                    <tr class="" id="" >
                        <th colspan="40"><br><h1>Participante: <c:out value="${participante.nome}"/> </h1></th>

                    </tr>


                    <c:if test="${not empty atividade}">          

                        <tbody>
                            <tr id="facecorpo"><br>
                        <td id="ajustarTabela">Evento:</td>
                        <td id="finalizar" ><c:out value="${atividade.evento.descricao}"/></td>
                        <td style="width: 500.10px"class="" ></td>
                        </tr>
                        <tr id="facecorpo">
                            <td id="ajustarTabela">Cidade:</td>
                            <td id="finalizar" ><c:out value="${atividade.evento.cidade}"/></td>
                        </tr>
                        <tr id="facecorpo">
                            <td id="ajustarTabela">Bairro:</td>
                            <td id="finalizar"><c:out value="${atividade.evento.bairro}"/> - <c:out value="${atividade.evento.endereco}"/></td>
                        </tr>
                        <tr id="facecorpo" >
                            <td id="ajustarTabela">Atividade:</td>
                            <td id="finalizar"><c:out value="${atividade.descricao}"/></td>
                            <td></td>
                        </tr>
                        <tr id="facecorpo">
                            <td id="ajustarTabela">Instituiçao:</td>
                            <td id="finalizar"><c:out value="${atividade.evento.localEvento}"/></td>
                            <td></td>
                        </tr>
                        <tr id="facecorpo"  >
                            <td id="ajustarTabela">Sala da atividade:</td>
                            <td id="finalizar"><c:out value="${atividade.local}"/></td>
                            <td></td>
                        </tr>

                        <tr id="facecorpo" >
                            <td id="ajustarTabela">Data da atividade:</td>
                            <td id="finalizar"><fmt:formatDate value="${atividade.dataAtividade}" pattern="dd/MM/yyyy"/></td>
                            <td></td>
                        </tr>
                        <tr id="facecorpo" >
                            <td id="ajustarTabela">Tera Inicio:</td>
                            <td id="finalizar"><fmt:formatDate value="${atividade.horaAtividadeInicio}" pattern="HH:mm:ss" /></td>
                            <td></td>
                        </tr>
                        <tr id="facecorpo">
                            <td id="ajustarTabela">Será Finalizada:</td>
                            <td id="finalizar"><fmt:formatDate value="${atividade.horaAtividadeFinal}" pattern="HH:mm:ss" /></td>
                            <td></td>
                        </tr >
                        <tr id="facecorpo">
                            <td id="ajustarTabela">Responsável:</td>
                            <td id="finalizar"></td>

                        </tr>


                        </tbody>

                    </c:if>

                    <tr><td><input name="participante" value="<c:out value="${participante.idParticipante}"/>" type="hidden"/>

                            <c:if test="${not empty atividade}">
                                <input name="atividade" value="<c:out value="${atividade.idAtividade}"/>" type="hidden"/>
                            </c:if>
                        </td>

                    </tr>
                    <tr>  
                        <c:if test="${empty atividade}">
                            <td>


                                <input name="atividade" value="-1" type="hidden"/>

                            </td>

                            <td class="msg2" style="text-align: center;">Nao existe atividade para ${participante.nome}.</td>
                        </c:if>
                        <td><input type="hidden" value="DirecionarFinalizarInscricaoParticipante" name="operacao"/></td>


                    </tr>

                    <tr >
                        <td style="text-align: center;" colspan="2"><input  name="btFinalizar" type="submit" value="Finalizar" />|<input name="btFinalizar" type="submit" value="Encerra" /></td>
                        <td></td>
                    </tr> 
                </table>
            </fieldset>
        </form>
    </body>
</html>
