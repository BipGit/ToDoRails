<%--
  Created by IntelliJ IDEA.
  User: VIKTOR
  Date: 11.04.2016
  Time: 17:20
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="gear">
    <style>
    body {
    }

    .form-signin {
        width: 50%;
        margin: auto;
        margin-top: 20%;
    }

    input {
        margin-bottom: 10px;
    }
    </style>
</head>

<body>
<g:if test="${flash.message}">
    <div class="message">${flash.message}</div>
</g:if>
<div class="container">
    <div class="form-signin">
        <g:form controller="user" action="auth" method="post">
            <h2 class="form-signin-heading">Авторизация ToDoList</h2>
            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="email" id="inputEmail" name="inputEmail" class="form-control" placeholder="Email address"
                   required autofocus>
            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" id="inputPassword" name="inputPassword" class="form-control" placeholder="Password"
                   required>
            <button class="btn btn-lg btn-primary btn-block" type="submit">Войти</button>
        </g:form>
    </div>
</div> <!-- /container -->
</body>
</html>