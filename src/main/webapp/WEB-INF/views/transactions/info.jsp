<%-- 
    Document   : info
    Created on : 18/07/2017, 11:04:34
    Author     : Bruno Strano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <h1>Transaction #${tra.tra_id}: ${tra.tra_name}</h1>
        <p>Descrição: ${tra.tra_desc}</p>
        
        <p>Date: 
            <fmt:formatDate pattern="dd/MM/yyyy" value="${tra.tra_date.time}"  /> 
        .</p>
        <p>Categorias: ${tra.tra_categories}</p>
        <p>Company: ${tra.tra_company.com_name}</p>
        <p>Nota Fiscal: <a href="${tra.tra_invoicePath}" download> Baixar </a></p>
        <p>Valor: ${tra.tra_value} </p>
        <p>Numero de parcelas: ${tra_numInstalments}</p>
        <table>
            <thead>
                <tr>
                    <th>Parcela</th>
                    <th>Valor</th>
                </tr>
            </thead>
            <tbody>
                
                    <c:forEach items="${tra.tra_instalments}" var="ins" varStatus="counter">
                        <%--
                        ${theCount.index} starts counting at 0
                        ${theCount.count} starts counting at 1                  
                        --%>
                    <tr>
                        <td>Parcela <strong>${counter.count}</strong></td>
                        <td>${ins.ins_value}</td>
                    </tr>   
                    </c:forEach>
                
            </tbody>
        </table>
    </body>
</html>
