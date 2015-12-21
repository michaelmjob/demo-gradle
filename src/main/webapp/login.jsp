<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="static/css/login.css" />
</head>
<body>
    <form>
        <div class="login-top">
            <div class="login-title">
                管理系统登录
            </div>
        </div>
        <div>
            <div class="login-main">
                <div class="login-main"></div>
                <div class="login-main-errortip">&nbsp;</div>
                <div class="login-main-lgn">
                    <input type="text" id="username" name="username" value="admin">
                </div>
                <div class="login-main-pwd">
                    <input type="password" id="password" name="password" value="123456">
                </div>
                <div class="login-main-yzm">
                    <input type="text" id="captcha" name="captcha" value="admin">
                    <img alt="验证码" src="/static/images/captcha.jpg" title="点击更换" id="img-captcha"
                         onclick="javascript:refreshCaptcha();">
                </div>
                <div class="login-main-remb">
                    <input id="remeberme" name="rememberMe" type="hidden">
                </div>
                <div class="login-main-submit">
                    <button onclick=""></button>
                </div>

            </div>
        </div>
    </form>

</body>
</html>
