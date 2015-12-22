<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <jsp:include page="../include/jquery.jsp"/>
    <jsp:include page="../include/bootstrap.jsp"/>
    <link rel="stylesheet" href="../../static/style/layout.css">
    <link rel="stylesheet" href="../../static/font-awesome/css/font-awesome.css">
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
                <a href="javascript: openTab(10001)" class="list-group-item text-center">
                    <i class="fa fa-user"></i>用户管理</a>
                <a href="javascript: openTab(10002)" class="list-group-item text-center">
                    <i class="fa fa-user-secret"></i>角色管理</a>
                <a href="#" class="list-group-item text-center">
                    <i class="fa fa-bars"></i>菜单管理</a>
                <a href="#" class="list-group-item text-center">
                    <i class="fa fa-key"></i>权限管理</a>
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
        <%--<li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>--%>
    </ul>
    <!-- Tab panes -->
    <div class="tab-content">
        <%--<div role="tabpanel" class="tab-pane" id="settings">...</div>--%>
    </div>
</div>
<div class="layout-footer navbar-fixed-bottom">

</div>
<script>
    var menus = [{
        "title": "用户管理",
        "id": 10001,
        "url": "user.jsp",
        "iconClass": "fa fa-user"
    }, {
        "title": "角色管理",
        "id": 10002,
        "url": "role.jsp",
        "iconClass": "fa fa-user-secret"
    }, {
        "title": "菜单管理",
        "id": 10003,
        "url": "user.jsp",
        "iconClass": "fa fa-bars"
    }, {
        "title": "权限管理",
        "id": 10004,
        "url": "user.jsp",
        "iconClass": "fa fa-key"
    }];

    $(function() {
        $('#main-content .tab-content').load('main.jsp');
    });

    function openTab(id) {
        var menu = (function() {
            for (var i = 0; i < menus.length; i++) {
                if (menus[i].id == id)
                    return menus[i];
            }
        })();

        var openedTabs = $('#main-content .nav-tabs li a');
        var flag = false;
        for (var i = 0; i < openedTabs.length; i++) {
            if ($(openedTabs[i]).attr('aria-controls') == menu.id) {
                $(openedTabs[i]).parent().attr('class', 'active');
                flag = true;
            } else {
                $(openedTabs[i]).parent().removeAttr('class');
            }
        }
        if (!flag) {
            var tabTitle = '<li role="presentation" class="active" data-id="' + menu.id + '" data-url="' + menu.url + '">' +
                    '<a href="#' + menu.id + '" onclick="clickTab(' + menu.id + ')" aria-controls="' + menu.id + '" role="tab" data-toggle="tab">' +
                    '<i class="' + menu.iconClass + '" onclick="closeTab(' + menu.id + ')"></i>' + menu.title + '</a>' +
                    '<i class="close-tab glyphicon glyphicon-remove" onclick="closeTab(' + menu.id + ')"></i></li>';
            $('#main-content .nav-tabs').append(tabTitle);
            $('#main-content .tab-content').load(menu.url);
        } else {
            $('#main-content .tab-content').load(menu.url);
        }
    }

    function clickTab(id) {
        var menu = (function() {
            for (var i = 0; i < menus.length; i++) {
                if (menus[i].id == id)
                    return menus[i];
            }
        })();
        var openedTabs = $('#main-content .nav-tabs li a');
        for (var i = 0; i < openedTabs.length; i++) {
            if ($(openedTabs[i]).attr('href') == '#' + menu.id) {
                $(openedTabs[i]).parent().attr('class', 'active');
            } else {
                $(openedTabs[i]).parent().removeAttr('class');
            }
        }
        $('#main-content .tab-content').load(menu.url)
    }

    function closeTab(id) {
        var openedTabs = $('#main-content .nav-tabs li');
        if (openedTabs.length == 1) {
            $(openedTabs[0]).remove();
            $('#main-content .tab-content').load('main.jsp');
            return;
        }
        for (var i = 0; i < openedTabs.length; i++) {
            if (openedTabs[i].dataset.id == id) {
                if ($(openedTabs[i]).hasClass('active')) {
                    if (i < openedTabs.length - 1) {
                        var url = openedTabs[i + 1].dataset.url;
                        $(openedTabs[i + 1]).attr('class', 'active');
                        $('#main-content .tab-content').load(url);
                    } else {
                        var url = openedTabs[i - 1].dataset.url;
                        $(openedTabs[i - 1]).attr('class', 'active');
                        $('#main-content .tab-content').load(url);
                    }
                }
                $(openedTabs[i]).remove();
            }
        }
    }


</script>
</body>
</html>
