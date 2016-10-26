/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.nust.paging.service;

import home.nust.paging.model.DuplicateChecking;
import home.nust.paging.model.Page;

/**
 *
 * @author zack
 */
public interface PageService {
    public Page<DuplicateChecking> getPage(int currentPage,int everyPageRecord);
}
