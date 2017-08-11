<%-- 
    Document   : form
    Created on : 24/06/2017, 14:48:57
    Author     : Bruno Strano
--%>


<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tags" %>
<!DOCTYPE html>
<c:url value="/resources/css" var="cssPath" />
<tags:pageTemplate cssPath="${cssPath}" title="Cadastro Categoria">
    <h1>Cadastro de Categoria</h1>
    <c:url value="/transactions/categories" var="categories" />
    <form action="${categories}" method="POST" >
        <div>
            <label for="cat_name"> Nome: </label>
            <input type="text" name="cat_name"/>
        </div>
        <input type="submit" value="Submit"/>
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
    </form>
</tags:pageTemplate>
