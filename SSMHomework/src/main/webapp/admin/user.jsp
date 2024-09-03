<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
    <title>新书推荐</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagination.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/pagination.js"></script>
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
<title>Insert title here</title>
</head>
<body class="hold-transition skin-red sidebar-mini">
<script>
function validateForm() {
    var id = document.getElementsByName("id")[0].value;
    if (id ==""||id=="0") {
        alert("请输入有效的用户ID");
        return false; //阻止表单提交
    }
    return true;
}

function confirmDelete(userId) {
    // 弹出确认对话框
    var confirmDelete = confirm("是否确定删除？");
    if (confirmDelete) {
        // 执行删除操作
        window.location.href = "${pageContext.request.contextPath}/delInfo?id="+userId;
    }
}
</script>
<!--数据展示头部-->
<div class="box-header with-border">
    <h3 class="box-title">用户列表</h3>
</div>
  <div>
    <form action="${pageContext.request.contextPath}/FindUserById" method="post" onsubmit="return validateForm()">
    <div class="container">
    <div class="row">
    <div class="col-md-4"></div>
    <div class="col-md-4">
    <br>
    <table>
    <tr>
    <td>  
    <label class="text-primary" style="margin-right:20px;">查找用户信息</label>
    </td>
    <td>
    <input  type="text" name="id" placeholder="输入用户id进行查询" class="form-control" /></td>
     <td><input type="submit" value="搜索" class="btn btn-info btn-md" /></td>
    </tr>
    </table>
    </div>
    <div class="col-md-4"></div>
    </div>
    </div>
    </form>
    </div>
     <form action="${pageContext.request.contextPath}/addPage" method="post">
      <input type="submit" class="btn btn-success" value="添加用户信息" />
    </form>
<!--数据展示头部-->
<!--数据展示内容区-->
<div class="box-body">
    <!-- 数据表格 -->
    <table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
        <thead>
        <tr>
           <th class="sorting_asc">用户id</th>
            <th class="sorting_asc">用户名称</th>
            <th class="sorting">用户电话</th>
            <th class="sorting">用户身份</th>      
            <th class="text-center">操作</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${pageResult.row}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.tel}</td>
                <td>${user.role}</td>         
                <td>
                <a type="button" class="btn btn-danger" href="javascript:void(0);" onclick="confirmDelete(${user.id})">删除</a>
                     <a type="button" class="btn btn-info" href="${pageContext.request.contextPath}/altPage?id=${user.id}">修改</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <!-- 数据表格 /-->
    <%--分页插件--%>
        <div id="pagination" class="pagination"></div>
</div>

</body>
<script>
    /*分页插件展示的总页数*/
    pageargs.total = Math.ceil(${pageResult.total}/pageargs.pagesize);
    /*分页插件当前的页码*/
    pageargs.cur = ${pageNum}
    /*分页插件页码变化时将跳转到的服务器端的路径*/
    pageargs.gour1 = "${gour1}"
    /*分页效果*/
    pagination(pageargs);
</script>
</html>