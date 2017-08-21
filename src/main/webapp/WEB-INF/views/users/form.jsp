<%-- 
    Document   : form
    Created on : 10/08/2017, 13:36:41
    Author     : Bruno Strano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tags"%>
<!DOCTYPE html>
<tags:pageTemplate title="Cadastro Usuário">
    <c:url value="/user/form" var="form" />
    <form:form action="${form}" method="POST" commandName="user" cssClass="form-horizontal">
        <div class="form-group">
            <label for="user_name">Nome: </label>
            <form:input  path="user_name" name="user_name" cssClass="form-control"/>
        </div>
        <div class="form-group">
            <label for="user_lastName">Sobrenome: </label>
            <form:input path="user_lastName" name="user_lastName" cssClass="form-control"/>
        </div>
        <div class="form-group">  
            <label for="username">Email: </label>
            <form:input type="email" path="user_email" name="user_email" class="form-control" placeholder="Email@email.com.br"/>
        </div>
        <div class="form-group">
            <label for="password">Senha: </label>
            <form:input type="password" path="user_password" name="user_password" class="form-control" placeholder="Senha"/>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Cadastrar</button>
       </div>
    </form:form>

</tags:pageTemplate>