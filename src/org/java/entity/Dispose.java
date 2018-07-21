package org.java.entity;

import java.util.Date;

public class Dispose {
    private Integer diId;

    private Date diTime;

    private String diContent;

    private String diResult;

    private Integer faction;

    private Integer scId;

    private String uid;

    public Integer getDiId() {
        return diId;
    }

    public void setDiId(Integer diId) {
        this.diId = diId;
    }

    public Date getDiTime() {
        return diTime;
    }

    public void setDiTime(Date diTime) {
        this.diTime = diTime;
    }

    public String getDiContent() {
        return diContent;
    }

    public void setDiContent(String diContent) {
        this.diContent = diContent == null ? null : diContent.trim();
    }

    public String getDiResult() {
        return diResult;
    }

    public void setDiResult(String diResult) {
        this.diResult = diResult == null ? null : diResult.trim();
    }

    public Integer getFaction() {
        return faction;
    }

    public void setFaction(Integer faction) {
        this.faction = faction;
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

    @Override
    public String toString() {
        return "Dispose{" +
                "diId=" + diId +
                ", diTime=" + diTime +
                ", diContent='" + diContent + '\'' +
                ", diResult='" + diResult + '\'' +
                ", faction=" + faction +
                ", scId=" + scId +
                ", uid='" + uid + '\'' +
                '}';
    }
}