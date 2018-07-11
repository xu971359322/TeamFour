package org.java.entity;

import java.util.Date;

public class Chance {
    private Integer chId;

    private Date chTime;

    private String cid;

    private String uid;

    public Integer getChId() {
        return chId;
    }

    public void setChId(Integer chId) {
        this.chId = chId;
    }

    public Date getChTime() {
        return chTime;
    }

    public void setChTime(Date chTime) {
        this.chTime = chTime;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }
}