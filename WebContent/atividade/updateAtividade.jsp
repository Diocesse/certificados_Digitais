<%-- 
    Document   : cadastrarAtividade
    Created on : 05/05/2016, 11:48:32
    Author     : diocesse
--%>

<%@page import="edu.ifba.hibernate.dataFormatar.FormatarData"%>
<%@page import="edu.ifba.hibernate.entidade.Atividade"%>
<%@page import="edu.ifba.hibernate.entidade.CategoriaAtividade"%>
<%@page import="java.util.List"%>
<%@page import="edu.ifba.hibernate.entidade.Evento"%>
<!DOCTYPE html>

<html>
    
    <%@include file="../face.jsp" %>
    <%Evento evento = (Evento) request.getAttribute("evento"); %>
    <%
        List<CategoriaAtividade> lista = (List<CategoriaAtividade>) request.getAttribute("categorias");
    %>
    <%
        List<Evento> listaE = (List<Evento>) request.getAttribute("eventos");
    %>
    <%Atividade ativ = (Atividade) request.getAttribute("atividade");%>
    <%if (session != null ){%>
    <body>
        <%@include file="../menu_restrito.jsp"  %>
        <%@include file="../divInicio.jsp" %>
        <form action="Controller" method="post" name="frm"style="height: 80% "  >
            <%if (evento != null) {%> <h1 class="h1s">Evento:<%=evento.getDescricao()%></h1> <%}%>
            <fieldset class="container" id="" style="width: 90%;height: 100%;border-width: 1px; "><legend id="face"class="br">Cadastrar atividade:</legend>
                <h1><img height="60"width="60" src="images/logoIFBA.png" /> ASSOCIAR UMA ATIVIDADE A UM EVENTO:</h1>
                <label class="corT" style="text-align: center">Obs. Todos os campos devem ser preenchido obrigatoriamente.</label>
                <table border="0" style="width:100%; height: 80% " id="" class="container">
                    <thead id="ajustarTabela">
                        <tr class="br" id="facecorpo" >
                            <th colspan="5">Atualizar atividade</th>

                        </tr>
                    </thead>
                    <tbody>

                        <%if (listaE != null) {%>
                        <tr>
                            <td id="ajustarTabela">Escolha o evento:</td>
                            <td ><select name="txtEvento" class="select1" style="width: 150%;">
                                    <option value="<%=ativ.getEvento().getIdEvento()%>"><%=ativ.getEvento().getDescricao()%></option>
                                    <%if (lista != null) {%>
                                    <%for (Evento e : listaE) {%>
                                    <option class="select1" value="<%=e.getIdEvento()%>"><%=e.getDescricao()%></option>
                                    <%}%>
                                    <%}%>
                                </select>
                            </td>
                            <td> </td>
                        </tr>
                        <%}%>
                        <tr>
                            <td id="ajustarTabela">Descricão da atividade:</td>
                            <td ><input class="select1" value="<%=ativ.getDescricao()%>" style="width: 150%;" name="txtDescricao" /></td>
                            <td style="width: 300.10px" ><br></td>
                        </tr>
                        <tr>
                            <td id="ajustarTabela">Escolha a Categoria:</td>
                            <td ><select name="txtCategoria" class="select1" style="width: 50%;">
                                    <option value="<%=ativ.getCategoriaAtividade().getIdCatAtividade()%>"><%=ativ.getCategoriaAtividade().getDescricao()%></option>
                                    <%if (lista != null) {%>
                                    <%for (CategoriaAtividade e : lista) {%>
                                    <option class="select1" value="<%=e.getIdCatAtividade()%>"><%=e.getDescricao()%>  </option>
                                    <%}%>
                                    <%}%>
                                </select>
                            </td>
                            <%if (evento != null) {%>
                            <td><input name="txtEvento" type="hidden" value="<%=evento.getIdEvento()%>"/></td>

                            <%}%>

                        </tr>
                        <tr>
                            <td id="ajustarTabela">Quantidade de vagas:</td>
                            <td style="text-align: left;"><input maxlength="15"value="<%=ativ.getQuantidade()%>" style="width: 20%;"  name="txtQtde" type="number" class="select1" /> </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td id="ajustarTabela">Sala:</td>
                            <td style="text-align: left;"><input type="text" value="<%=ativ.getLocal()%>" style="width: 50%;" name="txtLocal" class="select1"/></td>
                            <td></td>
                        </tr>

                        <tr>
                            <td id="ajustarTabela">Data da Atividade:</td>
                            <td style="text-align: left;"><input type="date" style="width: 40%;" name="txtDataAtiv"value="<%=FormatarData.ddMMyyyyVisao(ativ.getDataAtividade())%>"   class="select1"/></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td id="ajustarTabela">Hora Inicial e Final:</td>
                            <td style="text-align: left;"><input type="time" style="width: 40%;" value="<%=FormatarData.hhMMVisao(ativ.getHoraAtividadeInicio())%>"  name="txtHoraInicial" class="select1"/>
                            <input type="time" style="width: 40%;" value="<%=FormatarData.hhMMVisao(ativ.getHoraAtividadeFinal())%>" name="txtHoraFinal"  class="select1"/>
                            </td>
                            <td></td>
                        </tr>
                        
                        <tr><td><input name="codigo" value="<%=ativ.getIdAtividade()%>" type="hidden"/> <br></td></tr>
                        <tr>

                            <td><input type="hidden" value="DirecionarCadastrarAtividade" name="operacao"/> </td>
                            <td><input class="button" id=""  type="submit" value="Salvar" />|<input class="button" id=""  type="reset" value="Limpar" /></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>


            </fieldset>
        </form>
    </body>
    
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

</html>
