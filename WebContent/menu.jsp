<%-- 
    Document   : menu
    Created on : 20/04/2016, 13:47:32
    Author     : diocesse
--%>

<%@page import="edu.ifba.hibernate.entidade.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<div id="header-wrapper">
    <div id="header" class="container">
        <div id="logo">

            <img src="images/logoIFBAStoAmaro.png" width="70" height="100">
            <h1><a href="index.jsp">PORTAL DE CERTIFICADOS DIGITAIS</a></h1>
        </div>
        <div id="menu">
            <ul>
                <li class="active"><a href="index.jsp" accesskey="1" title="">Paginal principal</a></li>
               <!-- <li><a href="Controller?operacao=DirecionarPageCertificado" accesskey="2" title="">GERAR CERTIFICADOS</a></li>-->
                <li><a href="Controller?operacao=DirecionarAutenticacaoSistema" accesskey="3" title="">AUTENTICAÇÃO</a></li>
                <li><a href="#" accesskey="4" title="">FOTOS</a></li>
                <li><a href="#" accesskey="5" title="">EVENTOS</a></li>
                 <li><a href="#" accesskey="5" title="">SOBRE NÓS</a></li>
                  <li><a href="#" accesskey="5" title="">CONTATO</a></li>
            </ul>
        </div>
    </div>
</div> <!--Menu fim-->

