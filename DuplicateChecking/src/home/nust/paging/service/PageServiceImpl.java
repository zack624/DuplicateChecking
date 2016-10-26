/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.nust.paging.service;

import home.nust.paging.jdbc.PageDao;
import home.nust.paging.jdbc.PageDaoImpl;
import home.nust.paging.model.DuplicateChecking;
import home.nust.paging.model.Page;

/**
 *
 * @author zack
 */
public class PageServiceImpl implements PageService{
    
    PageDao pageDao = new PageDaoImpl();
    
    public Page getPage(int currentPage,int everyPageRecord){
        int count = pageDao.getCount();
        Page<DuplicateChecking> page = new Page(currentPage,everyPageRecord,count);
        page.setRecords(pageDao.getPage(currentPage, everyPageRecord));
        return page;
    }
}
