package com.zheng.service;

import com.zheng.bean.DateTimeBean;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-23.
 */
public interface WorkDayService {

    public DateTimeBean  getCurrentWorkDate(String  requestDate,String  requestTime);
}
