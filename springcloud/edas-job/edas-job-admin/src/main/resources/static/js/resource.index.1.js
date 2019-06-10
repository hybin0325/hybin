$(function() {

	// init date tables
	var resourceListTable = $("#resource_list").dataTable({
		"deferRender": true,
		"processing" : true, 
	    "serverSide": true,
		"ajax": {
			url: base_url + "/resource/pageList",
			type:"post",
	        data : function ( d ) {
	        	var obj = {};
                obj.name = $('#name').val();
	        	obj.start = d.start;
	        	obj.length = d.length;
                return obj;
            }
	    },
	    "searching": false,
	    "ordering": false,
	    //"scrollX": true,	// scroll x，close self-adaption
	    "columns": [
	                {
	                	"data": 'id',
						"visible" : false,
						"width":'10%'
					},
	                {
	                	"data": 'code',
						"visible" : true,
						"width":'10%'
					},
					 {
	                	"data": 'name',
						"visible" : true,
						"width":'20%'
					},
	                {
	                	"data": 'type',
						"visible" : true,
                        "width":'10%'
					},
					{
	                	"data": 'url',
						"visible" : true,
                        "width":'20%'
					},
					{
	                	"data": 'method',
						"visible" : true,
                        "width":'10%'
					},
					{
	                	"data": 'description',
						"visible" : true,
                        "width":'20%'
					},
	                {
						"data": I18n.system_opt ,
						"width":'15%',
	                	"render": function ( data, type, row ) {
	                		return function(){
								// html
                                tableData['key'+row.id] = row;
								var html = '<p id="'+ row.id +'" >'+
									'<button class="btn btn-warning btn-xs update" type="button">'+ I18n.system_opt_edit +'</button>  '+
									'<button class="btn btn-danger btn-xs delete" type="button">'+ I18n.system_opt_del +'</button>  '+
									'</p>';

	                			return html;
							};
	                	}
	                }
	            ],
		"language" : {
			"sProcessing" : I18n.dataTable_sProcessing ,
			"sLengthMenu" : I18n.dataTable_sLengthMenu ,
			"sZeroRecords" : I18n.dataTable_sZeroRecords ,
			"sInfo" : I18n.dataTable_sInfo ,
			"sInfoEmpty" : I18n.dataTable_sInfoEmpty ,
			"sInfoFiltered" : I18n.dataTable_sInfoFiltered ,
			"sInfoPostFix" : "",
			"sSearch" : I18n.dataTable_sSearch ,
			"sUrl" : "",
			"sEmptyTable" : I18n.dataTable_sEmptyTable ,
			"sLoadingRecords" : I18n.dataTable_sLoadingRecords ,
			"sInfoThousands" : ",",
			"oPaginate" : {
				"sFirst" : I18n.dataTable_sFirst ,
				"sPrevious" : I18n.dataTable_sPrevious ,
				"sNext" : I18n.dataTable_sNext ,
				"sLast" : I18n.dataTable_sLast
			},
			"oAria" : {
				"sSortAscending" : I18n.dataTable_sSortAscending ,
				"sSortDescending" : I18n.dataTable_sSortDescending
			}
		}
	});

    // table data
    var tableData = {};

	// search btn
	$('#searchBtn').on('click', function(){
        resourceListTable.fnDraw();
	});
	
	// job operate
	$("#resource_list").on('click', '.delete',function() {
		var id = $(this).parent('p').attr("id");

		layer.confirm( I18n.system_ok + I18n.system_opt_del + '?', {
			icon: 3,
			title: I18n.system_tips ,
            btn: [ I18n.system_ok, I18n.system_cancel ]
		}, function(index){
			layer.close(index);

			$.ajax({
				type : 'POST',
				url : base_url + "/resource/remove",
				data : {
					"id" : id
				},
				dataType : "json",
				success : function(data){
					if (data.code == 200) {
                        layer.msg( I18n.system_success );
						resourceListTable.fnDraw(false);
					} else {
                        layer.msg( data.msg || I18n.system_opt_del + I18n.system_fail );
					}
				}
			});
		});
	});

	// add role
    $("#addModal .form input[name=role]").change(function () {
		var role = $(this).val();
		if (role == 1) {
            $("#addModal .form input[name=permission]").parents('.form-group').hide();
		} else {
            $("#addModal .form input[name=permission]").parents('.form-group').show();
		}
        $("#addModal .form input[name='permission']").prop("checked",false);
    });

    jQuery.validator.addMethod("myValid01", function(value, element) {
        var length = value.length;
        var valid = /^[a-z][a-z0-9]*$/;
        return this.optional(element) || valid.test(value);
    }, I18n.user_username_valid );

	// add
	$(".add").click(function(){
		$('#addModal').modal({backdrop: false, keyboard: false}).modal('show');
	});
	var addModalValidate = $("#addModal .form").validate({
		errorElement : 'span',  
        errorClass : 'help-block',
        focusInvalid : true,  
        rules : {
            code : {
				required : true,
                rangelength:[4, 20],
                myValid01: true
			},
            name : {
                required : true,
                rangelength:[4, 20]
            }
        }, 
        messages : {
            code : {
            	required : I18n.system_please_input + I18n.resource_code,
                rangelength: I18n.system_lengh_limit + "[4-20]"
            },
            name : {
                required : I18n.system_please_input + I18n.resource_name,
                rangelength: I18n.system_lengh_limit + "[4-20]"
            }
        },
		highlight : function(element) {  
            $(element).closest('.form-group').addClass('has-error');  
        },
        success : function(label) {  
            label.closest('.form-group').removeClass('has-error');  
            label.remove();  
        },
        errorPlacement : function(error, element) {  
            element.parent('div').append(error);  
        },
        submitHandler : function(form) {

        	var parentId = $("#addModal .form select[name='parentId']").val();
        	
			var paramData = {
				"code": $("#addModal .form input[name=code]").val(),
				"name": $("#addModal .form input[name=name]").val(),
                "type": $("#addModal .form input[name=type]").val(),
                "url": $("#addModal .form input[name=url]").val(),
                "method": $("#addModal .form input[name=method]").val(),
                "description": $("#addModal .form input[name=description]").val(),
                "parentId": parentId
			};

        	$.post(base_url + "/resource/add", paramData, function(data, status) {
    			if (data.code == "200") {
					$('#addModal').modal('hide');

                    layer.msg( I18n.system_add_suc );
                    resourceListTable.fnDraw();
    			} else {
					layer.open({
						title: I18n.system_tips ,
                        btn: [ I18n.system_ok ],
						content: (data.msg || I18n.system_add_fail),
						icon: '2'
					});
    			}
    		});
		}
	});
	$("#addModal").on('hide.bs.modal', function () {
		$("#addModal .form")[0].reset();
		addModalValidate.resetForm();
		$("#addModal .form .form-group").removeClass("has-error");
		$(".remote_panel").show();	// remote
	});

    // update role
    $("#updateModal .form input[name=role]").change(function () {
        var role = $(this).val();
        if (role == 101) {
            $("#updateModal .form input[name=permission]").parents('.form-group').hide();
        } else {
            $("#updateModal .form input[name=permission]").parents('.form-group').show();
        }
        $("#updateModal .form input[name='permission']").prop("checked",false);
    });

	// update
	$("#resource_list").on('click', '.update',function() {

        var id = $(this).parent('p').attr("id");
        var row = tableData['key'+id];

		// base data
		$("#updateModal .form input[name='id']").val( row.id );
		$("#updateModal .form input[name='code']").val( row.code );
		$("#updateModal .form input[name='type']").val( row.type );
		$("#updateModal .form input[name='url']").val( row.url );
		$("#updateModal .form input[name='method']").val( row.method );
		$("#updateModal .form input[name='description']").val( row.description );
		$("#updateModal .form input[name='name']").val( row.name);
		//$("#updateModal .form input[name='role'][value='"+ row.role +"']").click();
		
		
		
        var permissionArr = [];
        if (row.permission) {
            permissionArr = row.permission.split(",");
		}
        $("#updateModal .form input[name='permission']").each(function () {
            if($.inArray($(this).val(), permissionArr) > -1) {
                $(this).prop("checked",true);
            } else {
                $(this).prop("checked",false);
            }
        });

		// show
		$('#updateModal').modal({backdrop: false, keyboard: false}).modal('show');
	});
	var updateModalValidate = $("#updateModal .form").validate({
		errorElement : 'span',  
        errorClass : 'help-block',
        focusInvalid : true,
		highlight : function(element) {
            $(element).closest('.form-group').addClass('has-error');  
        },
        success : function(label) {  
            label.closest('.form-group').removeClass('has-error');  
            label.remove();  
        },
        errorPlacement : function(error, element) {  
            element.parent('div').append(error);  
        },
        submitHandler : function(form) {

        	var parentId = $("#updateModal .form select[name='parentId']").val();

            var paramData = {
                "id": $("#updateModal .form input[name=id]").val(),
                "code": $("#updateModal .form input[name=code]").val(),
                "name": $("#updateModal .form input[name=name]").val(),
                "type": $("#updateModal .form input[name=type]").val(),
                "url": $("#updateModal .form input[name=url]").val(),
                "description": $("#updateModal .form input[name=description]").val(),
                "method": $("#updateModal .form input[name=method]").val(),
                "parentId": parentId
            };

            $.post(base_url + "/resource/update", paramData, function(data, status) {
                if (data.code == "200") {
                    $('#updateModal').modal('hide');

                    layer.msg( I18n.system_update_suc );
                    resourceListTable.fnDraw();
                } else {
                    layer.open({
                        title: I18n.system_tips ,
                        btn: [ I18n.system_ok ],
                        content: (data.msg || I18n.system_update_fail),
                        icon: '2'
                    });
                }
            });
		}
	});
	$("#updateModal").on('hide.bs.modal', function () {
        $("#updateModal .form")[0].reset();
        updateModalValidate.resetForm();
        $("#updateModal .form .form-group").removeClass("has-error");
        $(".remote_panel").show();	// remote
	});

});
