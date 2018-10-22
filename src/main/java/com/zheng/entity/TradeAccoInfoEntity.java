package com.zheng.entity;

import java.util.Date;

public class TradeAccoInfoEntity {
    private Integer objid;

    private String custno;

    private String tradeacco;

    private String acconame;

    private String opendate;

    private String state;

    private Date createtimestamp;

    private Date updatetimestamp;

    private Integer version;

    private String entityname;

    private String capitalmode;

    public Integer getObjid() {
        return objid;
    }

    public void setObjid(Integer objid) {
        this.objid = objid;
    }

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno == null ? null : custno.trim();
    }

    public String getTradeacco() {
        return tradeacco;
    }

    public void setTradeacco(String tradeacco) {
        this.tradeacco = tradeacco == null ? null : tradeacco.trim();
    }

    public String getAcconame() {
        return acconame;
    }

    public void setAcconame(String acconame) {
        this.acconame = acconame == null ? null : acconame.trim();
    }

    public String getOpendate() {
        return opendate;
    }

    public void setOpendate(String opendate) {
        this.opendate = opendate == null ? null : opendate.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public Date getCreatetimestamp() {
        return createtimestamp;
    }

    public void setCreatetimestamp(Date createtimestamp) {
        this.createtimestamp = createtimestamp;
    }

    public Date getUpdatetimestamp() {
        return updatetimestamp;
    }

    public void setUpdatetimestamp(Date updatetimestamp) {
        this.updatetimestamp = updatetimestamp;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getEntityname() {
        return entityname;
    }

    public void setEntityname(String entityname) {
        this.entityname = entityname == null ? null : entityname.trim();
    }

    public String getCapitalmode() {
        return capitalmode;
    }

    public void setCapitalmode(String capitalmode) {
        this.capitalmode = capitalmode == null ? null : capitalmode.trim();
    }
}