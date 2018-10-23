package com.zheng.consts;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-23.
 */
public enum AccountStateEnum {
    NORMAL("0",""),
    CANCELLATION("1","");

    private String  code;

    private String desc;
    AccountStateEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }
}
