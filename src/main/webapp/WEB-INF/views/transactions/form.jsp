<%-- 
    Document   : form
    Created on : 24/06/2017, 08:47:25
    Author     : Bruno Strano
--%>

<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tags" %>
<!DOCTYPE html>

<tags:pageTemplate title="Login" >
    <div class="container">
        <h1>Cadastro de Transações</h1>

        <spring:url value="/transactions" var="transactions"/>
        <form:form action="${transactions}" method="POST" commandName="transactionForm" enctype="multipart/form-data" cssClass="form-horizontal">
            <div class="form-group has-warning" >

                <label for="tra_name">Nome: </label>     
                <div class="input-group">
                    <form:input path="tra_name" name="tra_name" cssClass="form-control"/>
                    <span class="input-group-addon">Obrigatório</span>
                    <form:errors  path="tra_name"/>
                </div>
            </div>
            <div class="form-group">
                <label for="tra_desc">Descrição:</label>  
                <form:textarea cols="10" rows="5" path="tra_desc" name="tra_desc" cssClass="form-control"/>
                <form:errors path="tra_desc" />
            </div>
            <div class="form-group">
                <label for="tra_date">Data da Transação: </label>
                <div class="input-group">
                    <form:input path="tra_date" type="date" name="tra_date" cssClass="form-control"/>
                    <span class="input-group-addon">Obrigatório</span>
                    <form:errors path="tra_date" />
                </div>
            </div>


            <div class="form-group">
                <label for="tra_invoice">Nota Fiscal: </label>
                <input type="file" name="invoice" class="form-control" />
            </div>

            <div class="form-group">
                <label for="tra_balances">Balances</label>
                <form:select itemValue="bal_id" itemLabel="bal_name" items="${listBalance}" path="bal_id" cssClass="form-control"/>
            </div>

            <div class="form-group">
                <label for="category_id" class="label-control">Categorias: </label>
                <form:select itemValue="cat_id" itemLabel="cat_name" items="${listCategory}" path="category_id" cssClass="form-control"/>   
                <form:errors path="category_id" />
            </div>

            <div class="form-group"> 
                <label for="company_id" class="label-control">Empresa: </label>
                <form:select path="company_id" items="${listCompany}" itemLabel="com_name" itemValue="com_id" cssClass="form-control"/>
                <form:errors path="company_id" />
            </div>

            <div>
                <%-- 
                <form:select path="balance_id" items="${listBalance}" itemLabel="bal_name" itemValue="bal_id"/>
                --%>
            </div>

            <div class="form-group">

                <label for="tra_value">Valor: </label> 
                <div class="input-group">
                    <form:input path="tra_value" name="tra_value" cssClass="form-control" type="number" step="0.01"/>
                    <span class="input-group-addon">Obrigatório</span>
                    <form:errors path="tra_value" />
                </div>
            </div>
            <div class="form-group">
                <label for="tra_typeTransaction">Tipo: </label>
                <label class="radio-inline">
                    <form:radiobutton path="tra_typeTransaction" name="typeTransaction" value="ENTRADA"/>Entrada
                </label>   
                <label class="radio-inline">
                    <form:radiobutton path="tra_typeTransaction" name="typeTransaction" value="SAIDA" />Saida
                </label>
            </div>

            <hr/>
            <div class="form-group">
                <label for="tra_numInstalments">Numero de Parcelas</label>
                <form:input type="number" path="tra_numInstalments" value="1" max="240" min="0" cssClass="form-control"/>
            </div>
            <div class="form-group">
                <label for="ins_interestRate">Juros</label>
                <form:input type="number" path="ins_interestRate"  step="0.01" value="0" max="100" min="0" cssClass="form-control"/>
            </div>
            <button type="submit" class="btn btn-primary form-control">Cadastrar Transação</button>
        </form:form>

    </div>
</tags:pageTemplate>