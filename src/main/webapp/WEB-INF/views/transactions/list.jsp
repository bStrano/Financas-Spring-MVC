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
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    </head>
    <body>
        <div><p>${sucess}</p></div>
        <h1>Lista de Transações!</h1>
        <h2><spring:message code="message.test" />
        </h2>
        <table class="table table-bordered table-responsive table-hover">
            <tr>
                <td>Nome</td>
                <td>Descrição</td>
                <td>Valor (Parcela)</td>
                <td>Tipo</td>
                <td>Categorias</td>
                <td>Data</td>
                <td>Company</td>
            </tr>
            <c:forEach var="tra" items="${listTransaction}">       
                <c:choose>
                    <c:when test="${tra.tra_typeTransaction == 'ENTRADA'}" >
                        <tr class="success">
                        </c:when>
                        <c:otherwise>
                        <tr class="danger">
                        </c:otherwise>

                    </c:choose>
                    <td>${tra.tra_name}</td>
                    <td>${tra.tra_desc}</td>
                    <td>
                        <!-- http://www.tutorialspoint.com/jsp/jstl_format_formatnumber_tag.htm -->
                        <c:choose>
                            <c:when test="${tra.tra_numInstalments > 0}" >
                                <!-- The date also need this setTra_numInstalmentsRemaining above-->
                                ${tra.setTra_numInstalmentsRemaining(tra.getTra_numInstalmentsRemaining() + 1)}
                                <fmt:formatNumber value="${tra.tra_value}" type="currency"/>  (
                                <fmt:formatNumber value="${tra.tra_instalments[tra.tra_numInstalmentsRemaining].ins_value}" type="currency"/>)
                            </c:when>
                            <c:otherwise>
                                <fmt:formatNumber value="${tra.tra_value}" type="currency"/>(0)
                            </c:otherwise>
                        </c:choose>
                    </td>
                    <td>${tra.tra_typeTransaction}</td>
                    <td>${tra.tra_categories}</td>      
                    <td>
                        <c:choose>
                            <c:when test="${tra.tra_numInstalments > 0}" >
                                <fmt:formatDate value="${tra.tra_instalments[tra.tra_numInstalmentsRemaining].ins_date.time}" pattern="dd/MM/yyyy"/>
                            </c:when>
                            <c:otherwise>
                                <fmt:formatDate value="${tra.tra_date.time}" pattern="dd/MM/yyyy"/>
                            </c:otherwise>
                        </c:choose>
                            </td>
                            <td>${tra.tra_company.com_name}</td>
                        <td>
                            <span class="glyphicon glyphicon-remove"></span>

                        </td>
                    </tr>
            </c:forEach>
        </table>
    </body>
</html>
