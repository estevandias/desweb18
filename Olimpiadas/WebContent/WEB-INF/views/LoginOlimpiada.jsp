<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="pt-br">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="./css/bootstrap.min.css" type="text/css"/>

        <title>Olimpiadas</title>
    </head>
    <body>
        <!-- Import do Menu. -->
        <c:import url="MenuLogin.jsp" />
        
        <center>
            <h2 class="page-header">Olimpiadas USJT</h2>
        </center>
        <div class="row">
            <div class="col-sm-12 col-md-4 col-md-offset-4 col-lg-4 col-lg-offset-4">
                <div class="jumbotron">
                    <div class="form-group" style="width:50%; margin: 0 auto;">
                        <div class-"login-form">
                            <form action="olimpiadaController" method="POST">
                                <h2 class="text-center">Acesso</h2>
                                <div class="form-group">
                                    <div class="input-group">
                                        <span class="input-group-addon" id="usuario-span">@</span>
                                        <input type="text" name="usuario" id="usuario" class="form-control"
                                            placeholder="E-mail" aria-describedby="usuario-span" required/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="input-group">
                                        <div class="input-group-addon">
                                            <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                        </div>
                                        <input type="password" name="senha" id="senha" class="form-control"
                                            placeholder="Senha" aria-describedby="senha-span" required />
                                    </div>
                                </div>
                                <div class="form-group text-center">
                                    <button type="submit" class="btn btn-primary btn-lg"
                                        name="command" value="FazerLogin">Acessar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <script src="./js/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js"></script>
    </body>
</html>
