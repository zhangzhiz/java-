<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>  
<#assign classNameLowerCase = className?lower_case>
function search(){
	$("#pageNo").val(1);
	pageQuery();
}

function pageQuery(){
	$("#tableDiv").load(ctx+"/${classNameLowerCase}/list",
			$("#searchForm").serialize()
			,function(){
	});
}

function enterPress(e){
	var e = e || window.event; 
	if(e.keyCode == 13){ 
		search(); 
	}
}

function toAddPage(){
	$("#contentDiv").load(ctx+"/${classNameLowerCase}/addPage");
}

function toEditPage(id){
	$("#contentDiv").load(ctx+"/${classNameLowerCase}/editPage/"+id);
}

function goBack(){
	$("#contentDiv").load(ctx+"/${classNameLowerCase}/main");
}


/**
 * 验证保存的必填条件
 * return 
 */
function validateSave(){
	
	<#list table.columns as column>
	<#if !column.isNullable()>
		<#if !column.isPk()>
			<#if column.javaType == "java.lang.String">
				if(trim($("${'#'}${column.camelName}").val())==""){
					showMsg("[${column.columnAlias}]不能为空");
					$("${'#'}${column.camelName}").focus();
					return false;
				}
			</#if>
		</#if>
	</#if>
	</#list>
		
	return true;
}

function add${className}(){
	if(!validateSave()){
		return;
	}
	
	var data = $("#addForm").serialize();

	// 取得下拉角色
	//data += ("&roleId="+$("#roleSelector").val());
	
	$.ajax({
		"url" : ctx+"/${classNameLowerCase}/${classNameLower}Add",
		"type" : "PUT",
		data:data,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					showMsg(data.message);
				}else{
					//showMsg("保存成功！", 2000);
					alert(data.message);
					$("#contentDiv").load(ctx+"/${classNameLowerCase}/main");
				}
				
			}else{
				showMsg("保存出错!");
			}
		},
		"error" : function() {
			
		}
	});
}

function update${className}(){
	if(!validateSave()){
		return;
	}

	var data = $("#editForm").serialize();

	// 取得下拉角色
	//data += ("&roleId="+$("#roleSelector").val());
	
	$.ajax({
		"url" : ctx+"/${classNameLowerCase}/${classNameLower}Edit",
		"type" : "POST",
		data:data,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					showMsg(data.message);
				} else {
					//showMsg("修改成功！", 2000);
					alert(data.message);
					$("#contentDiv").load(ctx+"/${classNameLowerCase}/main");
				}
				
			}else{
				showMsg("修改出错！");
			}
		},
		"error" : function() {
		}
	});
}

function delete${className}(id,name){
	$('#deleteConfirmModal').modal('show');
	$("#del_user_name").html(name);
	$("#confirm_del").attr("onclick","delete${className}Submit("+id+")");
}

function delete${className}Submit(id){
	$.ajax({
		"url" : ctx+"/${classNameLowerCase}/${classNameLower}Delete/"+id,
		"type" : "DELETE",
		data:null,
		dataType : 'json',
		"success" : function(data) {
			if(data!=""&&data!=null){
				var status=data.status;
				if(status==0){
					showMsg(data.message,2000);
					$('#deleteConfirmModal').modal('hide');
				}else{
					alert(data.message);
					$("#"+id).remove();
					$('#deleteConfirmModal').modal('hide');
					pageQuery();
				}
				
			}else{
				showMsg("保存出错！",2000);
				$('#deleteConfirmModal').modal('hide');
			}
		},
		"error" : function() {
		}
	});

}

