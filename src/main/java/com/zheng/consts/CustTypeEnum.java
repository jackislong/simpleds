package com.zheng.consts;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-23.
 */
public enum CustTypeEnum {
    PERSON("0","个人"),
    ORG("1","机构");

    private  String code;

    private  String  desc;
    CustTypeEnum(String code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }
}
