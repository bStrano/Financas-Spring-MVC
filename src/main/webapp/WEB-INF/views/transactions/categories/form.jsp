<%-- 
    Document   : form
    Created on : 24/06/2017, 14:48:57
    Author     : Bruno Strano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" >
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Cadastro de Categoria</h1>
        <form action="/MoneySpring-1.0/transactions/categories" method="POST" >
            <div>
                <label for="cat_name"> Nome: </label>
                <input type="text" name="cat_name"/>
            </div>
            
            <input type="submit" value="Submit"/>
        </form>
    </body>
</html>
