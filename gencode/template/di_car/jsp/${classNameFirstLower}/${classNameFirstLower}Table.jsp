<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>  
<#assign classNameLowerCase = className?lower_case>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/jsp/page/common/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>聚品商城后台管理平台 | ${table.remarks}管理</title>
</head>

<body>
		<table class="table table-striped table-bordered table-hover" id="editable" style="font-size:13px;">
			<thead>
				<tr>
				<#list table.columns as column>
					<#if column.isPk()>
						
					<#else>
						<th style="width:${100/table.columns?size}%">${column.columnAlias}</th>
					</#if>
				</#list>			
				<th style="width:${100/table.columns?size}%">操作</th>
				</tr>
			</thead>
			<tbody>
				<#--<c:forEach items="${list}" var="item" varStatus="status">-->
				<c:forEach items="<@jspEl value="list" />" var="item" varStatus="status">
				
				<#list table.columns as column>
					<#if column.isPk()>
						<tr class="gradeX" id="${'$'}{item.${column.camelName}}">
					<#else>
						<td><c:out value="${'$'}{item.${column.camelName}}" escapeXml="true" /></td>
					</#if>
				
				</#list>
				     <td class="center">
					 <#list table.columns as column>
					 <#if column.isPk()>
					 <a href="javascript:void(0);" onclick="toEditPage('${'$'}{item.${column.camelName}}')" class="btn btn-warning btn-sm" role="button">
					     		<span class="glyphicon glyphicon-edit" aria-hidden="true"></span> 修改
					     	</a>
					<a href="javascript:void(0);" onclick="delete${className}('${'$'}{item.${column.camelName}}','');" class="btn btn-danger btn-sm" role="button">
					     		<span class="glyphicon glyphicon-trash" aria-hidden="true"></span> 删除
					     	</a>
					 </#if>
					     	
					</#list>
							
					     	
				     </td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
            
        <!-- table div -->
        <div class="row">
            <%@ include file="/WEB-INF/jsp/page/common/listPage.jsp" %>
        </div>

    <!-- Page-Level Scripts -->
    <script>
    
    </script>

</body>

</html>
