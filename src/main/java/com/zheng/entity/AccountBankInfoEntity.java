package com.zheng.entity;

import java.util.Date;

public class AccountBankInfoEntity {
    private Integer objid;

    private String custno;

    private String idcode;

    private String bankno;

    private String bankacco;

    private String bankname;

    private String nameinbank;

    private String capitalmode;

    private String provinceno;

    private String cityno;

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

    public String getCustno() {
        return custno;
    }

    public void setCustno(String custno) {
        this.custno = custno == null ? null : custno.trim();
    }

    public String getIdcode() {
        return idcode;
    }

    public void setIdcode(String idcode) {
        this.idcode = idcode == null ? null : idcode.trim();
    }

    public String getBankno() {
        return bankno;
    }

    public void setBankno(String bankno) {
        this.bankno = bankno == null ? null : bankno.trim();
    }

    public String getBankacco() {
        return bankacco;
    }

    public void setBankacco(String bankacco) {
        this.bankacco = bankacco == null ? null : bankacco.trim();
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname == null ? null : bankname.trim();
    }

    public String getNameinbank() {
        return nameinbank;
    }

    public void setNameinbank(String nameinbank) {
        this.nameinbank = nameinbank == null ? null : nameinbank.trim();
    }

    public String getCapitalmode() {
        return capitalmode;
    }

    public void setCapitalmode(String capitalmode) {
        this.capitalmode = capitalmode == null ? null : capitalmode.trim();
    }

    public String getProvinceno() {
        return provinceno;
    }

    public void setProvinceno(String provinceno) {
        this.provinceno = provinceno == null ? null : provinceno.trim();
    }

    public String getCityno() {
        return cityno;
    }

    public void setCityno(String cityno) {
        this.cityno = cityno == null ? null : cityno.trim();
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