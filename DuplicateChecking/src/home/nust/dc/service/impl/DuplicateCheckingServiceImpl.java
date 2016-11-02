package home.nust.dc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import home.nust.dc.dao.DuplicateCheckingDao;
import home.nust.dc.entity.Duplicatechecking;
import home.nust.dc.service.DuplicateCheckingService;
import home.nust.paging.model.Page;

@Component("duplicateCheckingService")
public class DuplicateCheckingServiceImpl implements DuplicateCheckingService {

	@Resource(name="duplicateCheckingDao")
	private DuplicateCheckingDao duplicateCheckingDao;
	
	@Override
	public Duplicatechecking getById(Long id) {
		return duplicateCheckingDao.findById(id);
	}

	@Override
	public Page<Duplicatechecking> getPage(int currentPageIndex,
			int everyPageRecordCount) {
		int count = duplicateCheckingDao.findCount();
		Page<Duplicatechecking> page = new Page<>(currentPageIndex, everyPageRecordCount, count);
		List<Duplicatechecking> dcList = duplicateCheckingDao.findByCurrentPage(currentPageIndex, everyPageRecordCount);
		page.setRecords(dcList);
		return page;
	}

}
