<%-- 
    Document   : pesquisaLogin
    Created on : 25/02/2021, 11:07:01
    Author     : Rennan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt"prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <table border="1">
            <thead>
                <tr>
                    <th>email</th>
                    <th>senha</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>rennandamiao</td>
                    <td>123</td>
                </tr>
                <c:forEach items="${Pessoas}" var="pessoa">
                <tr>
                    <td><c:out value="${pessoa.nome}"/></td>
                    <td><c:out value="${pessoa.login.senha}"/></td>
                </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>
