<%-- 
    Document   : lista
    Created on : 28/06/2017, 10:22:15
    Author     : Bruno Strano
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div><p>${sucess}</p></div>
        <h1>Lista de Transações!</h1>
        <h2><spring:message code="message.test" />
        </h2>
        <table>
            <tr>
                <td>Nome</td>
                <td>Descrição</td>
                <td>Valor</td>
                <td>Tipo</td>
                <td>Categorias</td>
                <td>Data</td>
                <td>Company</td>
            </tr>
            <c:forEach var="tra" items="${listTransaction}">
                <tr>
                    <td>${tra.tra_name}</td>
                    <td>${tra.tra_desc}</td>
                    <td>
                        <!-- http://www.tutorialspoint.com/jsp/jstl_format_formatnumber_tag.htm -->
                        <fmt:formatNumber value="${tra.tra_value}" type="currency"/> 
                    </td>
                    <td>${tra.tra_typeTransaction}</td>
                    <td>${tra.tra_categories}</td>      
                    <td>
                        <fmt:formatDate value="${tra.tra_date.time}" pattern="dd/MM/yyyy"/>
                    </td>
                    <td>${tra.tra_company}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
