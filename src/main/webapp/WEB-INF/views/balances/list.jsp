<%-- 
    Document   : list
    Created on : 17/08/2017, 16:02:34
    Author     : Bruno Strano
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tags" %>
<!DOCTYPE html>
<tags:pageTemplate title="Stralom - Saldos">
    <main>
        <h1>Lista de Balances</h1>
        <div clas="row">

            <c:forEach items="${listBalance}" var="bal" >
                <div class="col-xs-4 listBalance" >
                    <h2>${bal.bal_name}</h2>
                    <c:url value="/transactions" var="transactions" />
                    <form action="${transactions}">
                        <input type="hidden" name="idBalance" value="${bal.bal_id}" />
                        <button class="bg-primary">Visualizar</button>

                    </form>      
                </div>
               
            </c:forEach>
        </div>
    </main>
</tags:pageTemplate>
