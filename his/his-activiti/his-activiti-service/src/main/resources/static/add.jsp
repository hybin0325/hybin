<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%> 
<%@page import="org.springframework.context.ApplicationContext" %>    
<%@page import="com.jy.service.onlineform.OnlineFormService" %> 
<%
  ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(getServletContext());    
  OnlineFormService onlineFormService = (OnlineFormService)ctx.getBean("onlineFormService"); 
  String bizId = request.getParameter("bizId");
  if(bizId != null && !bizId.equals("")){
  	request.setAttribute("of", onlineFormService.getEntityById(bizId));
  }
%>
<!DOCTYPE html >
<html>
<head>
	<title>新增文档</title>
<%@include file="/common/base.jsp" %>
<link rel="stylesheet" href="static/css/system/bootstrap/bootstrap.min.css" />
<script src="static/js/bootstrap/bootstrap.min.js"></script>
<style type="text/css">
.fitem{
	
	vertical-align: text-top;
}
tr{
height: 40px;
}
form div{
	margin-top:10px;
}
form div label{
	width:100px;
	text-align: right;
}
</style>
<script type="text/javascript">
function save(){
	$('#frm').mySubmit({
		url : 'OnlineFormController/save',
		success: function(res){
			window.parent.query();
			closeWin();
		}
	});
	return true;
}
</script>
</head>
<body>
    <form id="frm" method="post">
    <input name="id" type="hidden" value="${of.id}"/>
    <div>
		<label for="key">表单名称:</label>
		<input id="key" class="easyui-validatebox" value="${of.key}"  name="key" data-options="required:true" />
    </div>
    <div>
		<label for="descr">描述:</label>
		<input id="descr" class="easyui-validatebox" value="${of.descr}"  name="descr" />
    </div>
    <div>
		<label for="enabled">是否启用:</label>
		<select id="enabled" name="enabled">
			<option ${"启用".equals(of.enabled)? "selected" : ""}>启用</option>
			<option ${"禁用".equals(of.enabled)? "selected" : ""}>禁用</option>
		</select>
    </div>
    <div style="text-align: center; padding: 5px">
		<a href="javascript:save()" class="easyui-linkbutton" >保存</a>    
		<a href="javascript:closeWin()" class="easyui-linkbutton">取消</a>
	</div>
</form>
</body>
</html>


