<%-- 
    Document   : pageTemplate
    Created on : 08/08/2017, 12:45:52
    Author     : Bruno Strano
--%>

<%@tag description="Page Template" language="java" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="title" required="true"%>
<%@attribute name="cssPath" required="true"%>
<html>
    <head>
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>${title} - Stralom</title>

        <link rel="stylesheet" type="text/css" href="${cssPath}/estilo.css" />
        <link rel="stylesheet" type="text/css" href="${cssPath}/bootstrap.min.css" />
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
        </div>
    </body>
</html>

<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>