package com.zheng.consts;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-23.
 */
public enum DealFlagEnum {
    UNDEAL("0","未处理"),
    TRADEED("1","已处理");

    private String code;

    private String desc;

    DealFlagEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }
}
