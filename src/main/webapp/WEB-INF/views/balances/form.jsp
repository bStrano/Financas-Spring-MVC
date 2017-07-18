<%-- 
    Document   : form
    Created on : 18/07/2017, 08:24:09
    Author     : Bruno Strano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Balance Cadastro</h1>
        <form:form>
            <div>
                <label for="bal_name">Nome: </label>
                <form:input path="bal_name" type="text" />
            </div>
            
            <div>
                <label for="bal_desc">Descrição: </label>
                <form:textarea cols="20" rows="10" path="bal_desc" /> 
            </div>
          
                
           
            
            
        </form:form>
    </body>
</html>
