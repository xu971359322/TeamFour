package org.java.entity;

import java.util.Date;

public class Contact {
    private Integer coId;

    private Date coTime;

    private String coPath;

    private String coDescribe;

    private String coRamark;

    private String coDetail;

    private String cid;

    public Integer getCoId() {
        return coId;
    }

    public void setCoId(Integer coId) {
        this.coId = coId;
    }

    public Date getCoTime() {
        return coTime;
    }

    public void setCoTime(Date coTime) {
        this.coTime = coTime;
    }

    public String getCoPath() {
        return coPath;
    }

    public void setCoPath(String coPath) {
        this.coPath = coPath == null ? null : coPath.trim();
    }

    public String getCoDescribe() {
        return coDescribe;
    }

    public void setCoDescribe(String coDescribe) {
        this.coDescribe = coDescribe == null ? null : coDescribe.trim();
    }

    public String getCoRamark() {
        return coRamark;
    }

    public void setCoRamark(String coRamark) {
        this.coRamark = coRamark == null ? null : coRamark.trim();
    }

    public String getCoDetail() {
        return coDetail;
    }

    public void setCoDetail(String coDetail) {
        this.coDetail = coDetail == null ? null : coDetail.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }
}