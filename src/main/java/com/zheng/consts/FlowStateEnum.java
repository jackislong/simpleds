package com.zheng.consts;

/**
 * describle
 *
 * @author Administrator
 * @date 2018-10-22.
 */
public enum FlowStateEnum {
    NO_EXCEUTE(0,"为执行"),
    EXCEUTE(1,"执行中"),
    END(2,"执行结束");
    private Integer Code;

    private String Desc;

    FlowStateEnum(Integer code, String desc){
        this.Code = code;
        this.Desc =desc;
    }

    public Integer getCode() {
        return Code;
    }
}
