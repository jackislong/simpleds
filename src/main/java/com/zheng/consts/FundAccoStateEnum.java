package com.zheng.consts;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-23.
 */
public enum FundAccoStateEnum {
    NORAML("0","正常"),
    NEW("1","新开户"),
    REGIST("2","账户登记"),
    DESTROYING("5","正在销户"),
    DESTROIED("6","销户"),
    LOSTED("A","挂号");

    private String code;

    private String desc;

    FundAccoStateEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }
}
