package org.java.entity;

import java.io.Serializable;
import java.util.Date;

public class Serveallocation  implements Serializable {
    private Integer saId;

    private Date saTime;

    private Integer scId;

    private String uid;

    @Override
    public String toString() {
        return "Serveallocation{" +
                "saId=" + saId +
                ", saTime=" + saTime +
                ", scId=" + scId +
                ", uid='" + uid + '\'' +
                '}';
    }

    public Integer getSaId() {
        return saId;
    }

    public void setSaId(Integer saId) {
        this.saId = saId;
    }

    public Date getSaTime() {
        return saTime;
    }

    public void setSaTime(Date saTime) {
        this.saTime = saTime;
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }
}