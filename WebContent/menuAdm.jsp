<%-- 
    Document   : menu
    Created on : 20/04/2016, 13:47:32
    Author     : diocesse
--%>


<%@page import="java.util.Date"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<div id="header-wrapper">

    <div id="header" class="container">
        

        
        <table style="width: 100%; ">
            <tr>
                <td colspan="2" style="text-align: center; color: black;"><br></td>
            </tr>
            <tr>

                <td><img src="images/logoIFBAStoAmaro.png" width="70" height="70"/></td>
                <td> <h2 class="h1s"  style="text-align: left;">Instituto Federal de Educação, Ciência e Tecnologia. </h2></td>
            </tr>
             
      
        </table>


    </div> -
    <div id="menu1">
        <ul class="menu1">

            <li class="active">
                <a href="Controller?operacao=DirecionarPageIndex" accesskey="1" title="">Home</a>
                <ul class="submenu1">

                </ul>
            </li>
            <li>
                <a href="Controller?operacao=DirecionarPageExibirEventos" accesskey="2" title="">Eventos</a>
                <ul class="submenu1">

                </ul>
            </li>

            <li><a href="Controller?operacao=DirecionarAutenticacaoSistema"
                   accesskey="3" title="">Autenticação</a>
                <ul class="submenu1">

                </ul>
            </li>
            <li><a href="Controller?operacao=DirecionarPagePesquisa" accesskey="4" title="">Fotos</a>
                <ul class="submenu1">

                </ul>
            </li>
            
            <li></span><a href="Controller?operacao=DirecionarPageContato" accesskey="5" title="">Contato</a>
                <ul class="submenu1">


                </ul></li>


        </ul>
    </div>
</div>

</div>


