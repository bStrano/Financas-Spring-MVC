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
        <form:form action="${pageContext.request.contextPath}/homeLogout" method="POST">
           <input type="submit" value="Logout"/>
        </form:form>   
        <div></div>
        <spring:url value="/transactions" var="transactions"/>
        <form:form action="${transactions}" method="POST" commandName="transactionForm" enctype="multipart/form-data">
            <div>

                <label for="tra_name">Nome: </label>          
                <form:input path="tra_name" name="tra_name"/>
                <form:errors  path="tra_name"/>
            </div>
            <div>
                <label for="tra_desc">Descrição:</label>  
                <form:textarea cols="20" rows="10" path="tra_desc" name="tra_desc"/>
                <form:errors path="tra_desc" />
            </div>
            <div>
                <label for="tra_value">Valor: </label>    
                <form:input path="tra_value" name="tra_value"/>
                <form:errors path="tra_value" />
            </div>
            <div>
                <label for="tra_date">Data da Transação: </label>
                <form:input path="tra_date" type="date" name="tra_date"/>
                <form:errors path="tra_date" />
            </div>

            <div>
                <label for="tra_typeTransaction">Tipo: </label>
                <form:radiobutton path="tra_typeTransaction" name="typeTransaction" value="ENTRADA"/>Entrada
                <form:radiobutton path="tra_typeTransaction" name="typeTransaction" value="SAIDA" />Saida

            </div>

            <div>
                <label for="tra_invoice">Nota Fiscal: </label>
                <input type="file" name="invoice"/>
            </div>

            <div>
                <form:select itemValue="cat_id" itemLabel="cat_name" items="${listCategory}" path="category_id"/>   
                <form:errors path="category_id" />
            </div>

            <div>
                <form:select path="company_id" items="${listCompany}" itemLabel="com_name" itemValue="com_id" style="width: 100px;"/>
                <form:errors path="company_id" />
            </div>

            <div>
                <%-- 
                <form:select path="balance_id" items="${listBalance}" itemLabel="bal_name" itemValue="bal_id"/>
                --%>
            </div>

            <h2>Parcelamento</h2>
            <div>
                <label for="tra_numInstalments">Numero de Parcelas</label>
                <form:input type="number" path="tra_numInstalments" value="0" max="240" min="0"/>
            </div>
            <div>
                <label for="ins_interestRate">Juros</label>
                <form:input type="number" path="ins_interestRate" value="0" max="100" min="0"/>
            </div>
            <button type="submit">Cadastrar Transação</button>
        </form:form>
    </body>
</html>
