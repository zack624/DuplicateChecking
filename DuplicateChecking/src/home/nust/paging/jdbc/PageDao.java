/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.nust.paging.jdbc;

import home.nust.paging.model.DuplicateChecking;
import java.util.List;
/**
 *
 * @author zack
 */
public interface PageDao {
    public int getCount();
    public List<DuplicateChecking> getPage(int currentPage,int everyPageRecord);
}
