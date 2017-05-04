<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>  
<#assign classNameLowerCase = className?lower_case>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/page/common/taglibs.jsp"%>
<%@ include file="/WEB-INF/jsp/page/common/page_head.jsp"%>
<!DOCTYPE html>

<html>
<script src="/script/${classNameLower}/${classNameLower}.js"></script>
<head>
	<title>维信金科后台管理平台 | ${table.remarks}管理</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

</head>

<body>

        <div class="row wrapper border-bottom white-bg page-heading">
            <div class="col-lg-10">
            		<h>&nbsp;</h>
                <ol class="breadcrumb">
                    <li>
                        <a href="index.html">主页</a>
                    </li>
                    <li>
                        <a>系统管理</a>
                    </li>
                    <li class="active">
                        <strong>${table.remarks}管理</strong>
                    </li>
                </ol>
            </div>
            <div class="col-lg-2">

            </div>
        </div>

        <div class="wrapper wrapper-content animated fadeInRight">
            <div class="row">
                <div class="col-lg-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>列表</h5>
                    </div>
                    <form id="searchForm">
                    <div class="ibox-content">
	                    	<div style="float:left;">
							
							<#list table.columns as column>
								<#if column.isPk()>
									<#-- 主键-->
								<#else>
								<input type="text" class="form-control" style="width:300px; float:left; " id="${column.camelName}" name="${column.camelName}" placeholder="${column.columnAlias}"
	                    			onkeypress="enterPress(event)" onkeydown="enterPress()" />&nbsp;&nbsp;
								</#if>
							</#list>
	                    		<input type='text' style='display:none' value="防止表单回车提交事件用"/>
	                    		<button type="button" class="btn btn-outline btn-info" style="width:90px; float:right; " onclick="search();">
	                    			<span class="glyphicon glyphicon-search" aria-hidden="true"></span> 查询</button>
	                    	</div>

				            <div class="" style="float:right">
				            		<a href="javascript:void(0);" onclick="toAddPage();" class="btn btn-primary ">
				            			<span class="glyphicon glyphicon-plus" aria-hidden="true"></span> 新增</a>
				            </div>

			            <!-- 表格 -->
			            <div id="tableDiv">
							<jsp:include page="/WEB-INF/jsp/page/${classNameLower}/${classNameLower}Table.jsp" />
						</div>
                    </div>
                    </form>
                </div>
            </div>
            </div>
		</div>
		
        <div id="deleteConfirmModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>
                        <h4 class="modal-title">删除确认对话框</h4>
                    </div>
                    <div class="modal-body">
                        <p>是否要删除选择的记录？</p>
                        <p>名称：<label id="del_name" ></label></p>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button id="confirm_del" onclick="aaa" type="button" class="btn btn-primary">删除</button>
                    </div>
                </div>
                <!-- /.modal-content -->
            </div>
            <!-- /.modal-dialog -->
        </div>

    <!-- Page-Level Scripts -->
    <script>

    </script>

</body>

</html>
