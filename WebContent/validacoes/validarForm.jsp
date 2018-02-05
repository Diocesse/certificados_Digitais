<%-- 
    Document   : validarForm
    Created on : 09/05/2016, 14:59:22
    Author     : diocesse
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<script language="javascript">

    function validarFormEvento() {
        var info = document.cadastro;
        if (info.txtDescricao.value == "" || !isNaN(parseInt(tit.txtDescricao.value))) {

            alert("Nome da descrição invalido");

            info.reset();
            info.txtDescricao.focus();

            return false;
        } 

            return true;
        
    }


</script>

