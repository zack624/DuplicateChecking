package home.nust.dc.service;

import home.nust.dc.entity.Duplicatechecking;
import home.nust.paging.model.Page;

public interface DuplicateCheckingService {
	
	public Duplicatechecking getById(Long id);
	
	/**
	 * 构造页对象，存储每一页的属性和记录
	 * @param currentPageIndex
	 * @param everyPageRecordCount
	 * @return
	 */
	public Page<Duplicatechecking> getPage(int currentPageIndex,int everyPageRecordCount);
}
