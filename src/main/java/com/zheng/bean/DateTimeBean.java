package com.zheng.bean;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-23.
 */
public class DateTimeBean {

    /**
     * 当前交易日期
     */
    private String   tradeDate;

    /**
     * 当前交易时间
     */
    private String tradeTime;


    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getTradeTime() {
        return tradeTime;
    }

    public String getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(String tradeDate) {
        this.tradeDate = tradeDate;
    }
}
