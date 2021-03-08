<%-- 
    Document   : pesquisaContrato
    Created on : 28/02/2021, 14:18:02
    Author     : vinic
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"prefix="fmt" %>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="icon" href="./css/img/Fav icon.svg" type="image/svg" />
        <link rel='stylesheet' href='./css/utilities/bootstrap.css'>
        <link rel="stylesheet" href="./css/main.css">
    </head>
    <body>

        <!--Menu opções-->


        <!---->
        <div class="container conteudo">
            <div class="row">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Email</th>
                            <th scope="col">Senha</th>
                            <th colspan="2" scope="col">acoes</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${Contratos}" var="contrato">
                            <tr>
                                <th scope="row"><c:out value="${contrato.id}"/></th>
                                <td>oi</td>
                                <td>oi</td>
                                <td><button>editar</button></td>
                                <td><button>excluir</button></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <button>Add novo login</button>
            </div></div>
        
        <script src='./js/utilities/bootstrap.js'></script>
        <script src='./js/utilities/jquery-3.5.1.js'></script>
        <script src='./js/main.js'></script>
    </body>
</html>
