package com.zheng.consts;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-23.
 */
public enum  CustInfoSateEnum {
    NORMAL("0","正常"),
    CANCELLATION("1","销户");

    private String code;

    private String desc;

    CustInfoSateEnum(String  code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
