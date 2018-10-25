package com.zheng.bean;

import java.util.List;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-25.
 */
public class PageBean {
    private Integer  pageSize = 10;
    private Integer  currentPage = 1;
    private Integer  pageCount = 1;
    private List  pageData;

    public PageBean(){};


    public PageBean(Integer  pageCount,Integer currentPage,Integer pageSize,List pageData){
        this.currentPage =currentPage;
        this.pageCount = pageCount;
        this.pageData = pageData;
        this.pageSize = pageSize;
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public List getPageData() {
        return pageData;
    }

    public void setPageData(List pageData) {
        this.pageData = pageData;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }
}
