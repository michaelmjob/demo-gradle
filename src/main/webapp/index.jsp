<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html>
<head>
    <title>Title</title>
    <jsp:include page="include/bootstrap.jsp"></jsp:include>
</head>
<body>
<!-- 容器遮罩 -->
<div id="maskContainer">
    <div class="datagrid-mask" style="display: block;"></div>
    <div class="datagrid-mask-msg" style="display: block; left: 50%; margin-left: -52.5px;">
        正在加载...
    </div>
</div>
<div id="mainLayout" class="easyui-layout hidden" data-options="fit: true">
    <div id="northPanel" data-options="region: 'north', border: false" style="height: 80px; overflow: hidden;">
        <div id="topbar" class="top-bar">
            <div class="top-bar-left">
                <h1 style="margin-left: 10px; margin-top: 10px;color: #fff">JTY<span
                        style="color: #3F4752">后台管理系统</span></h1>
            </div>
            <div class="top-bar-right">
                <div id="timerSpan"></div>
                <div id="themeSpan">
                    <a id="btnHideNorth" class="easyui-linkbutton"
                       data-options="plain: true, iconCls: 'layout-button-up'"></a>
                </div>
            </div>
        </div>
        <div id="toolbar" class="panel-header panel-header-noborder top-toolbar">
            <div id="infobar">
                    <span class="icon-hamburg-user" style="padding-left: 25px; background-position: left center;">
                       <shiro:principal property="name"/>，您好
                    </span>
            </div>

            <div id="buttonbar">
                <span>更换皮肤：</span>
                <select id="themeSelector"></select>
                <a href="javascript:void(0);" class="easyui-menubutton" data-options="menu:'#layout_north_set'"
                   iconCls="icon-standard-cog">系统</a>
                <div id="layout_north_set">
                    <div id="btnFullScreen" data-options="iconCls:'key'">全屏切换</div>
                    <div id="btnExit" data-options="iconCls:'logout'">退出系统</div>
                </div>
                <a id="btnShowNorth" class="easyui-linkbutton" data-options="plain: true, iconCls: 'layout-button-down'"
                   style="display: none;"></a>
            </div>
        </div>
    </div>

    <div data-options="region: 'west', title: '菜单导航栏', iconCls: 'icon-standard-map', split: true, minWidth: 200, maxWidth: 400"
         style="width: 220px; padding: 1px;">
        <div id="myMenu" class="easyui-accordion" data-options="fit:true,border:false">
            <script id="menu" type="text/html">
                {{each data as p_permission}}
                {{if (p_permission.pid==null)}}
                <div title="{{p_permission.name }}" style="padding: 5px;"
                     data-options="border:false,iconCls:'{{p_permission.icon }}'">
                    <div>
                        {{each data as c_permission}}
                        {{if (c_permission.pid==p_permission.id)}}
                        <a id="btn" class="easyui-linkbutton" data-options="plain:true,iconCls:'{{c_permission.icon }}'"
                           style="width:98%;margin-bottom:5px;"
                           onclick="window.mainpage.mainTabs.addModule('{{c_permission.name}}','{{c_permission.url }}','{{c_permission.icon }}')">{{c_permission.name}}</a>
                        {{/if}}
                        {{/each}}
                    </div>
                </div>
                {{/if}}
                {{/each}}
            </script>
        </div>
    </div>

    <div data-options="region: 'center'">
        <div id="mainTabs_tools" class="tabs-tool">
            <table>
                <tr>
                    <td><a id="mainTabs_jumpHome" class="easyui-linkbutton easyui-tooltip" title="跳转至主页选项卡"
                           data-options="plain: true, iconCls: 'icon-hamburg-home'"></a></td>
                    <td>
                        <div class="datagrid-btn-separator"></div>
                    </td>
                    <td><a id="mainTabs_toggleAll" class="easyui-linkbutton easyui-tooltip" title="展开/折叠面板使选项卡最大化"
                           data-options="plain: true, iconCls: 'icon-standard-arrow-out'"></a></td>
                    <td>
                        <div class="datagrid-btn-separator"></div>
                    </td>
                    <td><a id="mainTabs_refTab" class="easyui-linkbutton easyui-tooltip" title="刷新当前选中的选项卡"
                           data-options="plain: true, iconCls: 'icon-standard-arrow-refresh'"></a></td>
                    <td>
                        <div class="datagrid-btn-separator"></div>
                    </td>
                    <td><a id="mainTabs_closeTab" class="easyui-linkbutton easyui-tooltip" title="关闭当前选中的选项卡"
                           data-options="plain: true, iconCls: 'icon-standard-application-form-delete'"></a></td>
                </tr>
            </table>
        </div>
        <div id="mainTabs" class="easyui-tabs"
             data-options="fit: true, border: false, showOption: true, enableNewTabMenu: true, tools: '#mainTabs_tools', enableJumpTabMenu: true">
            <div id="homePanel" data-options="title: '主页', iconCls: 'icon-hamburg-home'">
                <div class="easyui-layout" data-options="fit: true">
                    <div data-options="region: 'north', split: false, border: false" style="height: 33px;">
                        首页内容
                    </div>
                    <div data-options="region: 'center', border: false" style="overflow: hidden;">

                    </div>
                </div>
            </div>
        </div>
    </div>

    <div data-options="region: 'east', title: '日历', iconCls: 'icon-standard-date', split: true,collapsed: true, minWidth: 160, maxWidth: 500"
         style="width: 220px;">
        <div id="eastLayout" class="easyui-layout" data-options="fit: true">
            <div data-options="region: 'north', split: false, border: false" style="height: 220px;">
                <div class="easyui-calendar" data-options="fit: true, border: false"></div>
            </div>
            <div id="linkPanel"
                 data-options="region: 'center', border: false, title: '通知', iconCls: 'icon-hamburg-link', tools: [{ iconCls: 'icon-hamburg-refresh', handler: function () { window.link.reload(); } }]">

            </div>
        </div>
    </div>

    <div data-options="region: 'south', title: '关于...', iconCls: 'icon-standard-information', collapsed: true, border: false"
         style="height: 70px;">
        <div style="color: #4e5766; padding: 6px 0px 0px 0px; margin: 0px auto; text-align: center; font-size:12px; font-family:微软雅黑;">

        </div>
    </div>

</div>
</body>
</DOChtml>
