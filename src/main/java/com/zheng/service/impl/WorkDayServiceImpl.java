package com.zheng.service.impl;

import com.zheng.bean.DateTimeBean;
import com.zheng.service.WorkDayService;
import org.springframework.stereotype.Service;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-23.
 */
@Service
public class WorkDayServiceImpl  implements WorkDayService {
    @Override
    public DateTimeBean getCurrentWorkDate(String requestDate, String requestTime) {
        DateTimeBean  dateTimeBean = new DateTimeBean();
        dateTimeBean.setTradeDate(requestDate);
        dateTimeBean.setTradeTime(requestTime);
        return dateTimeBean;
    }
}
