package com.zheng.consts;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-22.
 */
public enum FlowStateEnum {
    NO_EXCEUTE("0","为执行"),
    EXCEUTE("1","执行中"),
    END("2","执行结束");
    private String Code;

    private String Desc;

    FlowStateEnum(String code, String desc){
        this.Code = code;
        this.Desc =desc;
    }

    public String getCode() {
        return Code;
    }
}
