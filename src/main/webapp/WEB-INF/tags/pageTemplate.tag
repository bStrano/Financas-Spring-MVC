<%-- 
    Document   : pageTemplate
    Created on : 08/08/2017, 12:45:52
    Author     : Bruno Strano
--%>

<%@tag description="Page Template" language="java" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title" required="true"%>
<%@attribute name="cssPath" required="false"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>${title} - Stralom</title>

        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/estilo.css" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" />
    </head>

    <body class="bodyCss">
        <div class="container">
            <header class="row">
                <%@include file="/WEB-INF/views/templates/header.jsp" %>
            </header>
            <main>
                <jsp:doBody/>
            </main>
            <%-- <footer>
               <%@include file="/WEB-INF/views/templates/footer.jsp" %>
            </footer> --%>
            <script src="${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js"></script>
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>     
        </div>
    </body>
</html>

<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>