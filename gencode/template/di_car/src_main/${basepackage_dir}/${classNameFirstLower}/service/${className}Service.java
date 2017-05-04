<#assign myParentDir="service">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>  
package ${basepackage}.${table.classNameFirstLower}.service;

import ${basepackage}.${table.classNameFirstLower}.entity.${className};
import ${basepackage}.common.util.Page;
import java.util.List;
import java.util.Map;


<#include "/copyright_class.include" >
public interface ${className}Service {
	/**
	 *保存
	 *
	 */
	public Integer  save${className}(${className} entity ) throws Exception;
	/**
	 *修改
	 *
	 */
	public Integer update${className}ById(${className} entity ) throws Exception;
	
	/**
	 * 根据ID查找
	 * @param id
	 * @return
	 * @throws Exception
	 */
	${className} select${className}ById(Object id);
	
	/**
	 *查询分页列表信息
	 *@param page
	 *@param queryMap
	 *@return page
	 */
	Page<${className}> query${className}Page(Page<${className}> page, Map<String,Object> queryMap);
	
	/**
	 *删除
	 *
	 */
	Integer delete${className}ById(Object id);
	
		
}
