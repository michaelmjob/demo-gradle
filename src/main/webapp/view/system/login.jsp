<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <jsp:include page="../include/jquery.jsp"/>
    <jsp:include page="../include/bootstrap.jsp"/>
    <link rel="stylesheet" href="../../static/style/login.css">
</head>
<body>
<div class="container">
    <div class="login-header">
        <h1>后台管理系统</h1>
    </div>
    <div class="login-main">
        <div class="text-center"><h2>登录</h2></div>
        <form action="layout.jsp">
            <div class="from-group">
                <label></label>
                <input class="login-lgn form-control" type="text" placeholder="手机号/邮箱">
            </div>
            <div class="from-group">
                <label></label>
                <input class="login-pwd form-control" type="password" placeholder="密码">
            </div>
            <div class="from-group">
                <label></label>
                <div class="form-inline">
                    <input class="login-yzm form-control" type="text" placeholder="验证码">
                    <img class="login-yzm-img from-control" src="">
                </div>
            </div>
            <div>
                <label></label>
                <button class="btn btn-primary btn-block" type="submit">登录</button>
            </div>
        </form>
    </div>
    <div class="login-footer navbar-fixed-bottom">

    </div>
</div>
</body>
</html>

