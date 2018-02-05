<%-- 
    Document   : adicionar_atividade_participante
    Created on : 05/05/2016, 00:18:57
    Author     : diocesse
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<c:if test="${not empty adm}">
<html>
    <jsp:include page="../face.jsp" />
    <body>
        <jsp:include page="../menu_restrito.jsp" />
        <%@include file="../divInicio.jsp" %>
       <c:if test="${not empty participante}"> 
                        <h1 style="text-align: center; font-size: 50px; color: green;"> OLA!<c:out value="${participante.nome}"/> </h1>
                    </c:if>
        <fieldset  class="container" style="width: 90%; border-width: 1px; "><legend id="br"></legend>
            <form method="get" action="Controller" id="formP" name="formulario" >

                <fieldset style="border-width: 1px; ">
                    
                    <c:if test="${atividades != null}">    
                    
                    <table style="width:100%;">
                        <tr class="br" id="facecorpo">
                            <td colspan="6"></td>
                        </tr>   
                        <table style="width: 70%">     
                            <tr class="" id="facecorpo">
                                <td><label class="">OBS. O participante só poderá escolher uma unica atividade em derterminado horario.</label></td>
                            </tr>

                        </table>
                    </table>
                </fieldset>
                <fieldset  class="container" style="width: 97%; border-width: 1px; ">
                    <table class="container" style="width: 100%;">
                        <c:if test="${ not empty atividades  && not empty eventos }"> 
                  
                        <c:forEach var="e" items="${eventos}">
                        <tr>

                            <td style="width: 100%">
                                <label class="msg2">EVENTO: <c:out value="${e.descricao}"/> </label>
                                <table>
                                    <c:forEach var="a" items="${atividades}">
                                   
                                    
                                    <c:if test="${e.idEvento == a.evento.idEvento}">
                                    <tr>
                                        <td><input type="radio"  title="Menu" name="txtRadio" class="br" value="<c:out value="${a.idAtividade}"/>" /> </td>
                                        <td><select name="" style=" background: white; color: green; border: 0px; border-width: 0px; width: 100%;  font-family: '';" required="required"> 
                                                <option style="border-width: 0px;  width: 100cm; font-family: '';" value="<c:out value="${a.idAtividade}"/>"><c:out value="${a.descricao}"/>-[<c:out value="${a.categoriaAtividade.descricao}"/>]</option>
                                            </select> 
                                        </td> 
                                      </tr>
                                  
                                    </c:if>
                                    </c:forEach>
                                      <tr>
                                          <td><input type="radio"  title="Menu" name="txtRadio" class="br"  style="height: 2cm;" value="-1" /> </td>
                                        <td><select name="" style="background: whitesmoke; color: green;  border: 0px; font-family: ''; border-width: 0px;" > 
                                                <option style="border-width: 0px;  width: 100cm; border: 0px;  " value="-1">Nenhuma atividade</option>
                                            </select> 
                                        </td> 
                                      </tr>
                                </table>
                            </td>
                        </tr>
                        </c:forEach>
                        </c:if>

                        <br>

                    </table>
                </fieldset>
                </table>
                <fieldset  class="container" style="width: 97%; border-width: 1px; ">
                    <table>
                        <tr>
                            <td><input name="operacao" value="DirecionarPageFinalizarInscricao" type="hidden"/></td>
                            <td class=""><input name="participante" value="${participante.idParticipante}" type="hidden"/> </td>
                            <td class=""><input name="btAvancar" value="Avançar" type="submit" id="" class="salvar"/>|<input name="btVoltar" value="Voltar" type="submit" id="" class="salvar"/> </td>

                        </tr> 
                    </table> 
                </fieldset>
            </form>
                       
           
            </c:if>
            
            <c:if test="${empty participante}">
                <h1>Participante nao encontrado...</h1>
            </c:if>
            
        </fieldset>


        <jsp:include page="../divFim.jsp" />

    </body>
</html>
</c:if>
<c:if test="${empty adm}">
    <c:redirect url="/logar.jsp"></c:redirect>
</c:if>
