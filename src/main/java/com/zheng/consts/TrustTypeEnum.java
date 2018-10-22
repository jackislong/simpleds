package com.zheng.consts;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-22.
 */
public enum TrustTypeEnum {
    COUNTER(0,"柜台委托"),
    TELPHONE(1,"电话委托"),
    ONLINE(2,"网上委托"),
    SELF(3,"自助委托"),
    FAX(4,"传真委托");
    private Integer code;
    private String desc;
    TrustTypeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public Integer getCode() {
        return code;
    }
}
