package com.zheng.entity;

import java.util.Date;

public class DictionaryEntity {
    private Integer objid;

    private Integer canmodify;

    private String caption;

    private Integer keyno;

    private String keyvalue;

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

    public Integer getCanmodify() {
        return canmodify;
    }

    public void setCanmodify(Integer canmodify) {
        this.canmodify = canmodify;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption == null ? null : caption.trim();
    }

    public Integer getKeyno() {
        return keyno;
    }

    public void setKeyno(Integer keyno) {
        this.keyno = keyno;
    }

    public String getKeyvalue() {
        return keyvalue;
    }

    public void setKeyvalue(String keyvalue) {
        this.keyvalue = keyvalue == null ? null : keyvalue.trim();
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