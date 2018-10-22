package com.zheng.entity;

import java.util.Date;

public class DoprocessEntity {
    private Integer objid;

    private String beforeno;

    private String dependno;

    private String name;

    private String procedurename;

    private Integer serialno;

    private String state;

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

    public String getBeforeno() {
        return beforeno;
    }

    public void setBeforeno(String beforeno) {
        this.beforeno = beforeno == null ? null : beforeno.trim();
    }

    public String getDependno() {
        return dependno;
    }

    public void setDependno(String dependno) {
        this.dependno = dependno == null ? null : dependno.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getProcedurename() {
        return procedurename;
    }

    public void setProcedurename(String procedurename) {
        this.procedurename = procedurename == null ? null : procedurename.trim();
    }

    public Integer getSerialno() {
        return serialno;
    }

    public void setSerialno(Integer serialno) {
        this.serialno = serialno;
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
}