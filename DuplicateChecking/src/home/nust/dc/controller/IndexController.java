package home.nust.dc.controller;

import java.util.ArrayList;
import java.util.List;

import home.nust.dc.constant.PageConstant;
import home.nust.dc.entity.Duplicatechecking;
import home.nust.dc.service.DuplicateCheckingService;
import home.nust.paging.model.Page;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@Resource(name="duplicateCheckingService")
	private DuplicateCheckingService duplicateCheckingService;
	
	@RequestMapping("index")
	public String getDCPage(Integer currentPage,ModelMap map){
		if(null == currentPage)
			currentPage = 1;
		Page<Duplicatechecking> page = duplicateCheckingService.getPage(currentPage, PageConstant.EVERY_PAGE_RECORD_COUNT);
		map.put("page",page);
		return "index";
	}
	
	@RequestMapping("DCChart")
	public String DCChart(){
		return "chart";
	}
	
	/**
	 * 处理Ajax请求，返回dc表各专业抽捡学生数量数据
	 * @return
	 */
	@RequestMapping("showDCChart")
	public @ResponseBody List showDCChart(){
		@SuppressWarnings("unchecked")
		List<Object[]> list = duplicateCheckingService.getStuCountOfMajor();
		return list;
	}
	
}
