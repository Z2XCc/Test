<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	首页 ${user.name}
	<div class="content-wrapper">
		<iframe width="100%" height="800" id="iframe" name="iframe" onload="SetIFrameHeight()" frameborder=0 src="${pageContext.request.contextPath}/userList"></iframe>
	</div>
</body>
</html>