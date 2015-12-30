<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="panel panel-default">
    <div class="panel-body content-panel">
        <form class="form-inline">
            <div class="form-group">
                <input type="text" class="form-control input-sm" placeholder="用户名">
            </div>
            <div class="form-group">
                <input type="text" class="form-control input-sm" placeholder="电话">
            </div>
            <div class="form-group">
                <input type="date" class="form-control input-sm" placeholder="开始日期">
            </div>
            <div class="form-group">
                <input type="date" class="form-control input-sm" placeholder="结束日期">
            </div>
            <button class="btn btn-default btn-sm"><i class="glyphicon glyphicon-search"></i>查询</button>
        </form>
    </div>
    <!-- Default panel contents -->
    <div class="panel-heading content-panel">
        <button class="btn btn-default btn-sm"><i class="fa fa-user-plus fa-fw"></i>添加</button>
        <button class="btn btn-default btn-sm"><i class="fa fa-user-times fa-fw"></i>删除</button>
        <button class="btn btn-default btn-sm"><i class="fa fa-pencil-square-o fa-fw"></i>修改</button>
        <button class="btn btn-default btn-sm"><i class="fa fa-user fa-fw"></i>用户角色</button>
    </div>

    <div class="panel-body content-panel">
        <table class="table table-bordered" style="width: 85%;">
            <thead>
            <th>用户名</th>
            <th>是否锁定</th>
            <th>描述</th>
            <th>操作</th>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>2</td>
                <td>3</td>
                <td>4</td>
            </tr>
            <tr>
                <td>5</td>
                <td>6</td>
                <td>7</td>
                <td>8</td>
            </tr>
            </tbody>
        </table>
        <nav>
            <ul class="pagination">
                <li>
                    <a href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li><a href="#">1</a></li>
                <li><a href="#">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li>
                    <a href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>


<script>

</script>