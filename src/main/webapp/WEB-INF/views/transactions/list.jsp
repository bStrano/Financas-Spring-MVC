<%-- 
    Document   : lista
    Created on : 28/06/2017, 10:22:15
    Author     : Bruno Strano
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tags" %>
<!DOCTYPE html>
<tags:pageTemplate title="Stralom - Lista de Transações">
        <div class="container">
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
                <c:forEach var="ins" items="${listInstalment}">
                    
                    <c:choose>
                        <c:when test="${ins.ins_transaction.tra_typeTransaction == 'ENTRADA'}" >
                            <tr class="success">
                            </c:when>
                            <c:otherwise>
                            <tr class="danger">
                            </c:otherwise>

                        </c:choose>
                        <c:url var="info" value="transactions/info/${ins.ins_transaction.tra_id}"/>
                        <td><a href="${info}" >${ins.ins_transaction.tra_name}</a></td>
                        <td>${ins.ins_transaction.tra_desc}</td>
                        <td>
                            <!-- http://www.tutorialspoint.com/jsp/jstl_format_formatnumber_tag.htm -->
                            <fmt:formatNumber value="${ins.ins_value}" type="currency"/>  
                            (<fmt:formatNumber value="${ins.ins_transaction.tra_value}" type="currency"/>)
                        </td>
                        <td>${ins.ins_transaction.tra_typeTransaction}</td>
                        <td>${ins.ins_transaction.tra_categories}</td>      
                        <td>
                            <fmt:formatDate value="${ins.ins_date.time}" pattern="dd/MM/yyyy"/>
                        </td>
                        <td>${ins.ins_transaction.tra_company.com_name}</td>
                        <td>
                            <span class="glyphicon glyphicon-remove"></span>

                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
</tags:pageTemplate>

