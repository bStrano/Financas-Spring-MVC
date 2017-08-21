<%-- 
    Document   : home.jsp
    Created on : 23/06/2017, 17:57:46
    Author     : Bruno Strano
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE html>
<c:url value="/resources/css" var="cssPath" />

<html>
    <tags:pageTemplate title="Home" cssPath="${cssPath}">
        <security:authorize access="isAuthenticated()" >
            <security:authentication property="principal" var="user"/>
            <p>Usuário logado: ${user.user_name}</p>
            <p>Roles do usuário: ${user.user_roles}</p>
        </security:authorize>
        <a href="users/login">Fazer Login</a> <br/>
        <a href="transactions/form">Form</a>
        <a href="user/form">Form User</a>
        <br/>
        <a href="balances/form">Balance</a>
        <br/>
        <a href="balances">Lista Balances</a>
        <br/>
        <form action="transactions/info" method="GET">
            <label for="name">Nome:  </label>
            <input type="text" name="name" >
            <input type="submit" value="Buscar pelo Nome"/>
        </form>
        <a href="transactions/companies/form">Form Company</a><br/>
        <a href="transactions/categories/form">Form Category</a><br/>
        <h1>Spring MVC</h1>

        <p>${pageContext.request.contextPath}</p>
        <form:form action="${pageContext.request.contextPath}/homeLogout" method="POST">
            <input type="submit" value="Logout"/>
        </form:form>

    </tags:pageTemplate>
</html>