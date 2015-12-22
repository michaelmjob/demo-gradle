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
    <div class="container">
    <form class="form-inline">
        <div class="form-group">
            <input type="text" class="form-control" placeholder="用户名">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="电话">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="开始日期">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" placeholder="结束日期">
        </div>
        <button class="btn btn-default"><i class="glyphicon glyphicon-search"></i>查询</button>
    </form>
    </div>
<script>

</script>
</body>
</html>
