package org.java.entity;

import java.util.Date;

//模糊查询字段封装
public class SelService {
    private String cid;
    private String content;
    private Integer sdId;
    private Date beginTime;
    private Date endTime;
    private Integer scstatus;
    private String uid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Integer getScstatus() {
        return scstatus;
    }

    public void setScstatus(Integer scstatus) {
        this.scstatus = scstatus;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getSdId() {
        return sdId;
    }

    public void setSdId(Integer sdId) {
        this.sdId = sdId;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "SelService{" +
                "cid='" + cid + '\'' +
                ", content='" + content + '\'' +
                ", sdId=" + sdId +
                ", beginTime=" + beginTime +
                ", endTime=" + endTime +
                ", scstatus=" + scstatus +
                ", uid='" + uid + '\'' +
                '}';
    }
}
