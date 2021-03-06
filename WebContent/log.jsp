<%--
  Created by IntelliJ IDEA.
  User: jiyang
  Date: 17-6-16
  Time: 下午3:30
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <link href="bootstrap-3/css/bootstrap.css" rel="stylesheet" type="text/css">
    <link href="bootstrap-3/css/bootstrap-theme.css" rel="stylesheet" type="text/css">
    <link href="css/main.css" rel="stylesheet" type="text/css">
    <script src="js/main.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="index.jsp" class="navbar-brand">某宝网|登录</a>
        </div>
    </div>
    <div>
        <ul class="nav navbar-nav">
            <li><a href="register.jsp"><span class="glyphicon glyphicon-user"></span>注册</a></li>
        </ul>
    </div>
</nav>
<div class="container text-center">
    <h1>登录</h1>
    <form action="login.do?action=user" method="post" onsubmit="return checkLoginInput()" role="form">
        <input class="form-control" id="username" type="text" name="name" placeholder="帐号"><br>
        <input class="form-control" id="pwd" type="password" name="pwd" placeholder="密码"><br>
        <div class="btn-group" role="group">
            <input id="login_btn" class="btn btn-default" type="submit" value="登 录">
            <input class="btn btn-default" type="button" value="注 册" onclick="location.href='register.jsp'">
            <input class="btn btn-default" type="reset" value="清 空"><br>
        </div>
    </form>
    <p class="info">${login_info}</p>
</div>
</body>
</html>
