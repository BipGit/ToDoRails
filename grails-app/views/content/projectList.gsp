<%--
  Created by IntelliJ IDEA.
  User: VIKTOR
  Date: 13.04.2016
  Time: 17:28
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="gear">
    <title></title>
</head>

<body>
    <g:each in="${projects}" var="project">
        ${project}
    </g:each>

    <div class="container">
    </div>
</body>
</html>