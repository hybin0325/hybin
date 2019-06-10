<!DOCTYPE html>
<html>
<head>
  	<#import "../common/common.macro.ftl" as netCommon>
	<@netCommon.commonStyle />
	<!-- DataTables -->
  	<link rel="stylesheet" href="${request.contextPath}/static/adminlte/bower_components/datatables.net-bs/css/dataTables.bootstrap.min.css">
    <title>${I18n.admin_name}</title>
</head>
<body class="hold-transition skin-blue sidebar-mini <#if cookieMap?exists && cookieMap["xxljob_adminlte_settings"]?exists && "off" == cookieMap["xxljob_adminlte_settings"].value >sidebar-collapse</#if>">
<div class="wrapper">
	<!-- header -->
	<@netCommon.commonHeader />
	<!-- left -->
	<@netCommon.commonLeft "role" />
	
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>${I18n.role_manage}</h1>
		</section>
		
		<!-- Main content -->
	    <section class="content">
	    
	    	<div class="row">
               <!--  <div class="col-xs-3">
                    <div class="input-group">
                        <span class="input-group-addon">${I18n.user_role}</span>
                        <select class="form-control" id="role" >
                            <option value="-1" >${I18n.system_all}</option>
                            <option value="1" >${I18n.user_role_admin}</option>
                            <option value="0" >${I18n.user_role_normal}</option>
                        </select>
                    </div>
                </div>-->
                <div class="col-xs-3">
                    <div class="input-group">
                        <span class="input-group-addon">${I18n.role_name}</span>
                        <input type="text" class="form-control" id="name" autocomplete="on" >
                    </div>
                </div>
	            <div class="col-xs-1">
	            	<button class="btn btn-block btn-info" id="searchBtn">${I18n.system_search}</button>
	            </div>
	            <div class="col-xs-2">
	            	<button class="btn btn-block btn-success add" type="button">${I18n.role_add}</button>
	            </div>
          	</div>
	    	
			<div class="row">
				<div class="col-xs-12">
					<div class="box">
			            <div class="box-body" >
			              	<table id="role_list" class="table table-bordered table-striped" width="100%" >
				                <thead>
					            	<tr>
                                        <th name="id" >ID</th>
                                        <th name="code" >${I18n.role_code}</th>
                                        <th name="name" >${I18n.role_name}</th>
					                  	<th name="description" >${I18n.role_description}</th>
					                  	<th>${I18n.system_opt}</th>
					                </tr>
				                </thead>
				                <tbody></tbody>
				                <tfoot></tfoot>
							</table>
						</div>
					</div>
				</div>
			</div>
	    </section>
	</div>
	
	<!-- footer -->
	<@netCommon.commonFooter />
</div>

<!-- 新增.模态框 -->
<div class="modal fade" id="addModal" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
            	<h4 class="modal-title" >${I18n.role_add}</h4>
         	</div>
         	<div class="modal-body">
				<form class="form-horizontal form" role="form" >
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">${I18n.role_code}<font color="red">*</font></label>
                        <div class="col-sm-8"><input type="text" class="form-control" name="code" placeholder="${I18n.system_please_input}${I18n.role_code}" maxlength="20" ></div>
                    </div>
             
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">${I18n.role_name}<font color="red">*</font></label>
                        <div class="col-sm-8"><input type="text" class="form-control" name="name" placeholder="${I18n.system_please_input}${I18n.role_name}" maxlength="20" ></div>
                    </div>
                     <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">${I18n.role_description}<font color="red">*</font></label>
                        <div class="col-sm-8"><input type="text" class="form-control" name="description" placeholder="${I18n.system_please_input}${I18n.role_description}" maxlength="20" ></div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">${I18n.role_permission}<font color="black">*</font></label>
                        <div class="col-sm-10">
							<#if groupList?exists && groupList?size gt 0>
								<#list groupList as item>
                                    <input type="checkbox" name="permission" value="${item.id}" />${item.title}(${item.appName})<br>
								</#list>
							</#if>
                        </div>
                    </div>
                    <hr>
					<div class="form-group">
						<div class="col-sm-offset-3 col-sm-6">
							<button type="submit" class="btn btn-primary"  >${I18n.system_save}</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">${I18n.system_cancel}</button>
						</div>
					</div>

				</form>
         	</div>
		</div>
	</div>
</div>

<!-- 更新.模态框 -->
<div class="modal fade" id="updateModal" tabindex="-1" role="dialog"  aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
            	<h4 class="modal-title" >${I18n.role_update}</h4>
         	</div>
         	<div class="modal-body">
				<form class="form-horizontal form" role="form" >
                      <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">${I18n.role_code}<font color="red">*</font></label>
                        <div class="col-sm-8"><input type="text" class="form-control" name="code" placeholder="${I18n.system_please_input}${I18n.role_code}" maxlength="20" ></div>
                    </div>
             
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">${I18n.role_name}<font color="red">*</font></label>
                        <div class="col-sm-8"><input type="text" class="form-control" name="name" placeholder="${I18n.system_please_input}${I18n.role_name}" maxlength="20" ></div>
                    </div>
                     <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">${I18n.role_description}<font color="red">*</font></label>
                        <div class="col-sm-8"><input type="text" class="form-control" name="description" placeholder="${I18n.system_please_input}${I18n.role_description}" maxlength="20" ></div>
                    </div>
                    <div class="form-group">
                        <label for="lastname" class="col-sm-2 control-label">${I18n.role_permission}<font color="black">*</font></label>
                        <div class="col-sm-10">
							<#if groupList?exists && groupList?size gt 0>
								<#list groupList as item>
                                    <input type="checkbox" name="permission" value="${item.id}" />${item.title}(${item.appName})<br>
								</#list>
							</#if>
                        </div>
                    </div>

					<hr>
					<div class="form-group">
                        <div class="col-sm-offset-3 col-sm-6">
							<button type="submit" class="btn btn-primary"  >${I18n.system_save}</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">${I18n.system_cancel}</button>
                            <input type="hidden" name="id" >
						</div>
					</div>

				</form>
         	</div>
		</div>
	</div>
</div>

<@netCommon.commonScript />
<!-- DataTables -->
<script src="${request.contextPath}/static/adminlte/bower_components/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${request.contextPath}/static/adminlte/bower_components/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="${request.contextPath}/static/js/role.index.1.js"></script>
</body>
</html>
