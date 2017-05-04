<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>  
<#assign classNameLowerCase = className?lower_case>
<#assign from = basepackage?last_index_of(".")>
<#assign rootPagefloder = basepackage?substring(basepackage?last_index_of(".")+1)>
<#assign pkJavaType = table.idColumn.javaType>  
package  ${basepackage}.${table.classNameFirstLower}.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

import ${basepackage}.${table.classNameFirstLower}.entity.${className};
import ${basepackage}.${table.classNameFirstLower}.service.${className}Service;
import ${basepackage}.common.util.Page;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.alibaba.fastjson.JSON;
<#assign myParentDir="web">


<#include "/copyright_class.include" >
@Controller
@RequestMapping(value="/${classNameLowerCase}")
public class ${className}Controller {
	 @Autowired
	private ${className}Service ${classNameLower}Service;
	
	/**
	 * 列表主页面
	 *
	 * @return string
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String ${classNameLower}Main(Map<String, Object> map) {
		Page<${className}> page = new Page<${className}>(10);
		Map<String, Object> queryMap=new HashMap<String, Object>();
		page = ${classNameLower}Service.query${className}Page(page, queryMap);
		List<${className}> list = page.getResult();
		map.put("list", list);
		map.put("page", page);
		return "page/${classNameLower}/${classNameLower}List";
	}
	
	/**
	 * 查询
	 *
	 * @return String
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String ${classNameLower}List(@ModelAttribute Page<${className}> page, Map<String, Object> map, @ModelAttribute ${className} ${classNameLower}) {		
		Map<String, Object> queryMap=new HashMap<String, Object>();
		queryMap.put("${classNameLower}",${classNameLower});
		page = ${classNameLower}Service.query${className}Page(page, queryMap);
		List<${className}> list = page.getResult();
		map.put("list", list);
		map.put("page", page);
		return "page/${classNameLower}/${classNameLower}Table";
	}
	
	/**
	 * 进入新增页面
	 *
	 * @return String
	 */
	@RequestMapping(value = "/addPage", method = RequestMethod.GET)
	public String ${classNameLower}AddPage() {
		
		return "page/${classNameLower}/${classNameLower}Add";
	}
	
	/**
	 * 提交新增
	 *
	 * @param ${classNameLower}
	 * @param request
	 * @return String
	 */
	@RequestMapping(value = "/${classNameLower}Add", method = RequestMethod.PUT, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ${classNameLower}Add(@ModelAttribute ${className} ${classNameLower}, HttpServletRequest request) throws Exception{
		String message="";
		Map<String, Object> result = new HashMap<String,Object>();
		
		int status = ${classNameLower}Service.save${className}(${classNameLower});

		if(status==0){
			result.put("status",0);
			result.put("message","新增失败！");
		}else{
			result.put("status",1);
			result.put("message","新增成功！");
		}
		message = JSON.toJSONString(result);
		return message;
	}
	
	/**
	 * 进入修改页面
	 *
	 * @param id
	 * @return String
	 */
	@RequestMapping(value = "/editPage/{id}", method = RequestMethod.GET)
	public String ${classNameLower}EditPage(Map<String, Object> map,@PathVariable String id) throws Exception{
		//获取实体基本信息
		${className} ${classNameLower} = ${classNameLower}Service.select${className}ById(Long.valueOf(id));
		map.put("${classNameLower}", ${classNameLower});

		return "page/${classNameLower}/${classNameLower}Edit";
	}
	
	/**
	 * 提交修改
	 *
	 * @param ${classNameLower}
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/${classNameLower}Edit", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ${classNameLower}Update(${className} ${classNameLower}, HttpServletRequest request) throws Exception{
		String message = "";
		Map<String, Object> result = new HashMap<String,Object>();
		
		int status = ${classNameLower}Service.update${className}ById(${classNameLower});
		
		if(status==0){
			result.put("status",0);
			result.put("message","修改失败！");
		}else{
			result.put("status",1);
			result.put("message","修改成功！");
		}
		message = JSON.toJSONString(result);
		return message;
	}
	
	/**
	 * 删除
	 *
	 * @param id
	 * @return String
	 */
	@RequestMapping(value = "/${classNameLower}Delete/{id}", method = RequestMethod.DELETE, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String ${classNameLower}Delete(@PathVariable String id) {
		String message = "";
		Map<String, Object> result = new HashMap<String,Object>();
		
		int status = ${classNameLower}Service.delete${className}ById(Long.valueOf(id));
		if(status==0){
			result.put("status",0);
			result.put("message","修改失败！");
		}else{
			result.put("status",1);
			result.put("message","删除成功！");
		}
		message = JSON.toJSONString(result);
		return message;
	}
}
