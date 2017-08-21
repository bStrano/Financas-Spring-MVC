<%-- 
    Document   : login
    Created on : 04/08/2017, 11:12:57
    Author     : Bruno Strano
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags/" prefix="tags" %>

<tags:pageTemplate title="Login" >
    
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
</tags:pageTemplate>