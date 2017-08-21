<%-- 
    Document   : header
    Created on : 08/08/2017, 10:46:28
    Author     : Bruno Strano
--%>



    
<nav class="navbar navbar-inverse navbar-fixed-top menu-principal container-fluid">
        <div class="navbar-header">         
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Stralom</a>

            <button  type="button" class="navbar-toggle" data-toggle="collapse" data-target="#cadastroCollapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>                 
            </button>

        </div>

        <div class="collapse navbar-collapse" id="cadastroCollapse">

            <ul class="nav navbar-nav navbar-left">
                <li><a href="${pageContext.request.contextPath}/">Inicio</a></li>
                <li><a href="menuUnauthenticated.html">Sobre</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">Transações<span class="caret"></span></a>
                    <ul class="dropdown-menu" role="menu">
                        <li><a href="${pageContext.request.contextPath}/transactions" >Minhas Transações</a></li>
                        <li class="divider"></li>
                        <li><a href="#" >Depositar</a></li>
                        <li><a href="#" >Retirar</a></li>
                        <li><a href="#" >Definir Meta</a></li>


                    </ul>

                </li>
                <li><a href="${pageContext.request.contextPath}/users/form">Cadastre-se</a></li>
            </ul>

            <div class="navbar navbard-nav navbar-right">
                <button type="button" class="btn btn-link btn">
                    <span class="glyphicon glyphicon-user" aria-hidden="true"></span>  Olá, Bruno Strano<br/> 
                    <a style="color: #d9edf7" href="#" >Minha Conta</a>
                </button>
            </div>

        </div>
    </nav>


