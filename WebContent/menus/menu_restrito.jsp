<%-- 
    Document   : menu
    Created on : 20/04/2016, 13:47:32
    Author     : diocesse
--%>

<%@page import="edu.ifba.hibernate.entidade.Administrador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    Administrador sessao = (Administrador) session.getAttribute("adm");
%>
<%
    if (sessao != null) {
%>
<div id="header-wrapper">

    <div id="header" class="container">
        <div id="logo">

            <img src="images/logoIFBAStoAmaro.png" width="100" height="131">
            <h1>
                <a href="#">AREA RESTRITA AO ADMINISTRADOR</a>
            </h1>

            <h2 style="text-align: center ;"><a href="#">PORTAL DE CERTIFICADOS DIGITAIS.</a></h2>
            <table style="width: 160%">
                <tr>
                    <td style="width: 500%">
                        
                        <a href="Controller?operacao=DirecionarPageLogout" id="facecorpo" class="br"
                           style="text-align:right; font: bold; font-size: 16px; color: blue; ">
                            
                            <img src="images/novo1.png" width="30" height="40" /> Logout:
                            <%=sessao.getNome()%>
                            
                        </a>
                            
                    </td>
                </tr>
            </table>

        </div>
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
                   accesskey="3" title="">Inscrições</a>
                <ul class="submenu1">
                    <li><a href="Controller?operacao=DirecionarConsultaInscricaoParticipante">Consultar</a></li>
                    <li><a href="Controller?operacao=DirecionarListaAtividades">Inscrever
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
                    <li><a href="Controller?operacao=DirecionarPageCadastroAdm">Criar</a>
                    </li>
                    <li><a href="Controller?operacao=DirecionarPageListaAdm">Exibir
                            impressos</a></li>
                    <li><a href="Controller?operacao=DirecionarPageLogout">Logout</a>

                    </li>

                </ul></li>
            <li></span><a href="#" accesskey="5" title="">Upload Image</a>
                <ul class="submenu1">


                    <li><a href="Controller?operacao=DirecionarPageListaUploadEventos">Eventos</a>
                    <li><a href="Controller?operacao=DirecionarPageLogout">Participante</a>

                    </li>

                </ul></li>


            </ul>
        </div>
    </div>

</div>
<!--Menu fim-->

<%
} else {
%>
<%
    String msg = "Autenticaçao e necessaria!";
%>
<%
    request.setAttribute("msg", msg);
%>
<jsp:forward page="../logar.jsp"></jsp:forward>
<%
    }
%>