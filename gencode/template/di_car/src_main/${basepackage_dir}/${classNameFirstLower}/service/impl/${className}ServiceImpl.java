<#assign myParentDir="service.impl">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>  
package ${basepackage}.${table.classNameFirstLower}.service.impl;


import ${basepackage}.${table.classNameFirstLower}.entity.${className};
import ${basepackage}.${table.classNameFirstLower}.service.${className}Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ${basepackage}.common.util.Page;
import java.util.List;
import java.util.Map;

import ${basepackage}.${table.classNameFirstLower}.dao.${className}Dao;



<#include "/copyright_class.include" >
@Service("${classNameLower}Service")
public class ${className}ServiceImpl implements ${className}Service {
	@Autowired
    private ${className}Dao ${classNameLower}Dao;
   
    @Override
	public Integer  save${className}(${className} entity ) throws Exception{
	       return ${classNameLower}Dao.save${className}(entity);
	}

	
	@Override
    public Integer update${className}ById(${className} entity ) throws Exception{
	return ${classNameLower}Dao.update${className}ById(entity);
    }
	
    @Override
	public ${className} select${className}ById(Object id){
	 return ${classNameLower}Dao.select${className}ById(id);
	}
	
	@Override
	public Page<${className}> query${className}Page(Page<${className}> page, Map<String,Object> queryMap){
		
		List<${className}> list = ${classNameLower}Dao.select${className}ListByMap(queryMap);
		page.setTotalCount(list.size());
		page.setResult(list);
		return page;
		
	}
	
	@Override
	public Integer delete${className}ById(Object id){
		return ${classNameLower}Dao.delete${className}ById(id);
	}


}
