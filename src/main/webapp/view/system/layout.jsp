<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <jsp:include page="../include/jquery.jsp"/>
    <jsp:include page="../include/bootstrap.jsp"/>
    <link rel="stylesheet" href="../../static/style/layout.css">
</head>
<body>
<%-- head title --%>
<nav class="nav navbar-fixed-top layout-header">
    <div class="container-fluid">
        <div class="navbar-left layout-header-title">后台管理系统</div>
        <div class="navbar-right layout-header-info">欢迎管理员:admin</div>
    </div>
</nav>
<%-- left menu --%>
<div class="panel-group layout-menu" id="accordion">
    <div class="panel panel-default">
        <div class="panel-heading" role="tab" id="headingOne">
            <h4 class="panel-title">
                <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne"
                   aria-expanded="true" aria-controls="collapseOne">
                    <i class="glyphicon glyphicon-cog"></i>系统管理
                </a>
            </h4>
        </div>
        <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
            <div class="list-group">
                <a href="#" class="list-group-item text-center"><i class="glyphicon glyphicon-user"></i>用户管理</a>
                <a href="#" class="list-group-item text-center">角色管理</a>
                <a href="#" class="list-group-item text-center">菜单管理</a>
                <a href="#" class="list-group-item text-center">权限管理</a>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading" role="tab" id="headingTwo">
            <h4 class="panel-title">
                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                   href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    统计报表
                </a>
            </h4>
        </div>
        <div id="collapseTwo" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingTwo">
            <div class="panel-body">
                Anim pariatur
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading" role="tab" id="headingThree">
            <h4 class="panel-title">
                <a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion"
                   href="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    系统监控
                </a>
            </h4>
        </div>
        <div id="collapseThree" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingThree">
            <div class="panel-body">
                Anim
            </div>
        </div>
    </div>
</div>
<%-- center content --%>
<div id="main-content" class="layout-center">
    <!-- Nav tabs -->
    <ul class="nav nav-tabs" role="tablist">
        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
        <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
        <%--<li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>--%>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <div role="tabpanel" class="tab-pane active" id="home">...</div>
        <div role="tabpanel" class="tab-pane" id="profile">...</div>
        <div role="tabpanel" class="tab-pane" id="messages">...</div>
        <%--<div role="tabpanel" class="tab-pane" id="settings">...</div>--%>
    </div>
</div>
<div class="layout-footer navbar-fixed-bottom">

</div>
<script>
    var tabTitle = '<li role="presentation" class="active"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>';
    $('#main-content .nav-tabs').append(tabTitle);
//    var tabContent = '<div role="tabpanel" class="tab-pane" id="settings"></div>';
    $('#main-content .tab-content').load('user.jsp')
//    $('#main-content .tab-content').append(tabTitle, function(){
//        $('#settings').load('user.jsp')
//    });

</script>
</body>
</html>
