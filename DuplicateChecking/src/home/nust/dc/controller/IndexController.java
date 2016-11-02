package home.nust.dc.controller;

import home.nust.dc.constant.PageConstant;
import home.nust.dc.entity.Duplicatechecking;
import home.nust.dc.service.DuplicateCheckingService;
import home.nust.paging.model.Page;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Resource(name="duplicateCheckingService")
	private DuplicateCheckingService duplicateCheckingService;
	
	@RequestMapping("index")
	public String getDCPage(Integer currentPageIndex,ModelMap map){
		if(null == currentPageIndex)
			currentPageIndex = 1;
		Page<Duplicatechecking> page = duplicateCheckingService.getPage(currentPageIndex, PageConstant.EVERY_PAGE_RECORD_COUNT);
		map.put("page",page);
		return "index";
	}
}
