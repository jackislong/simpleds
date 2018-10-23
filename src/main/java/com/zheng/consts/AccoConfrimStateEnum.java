package com.zheng.consts;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-23.
 */
public enum  AccoConfrimStateEnum {

     FALSE("0","确认失败"),
     SUCCESS("1","确认成功"),
     RILLBACK("4","撤单"),
     UNCONFRIM("9","未确认");
    private String code;

    private String desc;

    AccoConfrimStateEnum(String code,String desc){
        this.code =code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }
}
