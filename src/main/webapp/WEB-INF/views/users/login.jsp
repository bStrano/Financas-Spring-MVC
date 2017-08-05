<%-- 
    Document   : login
    Created on : 04/08/2017, 11:12:57
    Author     : Bruno Strano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Form de Login</h1>
                <form:form action="login" method="POST">
                    <div class="form-group">  
                        <label for="username">Email: </label>
                        <input type="email" name="username" class="form-control" placeholder="Email@email.com.br"/>
                    </div>
                    <div class="form-group">
                        <label for="password">Senha: </label>
                        <input type="password" name="password" class="form-control" placeholder="Senha"/>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Entrar</button>
                    </div>
                </form:form>
            </div>
        </div>
    </body>
</html>
