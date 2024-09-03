<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加用户</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/pagination.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
    <script src="${pageContext.request.contextPath}/js/pagination.js"></script>
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
</head>
<body class="hold-transition skin-red sidebar-mini">
<script>
function validateForm(){
    var name = document.getElementsByName("name")[0].value;
    var tel = document.getElementsByName("tel")[0].value;
    var role = document.querySelector('input[name="role"]:checked');
    if (name ==""||tel==""||!role) {
        alert("添加的信息不全!");
        return false; // 阻止表单提交
    } else {
        alert("提交成功！");
        return true; // 允许表单提交
    }
}
</script>
<!--数据展示头部-->
<div class="box-header with-border">
    <h2 class="text-success" align="center">用户信息添加</h2>
</div>
<!--数据展示头部-->
<!--数据展示内容区-->
<div class="box-body">
    <!-- 数据表格 -->
    <div class="container">
    <div class="row">
    <div class="col-md-3"> </div>
     <div class="col-md-6">
     <form action="${pageContext.request.contextPath}/addInfo" method="post" onsubmit="return validateForm()">
      <table id="dataList" class="table table-bordered table-striped table-hover dataTable text-center">
       <tr class="success">
       <td>用户名</td>
      <td><input type="text" name="name" placeholder="请输入用户名" maxlength=20 class="form-control" /> </td>
       </tr>
       <tr class="success">
       <td>用户电话</td>
      <td><input type="tel" name="tel" placeholder="请输入电话号码" maxlength=20 class="form-control" /> </td>
       </tr>
       <tr class="success">
       <td>用户角色</td>
      <td colspan="2"><input type="radio" name="role" value="stu" />学生
      <input type="radio" name="role" value="teacher" />老师
      </td>
       </tr>
       <tr class="success">
       <td colspan="2" align="center">
        <input type="submit" value="添加" class="btn btn-info btn-lg" />
          <input type="reset" value="清除" class="btn btn-info btn-lg" />
       </td>
       </tr>
    </table>
     </form> 
     </div>
      <div class="col-md-3"> </div>
    </div>
    </div>
        <div id="pagination" class="pagination"></div>
</div>
</body>
</html>