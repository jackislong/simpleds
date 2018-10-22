package com.zheng.entity;

import java.util.Date;

public class CustPassWordEntity {
    private Integer objid;

    private String custno;

    private String dealpassword;

    private Integer dealpassworderr;

    private Date lockdate;

    private Date createtimestamp;

    private Date updatetimestamp;

    private Integer version;

    private String entityname;

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

    public String getDealpassword() {
        return dealpassword;
    }

    public void setDealpassword(String dealpassword) {
        this.dealpassword = dealpassword == null ? null : dealpassword.trim();
    }

    public Integer getDealpassworderr() {
        return dealpassworderr;
    }

    public void setDealpassworderr(Integer dealpassworderr) {
        this.dealpassworderr = dealpassworderr;
    }

    public Date getLockdate() {
        return lockdate;
    }

    public void setLockdate(Date lockdate) {
        this.lockdate = lockdate;
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
}