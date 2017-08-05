<%-- 
    Document   : home.jsp
    Created on : 23/06/2017, 17:57:46
    Author     : Bruno Strano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <security:authorize access="isAuthenticated()" >
            <security:authentication property="principal" var="user"/>
            <p>Usuário logado: ${user.user_name}</p>
            <p>Roles do usuário: ${user.user_roles}</p>
        </security:authorize>
        <a href="users/login">Fazer Login</a> <br/>
        <a href="transactions/form">Form</a>
        <br/>
        <form action="transactions/info" method="GET">
            <label for="name">Nome:  </label>
            <input type="text" name="name" >
            <input type="submit" value="Buscar pelo Nome"/>
        </form>
        <a href="transactions/companies/form">Form Company</a><br/>
        <a href="transactions/categories/form">Form Category</a><br/>
        <h1>MoneyEE</h1>
        <table>
            <tr>
                <td>Transacoes</td>
                <td>Teste</td>
            </tr>     
            <tr>
                <td>Transacoes 2 </td>
                <td>Teste</td>
            </tr>    
            <tr>
                <td>Transacoes 3</td>
                <td>Teste</td>
            </tr>
        </table>
        <p>${pageContext.request.contextPath}</p>
    <form:form action="${pageContext.request.contextPath}/homeLogout" method="POST">
        <input type="submit" value="Logout"/>
    </form:form>   
</body>
</html>
