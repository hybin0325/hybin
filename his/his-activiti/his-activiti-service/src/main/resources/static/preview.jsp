
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.jy.common.utils.UeditorTools "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html >
<html>
<head>
<title>新增文档</title>
<%@include file="/common/base.jsp"%>
<link href="static/plugins/bootcss3.3.5/css/bootstrap.css?2029"
	rel="stylesheet" type="text/css">
<style type="text/css">
.fitem {
	vertical-align: text-top;
}

tr {
	height: 40px;
}
</style>
<script type="text/javascript">
	
</script>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>
				预览表单 <small>如无问题请保存你的设计</small>
			</h1>
		</div>
		<%=UeditorTools.formatStr(request.getParameter("html"))%>
	</div>
	<!--end container-->

</body>
</html>



