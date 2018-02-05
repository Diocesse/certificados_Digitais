<%-- 
    Document   : finalizarexclusao
    Created on : 04/05/2016, 08:43:21
    Author     : diocesse
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="edu.ifba.hibernate.entidade.Participante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <jsp:include page="../face.jsp"></jsp:include>
        <body>
        <jsp:include page="../menu_restrito.jsp"></jsp:include>
        <jsp:include page="../divInicio.jsp"></jsp:include>
        <h2 class="br" id="br">Finalizar exclusão do participante:  <c:out value="${participante.nome}"/></h2>
        <form action="Controller" method="get">   
            <table class="container">
                <tr class="br" id="br">
                    <td id="">
                        Id
                    </td>
                    <td id="" class="">
                        Nome 
                    </td>
                    <td id="">
                        Sexo 
                    </td>
                    <td id="">
                        E-mail 
                    </td>
                </tr>

                <tr id="facecorpo" class="">
                    <td id="corT" class="msg2" >
                       
                        <c:out value="${participante.idParticipante}"/>
                    </td>
                    <td id="corT"style="width: 400.45px;" >
                         <c:out value="${participante.nome}"/>
                        
                    </td>
                    <td id="corT" style="width: 299.45px;">
                         <c:out value="${participante.sexo}"/> 
                    </td>
                    <td id="corT">
                         <c:out value="${participante.email}"/>  
                    </td>
                    
                </tr>
                <tr>
                    <td>
                        <input name="txtExcluir" value="<c:out value="${participante.idParticipante}"/>" type="hidden"/>
                        <input name="operacao" value="DirecionarFinalizarExclusao" type="hidden"/>
                    </td>
                    <td>
                        <input name="btExclusao"  value="Finalizar" type="submit"class="button" />
                    </td>

                    <td>
                        <input name="btExclusao"  value="Cancelar" type="submit"class="button" />
                    </td>
                    <td>

                    </td>

                </tr>

            </table>


        </table>

    </form>



 <jsp:include page="../divFim.jsp"></jsp:include>

</body>
</html>
