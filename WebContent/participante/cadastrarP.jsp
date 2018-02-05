


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<html>
    <jsp:include page="../face.jsp"></jsp:include>
        <body>

        <jsp:include page="../menu_restrito.jsp"></jsp:include>

        <jsp:include page="../divInicio.jsp"></jsp:include>

        <jsp:useBean id="dao" class="edu.ifba.hibernate.bean.BeanTipoParticipante"/>
        <fieldset class="container" style="width: 80%; height: 87%; border-radius: 0.5cm; border-width: 0px; border: 0px;">
            <legend class="br- corT">Dados pessoais:</legend>
            <fieldset style="border-radius: 0.0cm;width: 90%;border: 0px;">
                <h1>
                    <img height="60" width="60" src="images/logoIFBA.png" /> CADASTRAR
                    PARTICIPANTE
                </h1>
                <h3 class="corT" style="background: yellow;">As informações devem ser preenchida
                    obrigatoriamente.</h3>
            </fieldset>
            <fieldset style="border-radius: 0.0cm; width: 90%; height: 75%;border: 0px;">
                <form action="Controller" name="cadastrar" method="post">

                    <table border="0" style="width: 100%; " class="container">

                        <table>

                            <tbody>
                                <tr>
                                    <td id="ajustarTabela" class="corT">Nome:</td>
                                    <td><input size="70" maxlength="30" required="required" placeholder="Nome completo" value="<c:out value="${participante.nome}"/>"  name="txtNome" 
                                               class="select1" type="text"><br></td>
                                    <td class="corT">*<c:if test="${erros[0] != null}">${erros[0]}</c:if> </td>

                                    </tr>

                                    <tr>
                                        <td id="ajustarTabela" class="corT">Sexo:</td>
                                        <td><input size="30" style="width: 30%;" required="required" placeholder="Sexo"  value="<c:out value="${participante.sexo}"/>" name="txtSexo"  class="select1"
                                               type="text"><br></td>
                                    <td class="corT">* <c:if test="${erros[1] != null}">${erros[1]}</c:if><br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="ajustarTabela" class="corT">Data Nascimento:</td>
                                        <td><input size="10" style="width: 30%;" required="required"   value="<fmt:formatDate value="${participante.dataNascimento}" pattern="dd/MM/yyyy"/> " name="txtDataNascimento" class="select1"   type="date"><br></td>
                                    <td class="corT">* <c:if test="${erros[2] != null}">${erros[2]}</c:if><br>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td id="ajustarTabela" class="corT">CPF:</td>
                                        <td><input size="30" style="width: 40%;" placeholder="CPF -> 111.111.111-11"  name="txtCPF"  value="<c:out value="${participante.cpf}"/>" required="required" class="select1" 
                                               type="text"><br></td>
                                    <td class="corT">* <c:if test="${erros[3] != null}">${erros[3]}</c:if><br>
                                        </td>
                                    </tr>

                                    <tr>
                                        <td id="ajustarTabela" class="corT">E-mail:</td>
                                        <td><input size="30" placeholder="Email: nome@tipo.com"  style="width: 50%;" required="required" value="<c:out value="${participante.email}"/>"  name="txtEmail" class="select1"
                                               type="text"><br></td>
                                    <td class="corT">* <c:if test="${erros[4] != null}">${erros[4]}</c:if> <br>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td id="ajustarTabela" class="corT"> Confirma E-mail:</td>
                                        <td><input size="30" placeholder="Email: nome@tipo.com" style="width: 50%;" name="txtConfirmaEmail"  value="<c:out value="${participante.email}"/>" required="required" class="select1"
                                               type="text"><br></td>
                                    <td class="corT">* <c:if test="${erros[5] != null}">${erros[5]}</c:if><br>
                                        </td>
                                    </tr>
                                    
                                    <tr>
                                        <td class="corT" id="ajustarTabela">Participação:  </td>
                                        <td>
                                            <select name="idTipo"  style="width: 100%;" style="font-size: 18px; " class="select1"> 
                                            <c:forEach var="tp" items="${dao.tipoParticipantes}">
                                                <option value="${tp.idTP}" class="select1">${tp.tipo}</option>

                                            </c:forEach>

                                        </select> </td> 
                                </tr>

                                <tr>
                                    <td><input name="operacao" type="hidden"
                                               value="DirecionarCadastroParticipante" /> <br></td>
                                    <td><input value="Enviar" class="button"
                                               name="btCadastrar"  style="font-size: 0.4cm;" type="submit">|<input
                                               value="Limpar dados" class="button" style="font-size: 0.4cm;" name="btCadastrar"
                                               type="reset"> <br></td>
                                    <td><br></td>
                                </tr>
                                <tr>
                                    <c:if test="${not empty participante}"><td><input name="codigo" value="<c:out value="${participante.idParticipante}"/>" type="hidden" /> <br></c:if>
                                    
                                        <c:if test="${empty participante}"> <td><input name="codigo" value="0" type="hidden" /> <br></c:if>
                                       
                                        </td>
                                        <td><br></td>
                                        <td><br></td>
                                    </tr>
                                </tbody>
                            </table>
                        </table>

                    </form>


                    <p>
                        <br>
                    </p>
                </fieldset>
            </fieldset>

        <jsp:include page="../divFim.jsp"></jsp:include>

    </body>
</html>

