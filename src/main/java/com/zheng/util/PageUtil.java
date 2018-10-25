package com.zheng.util;

import com.zheng.bean.PageBean;

import java.util.List;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-25.
 */
public class PageUtil {

    /**
     * 组装返回数据
     * @param page
     * @param selectdata
     * @param pageSize
     * @param dataCount
     * @return
     */
    public static PageBean  buildPageBean(Integer  page,List selectdata,Integer  pageSize,List  dataCount){
        PageBean pageBean = new PageBean();
        pageBean.setPageData(selectdata);
        pageBean.setCurrentPage(page);
        if(pageSize!=null){
            pageBean.setPageSize(pageSize);
        }
        Integer   pageCount =dataCount.size()< pageBean.getPageSize()?0:dataCount.size()/pageBean.getPageSize();
        Integer   mod = Math.floorMod(dataCount.size(),pageSize);
        pageBean.setPageCount(mod>0?pageCount+1:pageCount);
        return pageBean;
    }
}
