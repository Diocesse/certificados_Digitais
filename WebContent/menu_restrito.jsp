<%-- 
    Document   : menu
    Created on : 20/04/2016, 13:47:32
    Author     : diocesse
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<c:if test="${adm != null }">
    
<div id="header-wrapper">

    <div id="header" class="container">
                  
               <table style="width: 100%; text-align: center;">
                   <tr>
                       <td> <br></td>
                   </tr>
                   <tr>
                       
                       <td><h2 class="h1s"  style="text-align: left">  Olá! Professor  <c:out value="${adm.nome}"/> seja bem vindo - [Area restrita ao Administrador] <a class="br- corT" id="" href="Controller?operacao=DirecionarPageLogout" style=" text-decoration: none;" class="corT"><img class="br" id="" src="images/volta.svg" width="17" height="17"/>  Logout </a>  </h2></td>
                       
                   </tr>
                   
                    
               </table>
              
               
        </div> -
        <div id="menu1">
            <ul class="menu1">
                <li class="active"></span> <a href="" accesskey="1" title="">Cadastrar</a>
                    <ul class="submenu1">
                        <li><a
                                href="Controller?operacao=DirecionarPageCadastroParticipante">Participante</a>
                        </li>
                        <li><a
                                href="Controller?operacao=DirecionarPageCadastroEvento">Evento</a>
                        </li>
                        <li><a href="Controller?operacao=DirecionarCadastroAtividade">Atividade</a>
                        </li>
                        <li><a
                                href="Controller?operacao=DirecionarPageCadastroCategoria">Categoria</a>
                        </li>                        
                         <li><a href="Controller?operacao=DirecionarPageCadastroAutor">Autor certificado</a></li>
                        <li><a href="Controller?operacao=DirecionarPageCadastroParticipacao">Participação</a>
                        </li>
                         <li><a href="Controller?operacao=DirecionarPageCadastroAdm">Administrador</a>
                        </li>
                    </ul></li>
                <li><a href="#" accesskey="2" title="">Pesquisar</a>
                    <ul class="submenu1">
                        <li><a
                                href="Controller?operacao=DirecionarInfoPesquisaParticipantes">Participantes</a>
                        </li>                       
                        <li><a href="Controller?operacao=DirecionarListaEventos">Eventos</a>
                        </li>
                        <li><a href="Controller?operacao=DirecionarListaAtividades">Atividades</a>
                        <li><a href="Controller?operacao=DirecionarPageListaCategoria">Categorias</a></li></li>
                <li><a href="Controller?operacao=DirecionarPageListaAdm">Administradores</a>
                </li>

            </ul>
            </li>

            <li><a href="Controller?operacao=DirecionarAutenticacaoSistema"
                   accesskey="3" title="">Participaçao</a>
                <ul class="submenu1">
                    <li><a href="Controller?operacao=DirecionarConsultaInscricaoParticipante">Criar</a></li>
                    <li><a href="Controller?operacao=DirecionarPageConsultarInscricoes">Consultar
                        </a>
                    <li><a
                            href="Controller?operacao=DirecionarPageCadastroCategoria">Atividades
                        </a></li>
                    <li><a
                            href="Controller?operacao=DirecionarPageListaCategoria">
                            Categorias</a></li></li>

            </ul>
            </li>
            <li><a href="Controller?operacao=DirecionarPageRelatoriosPDF" accesskey="4" title="">Relatorios</a>
                <ul class="submenu1">
                    <li><a
                            href="Controller?operacao=DirecionarPageRelatoriosPDF">PDF
                            </a></li>
                    <li><a href="Controller?operacao=DirecionarPageListaCategoria">Filtrar
                            categorias</a></li></li>

            </ul>
            </li>
            <li><a href="#" accesskey="5" title="">Certificados</a>
                <ul class="submenu1">
                    <li><a href="Controller?operacao=DirecionarPageCertificadoAutomatico">Criar</a>
                    </li>
                    <li><a href="Controller?operacao=DirecionarPageListaAdm">Exibir
                            impressos</a></li>
                    <li><a href="Controller?operacao=DirecionarPageLogout">Logout</a>

                    </li>

                </ul></li>
            <li></span><a href="#" accesskey="5" title="">Upload Image</a>
                <ul class="submenu1">


                    <li><a href="Controller?operacao=DirecionarPageListaUploadEventos">Eventos</a>
                    <li><a href="Controller?operacao=DirecionarPageUploadParticipante">Participante</a>

                    </li>

                </ul></li>


            </ul>
        </div>
    </div>

</div>
<!--Menu fim-->
</c:if>
<c:if test="${empty adm}">
    <c:redirect url="logar.jsp"></c:redirect>
</c:if>

