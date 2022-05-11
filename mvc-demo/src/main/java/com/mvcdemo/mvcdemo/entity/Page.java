package com.mvcdemo.mvcdemo.entity;

import java.util.List;

public class Page<T> {

    private int pageCount;
    private int recordCount;
    private int currentPage;
    private int pageSize;
    private List<T> entityList;

    public Page(int pageCount, int recordCount, int currentPage, int pageSize, List<T> entityList) {
        this.pageCount = pageCount;
        this.recordCount = recordCount;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.entityList = entityList;
    }
    public Page(){}

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getCurrentRecordCount() {
        return pageSize;
    }

    public void setCurrentRecordCount(int currentRecordCount) {
        this.pageSize = currentRecordCount;
    }

    public List<T> getEntityList() {
        return entityList;
    }

    public void setEntityList(List<T> entityList) {
        this.entityList = entityList;
    }
}
