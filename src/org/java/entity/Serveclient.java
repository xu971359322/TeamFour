package org.java.entity;

import java.io.Serializable;
import java.util.Date;

public class Serveclient implements Serializable{
    private Integer scId;

    private String scDescribe;

    private Date scSettime;

    private Integer scStatus;

    private Integer sdId;

    private String uid;

    private String cid;

    private String sdRequest;

    @Override
    public String toString() {
        return "Serveclient{" +
                "scId=" + scId +
                ", scDescribe='" + scDescribe + '\'' +
                ", scSettime=" + scSettime +
                ", scStatus=" + scStatus +
                ", sdId=" + sdId +
                ", uid='" + uid + '\'' +
                ", cid='" + cid + '\'' +
                ", sdRequest='" + sdRequest + '\'' +
                '}';
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getSdRequest() {
        return sdRequest;
    }

    public void setSdRequest(String sdRequest) {
        this.sdRequest = sdRequest;
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getScDescribe() {
        return scDescribe;
    }

    public void setScDescribe(String scDescribe) {
        this.scDescribe = scDescribe == null ? null : scDescribe.trim();
    }

    public Date getScSettime() {
        return scSettime;
    }

    public void setScSettime(Date scSettime) {
        this.scSettime = scSettime;
    }

    public Integer getScStatus() {
        return scStatus;
    }

    public void setScStatus(Integer scStatus) {
        this.scStatus = scStatus;
    }

    public Integer getSdId() {
        return sdId;
    }

    public void setSdId(Integer sdId) {
        this.sdId = sdId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }
}