<%-- 
Document   : cadastrarAtividade
Created on : 05/05/2016, 11:48:32
Author     : diocesse
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <%@include file="../face.jsp" %>

    <body>
        <%@include file="../menu_restrito.jsp"  %>
        <%@include file="../divInicio.jsp" %>
        <%@include file="../validacoes/validarForm.jsp" %>
        <fieldset style="border-radius: 0.5cm; border-width: 0px; width: 88%;" class="container">

            <fieldset class="" style="border-width: 1px; border-radius: 0.4cm;">
                <table>
                    <tr>
                        <td><img class="h1s" id="" src="<c:url  value="images/logoIFBA.png"/> " width="40" height="40" /></td>
                        <td><h1> Formulario para cadastro e atualização evento.</h1></td>

                    </tr>
                    <tr >
                        <td colspan="3" class="msg2" style=" color: red; background: yellow; text-align: center; font-style: italic;">Todos os compos devem ser preenchido obrigatorimente.</td>
                    </tr>
                </table>
            </fieldset>
            <div>
                <fieldset style="border-width: 0.1px;  border-radius: 0.5cm; background: white ;">

                    <form name="cadastro" action="Controller" method="post" onsubmit="return validarFormEvento()">

                        <table style="width: 140%;">
                            <tbody >

                                <tr class=""><br>
                            <td id="ajustarTabela" class="">Nome:</td>
                            <td ><input type="text" size="60" name="txtDescricao" value="<c:out value="${evento.descricao}"/>"  placeholder="Nome do evento" required="required" class="select1" /></td>
                            <td  style="text-align: left; color: black;"><input maxlength="15" size="30" style="width: 50%; text-align: center;text-transform: uppercase;"  value="<c:out value="${evento.sigla}"/>" name="txtSigla" type="text" placeholder="Sigla"  required="required" class="select1" /> </td>
                               
                            <td style="width: 500.10px"class="" ><br></td>
                            </tr>
                          
                            <tr>
                                <td id="ajustarTabela">Instituiçao:</td>
                                <td style="text-align: left;"><input type="text" placeholder="Informe o nome da Intituição" size="60" name="txtLocalEvento" style="width: 100%;" value="<c:out value="${evento.localEvento}"/>" required="required" class="select1"/></td>
                                <td>*</td>
                            </tr>
                            <tr>
                                <td id="ajustarTabela">Estado:</td>
                                <td style="text-align: left;"><input type="text" maxlength="3"  placeholder="Estado" style="width: 30%;" value="<c:out value="${evento.estado}"/>" name="txtEstado" size="30" required="required" class="select1"/></td>
                                <td>*</td>
                            </tr>

                            <tr>
                                <td id="ajustarTabela">Cidade:</td>
                                <td style="text-align: left;"><input type="text" placeholder="Cidade" style="width: 60%;" name="txtCidade" size="60" value="<c:out value="${evento.cidade}"/>" required="required" class="select1"/></td>
                                <td>*</td>
                            </tr><tr>
                                <td id="ajustarTabela">Endereço:</td>
                                <td style="text-align: left;"><input type="text" style="width: 90%;" placeholder="Endereço" name="txtEndereco" value="<c:out value="${evento.endereco}"/>" required="required" size="60" class="select1"/></td>
                                <td></td>
                            </tr>
                            <tr>
                                <td id="ajustarTabela">Bairro:</td>
                                <td style="text-align: left;"><input type="text" placeholder="Bairro" value="<c:out value="${evento.bairro}"/>"  style="width: 40%;" name="txtBairro" size="60" required="required"  class="select1"/></td>
                                <td class="corT">*</td>
                            </tr>
                            <tr>
                                <td id="ajustarTabela">Datas:</td>
                                <td  style="text-align: left;">
                                    <input type="date"style="width: 40%;" placeholder="Data Inicio" value="<fmt:formatDate value="${evento.dataEvento}" pattern="dd/MM/yyyy"/>" name="txtDataEvento" size="30" required="required"  class="select1"/>
                                    <input type="date"style="width: 40%;" placeholder="Data Fim" value="<fmt:formatDate value="${evento.dataFim}" pattern="dd/MM/yyyy"/>" name="txtDataFim" size="30" required="required"  class="select1"/>
                                  
                                </td>
                                
                                <td></td>
                            </tr>
                            <tr>
                                <td id="ajustarTabela" style="text-align: right;" >Hora:</td>
                                <td style="text-align: left;"><input  type="time" style="width: 40%;" placeholder="Hora HH:mm:ss" value="<fmt:formatDate value="${evento.horaEvento}" pattern="HH:mm:ss"/>" name="txtHoraEvento" size="30" required="required" class="select1"/></td>
                            </tr>
                            
                            <tr> <td><input type="hidden" value="DirecionarCadastroEvento" name="operacao"/></td></tr>
                            <tr >

                                <td colspan="2"><input class="button" id=""  type="submit" value="Enviar" />|<input class="button" id=""  type="reset" value="Limpar" /></td>

                            </tr>

                            <c:if test="${evento == null}">
                                <td><input name="codigo" type="hidden" value="0" /></td>
                                </c:if> 
                                <c:if test="${evento != null}">
                                <td><input name="codigo" value="<c:out value="${evento.idEvento}"/>" type="hidden" /></td>
                                </c:if>
                            </tr>
                            </tbody>
                        </table>

                    </form>
                </fieldset>

            </div>

        </fieldset>
    </body>
</html>
