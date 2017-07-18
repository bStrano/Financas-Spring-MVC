<%-- 
    Document   : form
    Created on : 24/06/2017, 08:47:25
    Author     : Bruno Strano
--%>

<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
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
        <h1>Hello World!</h1>

        <div></div>
        <spring:url value="/transactions" var="transactions"/>
        <form:form action="${transactions}" method="POST" commandName="transactionForm" enctype="multipart/form-data">
            <div>

                <label for="tra_name">Nome: </label>          
                <form:input path="tra_name" name="tra_name"/>
                <form:errors  path="tra_name"/>
            </div>


            <div>

                <div>

                </div>

                <div>
                    <form:select path="categoryIds" items="${listCategory}" itemLabel="cat_name" itemValue="cat_id" style="width: 100px;"/>
                    <form:errors path="categoryIds" />
                </div>

                <div>
                    <form:select path="company_id" items="${listCompany}" itemLabel="com_name" itemValue="com_id" style="width: 100px;"/>
                    <form:errors path="company_id" />
                </div>


            </div>
            <button type="submit">Cadastrar Transação</button>
        </form:form>
    </body>
</html>
