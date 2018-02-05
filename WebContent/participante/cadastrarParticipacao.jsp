


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
                    <img height="60" width="60" src="images/logoIFBA.png" /> Informe o tipo de participaçao para
                    participante
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
                                    <td id="ajustarTabela" class="corT">Tipo:</td>
                                    <td><input size="70"  required="required" placeholder="Qual o tipo de participaçao para participante" value="<c:out value="${participante.nome}"/>"  name="tipo" 
                                               class="select1" type="text"><br></td>
                                    <td class="corT">*<c:if test="${erros[0] != null}">${erros[0]}</c:if> </td>

                                    </tr>

                                <tr>
                                    <td><input name="operacao" type="hidden"
                                               value="DirecionarCadastroParticipacao" /> <br></td>
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

