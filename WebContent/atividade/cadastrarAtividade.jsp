
<%@page import="edu.ifba.hibernate.entidade.CategoriaAtividade"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>

<html>

    <%@include file="../face.jsp" %>

    <body>
        <%@include file="../menu_restrito.jsp"  %>
        <%@include file="../divInicio.jsp" %>
        <form action="Controller" method="post" name="frm" >
            <c:if test="${not empty evento}">  <h3>Evento:${evento.descricao}</h3></c:if> 
                <fieldset class="container" id="" style="width: 90%;height: 100%;border-width: 1px; "><legend id="face"class="br">Cadastrar atividade:</legend>
                    <fieldset style="border-radius: 0.5cm; border-width: 1px;">
                        <h3><img height="60"width="60" src="images/logoIFBA.png" /> ASSOCIAR UMA ATIVIDADE A UM EVENTO:</h3>
                        <label class="corT" style="text-align: center">Obs. Todos os campos devem ser preenchido obrigatoriamente.</label>
                    </fieldset>
                    <fieldset style="border-radius: 0.5cm; border-width: 1px;">
                        <table border="0" style="width:100%; height: 80% " id="" >

                            <tbody>
                            <c:if test="${not empty eventos}">

                                <tr>
                                    <td id="ajustarTabela">Evento:</td>
                                    <td  style="text-align: left;"  colspan="3"><select name="txtEvento" class="select1"  style="width: 100%;">
                                            <c:forEach var="e" items="${eventos}">
                                                <option class="select1" value="${e.idEvento}"><c:out value="${e.descricao}"/></option>
                                            </c:forEach>
                                        </select>
                                    </td>

                                </tr>

                            </c:if>

                            <tr>

                                <c:if test="${not empty evento}">

                                    <td><input name="txtEvento" type="hidden" value="${evento.idEvento}"/></td>
                                    </c:if>
                            </tr>
                            <tr>
                                <td id="ajustarTabela"  >Descricão da atividade:</td>
                                <td style="text-align: left;" colspan="2"><input class="select1" name="txtDescricao" style="width: 100%; " /></td>
                                <td style="text-align: left;" colspan="2">
                                    <select name="txtCategoria"  style="width: 100%;" class="select1" >
                                        <c:if test="${not empty categorias}">
                                            <c:forEach var="c" items="${categorias}">
                                                <option class="select1" value="${c.idCatAtividade}">${c.descricao}</option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </td>
                                
                            </tr>
                            <tr>
                                <td id="ajustarTabela">Quantidade de vagas:</td>
                                <td  style="text-align: left;"><input maxlength="15"  style="width: 20%;" name="txtQtde" type="number" class="select1" /> </td>
                                <td></td>
                            </tr>
                            <tr>
                                <td id="ajustarTabela">Sala:</td>
                                <td style="text-align: left;"><input type="text" name="txtLocal"  style="width: 30%;" class="select1"/></td>
                                <td></td>
                            </tr>

                            <tr>
                                <td id="ajustarTabela">Data da Atividade:</td>
                                <td style="text-align: left;"><input type="date" placeholder="dd/MM/YYYY" name="txtDataAtiv" style="width: 40%;" class="select1"/></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td id="ajustarTabela">Horarios da atividade:</td>
                                <td style="text-align: left;"><input type="time"  placeholder="HH:mm:ss" name="txtHoraInicial" style="width: 40%;" class="select1"/>
                                <input type="time" name="txtHoraFinal" style="width: 40%;" placeholder="HH:mm:ss"  class="select1"/>
                                </td>
                                <td></td>
                            </tr>
                            
                            <tr><td><input type="hidden" name="codigo" value="0"/> <br></td></tr>
                            <tr>

                                <td><input type="hidden" value="DirecionarCadastrarAtividade" name="operacao"/> </td>
                                <td><input class="button" id=""  type="submit" value="Salvar" />|<input class="button" id=""  type="reset" value="Limpar" /></td>
                                <td></td>
                            </tr>
                        </tbody>
                    </table>

                </fieldset>
            </fieldset>
        </form>
    </body>
</html>
