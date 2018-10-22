package com.zheng.entity;

import java.util.Date;

public class CustInfoEntity {
    private Integer objid;

    private String custno;

    private String custtype;

    private String billpath;

    private String billway;

    private String identityno;

    private String identitytype;

    private String customname;

    private String timelimited;

    private String address;

    private String faxno;

    private String zipno;

    private String phone;

    private String email;

    private String shacco;

    private String szacco;

    private String state;

    private Date createtimestamp;

    private Date updatetimestamp;

    private Integer version;

    private String entityname;

    private String shortname;

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

    public String getCusttype() {
        return custtype;
    }

    public void setCusttype(String custtype) {
        this.custtype = custtype == null ? null : custtype.trim();
    }

    public String getBillpath() {
        return billpath;
    }

    public void setBillpath(String billpath) {
        this.billpath = billpath == null ? null : billpath.trim();
    }

    public String getBillway() {
        return billway;
    }

    public void setBillway(String billway) {
        this.billway = billway == null ? null : billway.trim();
    }

    public String getIdentityno() {
        return identityno;
    }

    public void setIdentityno(String identityno) {
        this.identityno = identityno == null ? null : identityno.trim();
    }

    public String getIdentitytype() {
        return identitytype;
    }

    public void setIdentitytype(String identitytype) {
        this.identitytype = identitytype == null ? null : identitytype.trim();
    }

    public String getCustomname() {
        return customname;
    }

    public void setCustomname(String customname) {
        this.customname = customname == null ? null : customname.trim();
    }

    public String getTimelimited() {
        return timelimited;
    }

    public void setTimelimited(String timelimited) {
        this.timelimited = timelimited == null ? null : timelimited.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getFaxno() {
        return faxno;
    }

    public void setFaxno(String faxno) {
        this.faxno = faxno == null ? null : faxno.trim();
    }

    public String getZipno() {
        return zipno;
    }

    public void setZipno(String zipno) {
        this.zipno = zipno == null ? null : zipno.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getShacco() {
        return shacco;
    }

    public void setShacco(String shacco) {
        this.shacco = shacco == null ? null : shacco.trim();
    }

    public String getSzacco() {
        return szacco;
    }

    public void setSzacco(String szacco) {
        this.szacco = szacco == null ? null : szacco.trim();
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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }
}