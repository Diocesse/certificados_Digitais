<%--
    Document   : msg
    Created on : 08/05/2016, 18:37:47
    Author     : diocesse
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table style="width: 100%;" border="0" class="container">
    <tbody>
        <tr  class="br" id="br">
            <td colspan="5" class="br" id="br" style="width: 4%; color: black; font-size: 1cm;"><br></td>

            </td>


        </tr>
        <c:forEach var="p" items="${carrinho}">

            <tr >
                <td class="" style="width: 4%; color: red; font-size: 1cm;"><c:out value="${p.participante.cpf}"/> <br></td>
                <td style="width: 500.45px; font-size: 0.7cm;" class="msg"><c:out value="${p.participante.nome}"/><br>
                </td>
                <td style="width: 50px;">
                </td>
                <td style="width: 70px;"></td>

            </tr>

        </c:forEach>
        <c:if test="${empty carrinho}">
            <tr >
                <td colspan="5" style="width: 4%; color: black; font-size: 1cm;">Não existe resgistros</td>

                </td>

            </c:if>

    </tbody>
</table>
<form action="Controller" method="get" name="form">

    <table>
        <tr>
            <td class="msg2" style="text-align: right;"><input required="required"  value="DirecionarPageFinalizarCarrinho" type="hidden" name="operacao"/> </td>
        </tr>
        <tr>
            <td><input style="height: 3cm; color: white; font-size: 0.5cm; width: 10cm; background: red; border-radius: 0.2cm;" value="Gerar colecao" name="bt" type="submit"/> </td>
            <td><input style="height: 3cm; color: white; font-size: 0.5cm; background: blue; border-radius: 0.2cm;" value="Limpar lista de participantes" name="bt" type="submit"/> </td>
            <td><input style="height: 3cm; color: white; font-size: 0.5cm; background: blueviolet; border-radius: 0.2cm;" value="Cancelar" name="bt" type="submit"/> </td>

        </tr>
    </table>
</form>
</fieldset>