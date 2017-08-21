<%-- 
    Document   : form
    Created on : 18/07/2017, 08:24:09
    Author     : Bruno Strano
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tags" %>
<!DOCTYPE html>
<tags:pageTemplate title="Novo Saldo">
    <main>
        <h1>Balance Cadastro</h1>
        <c:url value="/balances/form" var="balances"/>
        <form:form action="${balances}" commandName="balance" cssClass="form form-horizontal" >
            <div class="form-group">
                <label for="bal_name">Nome: </label>
                <form:input path="bal_name" type="text" cssClass="form-control" />
            </div>

            <div class="form-group">
                <label for="bal_desc">Descrição: </label>
                <form:textarea cols="20" rows="10" path="bal_desc" cssClass="form-control" /> 
            </div>    
            <button class="btn btn-primary" value="submit">Cadastar</button>
        </form:form>


    </main>
</tags:pageTemplate>