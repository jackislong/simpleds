package com.zheng.entity;

import java.util.Date;

public class FundAccoInfoEntity {
    private Integer objid;

    private String custno;

    private String fundacco;

    private String opendate;

    private String tacode;

    private Date createtimestamp;

    private Date updatetimestamp;

    private Integer version;

    private String entityname;

    private String state;

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

    public String getFundacco() {
        return fundacco;
    }

    public void setFundacco(String fundacco) {
        this.fundacco = fundacco == null ? null : fundacco.trim();
    }

    public String getOpendate() {
        return opendate;
    }

    public void setOpendate(String opendate) {
        this.opendate = opendate == null ? null : opendate.trim();
    }

    public String getTacode() {
        return tacode;
    }

    public void setTacode(String tacode) {
        this.tacode = tacode == null ? null : tacode.trim();
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}