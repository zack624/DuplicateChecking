/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package home.nust.paging.model;

import java.util.List;

/**
 *  页面对象
 * @author zack
 * @param <T>
 */
public class Page<T> {
    private int currentPage;
    private int everyPageRecord;
    private int totalRecord;
    private int totalPage;
    private List<T> records;

    public Page(int currentPage, int everyPageRecord, int totalRecord) {
        this.currentPage = currentPage;
        this.everyPageRecord = everyPageRecord;
        this.totalRecord = totalRecord;
        this.totalPage = totalRecord / everyPageRecord + 1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getEveryPageRecord() {
        return everyPageRecord;
    }

    public void setEveryPageRecord(int everyPageRecord) {
        this.everyPageRecord = everyPageRecord;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }
    
}
