<#assign myParentDir="dao">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>  
package ${basepackage}.${table.classNameFirstLower}.dao;

import ${basepackage}.${table.classNameFirstLower}.entity.${className};
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

<#include "/copyright_class.include" >
@Mapper
public interface ${className}Dao{
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
	 * 根据Map查找
	 * @param queryMap
	 * @return list
	 * @throws Exception
	 */
	List<${className}> select${className}ListByMap(Map<String,Object> queryMap);
	
	/**
	 *删除
	 *
	 */
	Integer delete${className}ById(Object id);
	
}
