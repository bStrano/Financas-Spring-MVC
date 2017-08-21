<%-- 
    Document   : list
    Created on : 17/08/2017, 16:02:34
    Author     : Bruno Strano
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Balances</h1>
        <c:forEach items="${listBalance}" var="bal" >
            <table>
                <thead>
                    <tr>
                        <td>Nome</td>
                        <td>Descrição</td>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>${bal.bal_name}</td>
                        <td>${bal.bal_desc}</td>
                    </tr>
                </tbody>
            </table>
            
        </c:forEach>
    </body>
</html>
