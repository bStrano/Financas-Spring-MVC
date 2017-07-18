<%-- 
    Document   : form
    Created on : 15/07/2017, 22:25:43
    Author     : Bruno Strano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Company</h1>
        <form action="/MoneySpring-1.0/transactions/companies"  method="POST">
            <div>
                <label for="com_name">Nome: </label>
                <input type="text" path="com_name" name="com_name"/>
            </div>
             <button type="submit">Cadastrar Transação</button>
        </form>
    </body>
</html>
