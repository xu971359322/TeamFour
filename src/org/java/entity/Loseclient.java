package org.java.entity;

import java.util.Date;

public class Loseclient {
    private Integer lcId;

    private String lcContent;

    private Date lcTime;

    private String cid;

    public Integer getLcId() {
        return lcId;
    }

    public void setLcId(Integer lcId) {
        this.lcId = lcId;
    }

    public String getLcContent() {
        return lcContent;
    }

    public void setLcContent(String lcContent) {
        this.lcContent = lcContent == null ? null : lcContent.trim();
    }

    public Date getLcTime() {
        return lcTime;
    }

    public void setLcTime(Date lcTime) {
        this.lcTime = lcTime;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }
}