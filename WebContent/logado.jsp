<%-- 
    Document   : logado
    Created on : 18/10/2016, 11:50:40
    Author     : diocesse
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<c:if test="${not empty adm}"><a href="Controller?operacao=DirecionarPageLogout" class="br- a" id="br"><img   src="images/ida.svg" width="17" height="17" alt="Logout"/><label> Ola! [${adm.login}] seja bem vindo </label> Logout </a> </c:if>
