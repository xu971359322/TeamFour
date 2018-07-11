package org.java.entity;

public class Goodssave {
    private Integer gsId;

    private Integer gsCount;

    private String gsPath;

    private String gsDescribe;

    private Integer enId;

    private String gId;

    public Integer getGsId() {
        return gsId;
    }

    public void setGsId(Integer gsId) {
        this.gsId = gsId;
    }

    public Integer getGsCount() {
        return gsCount;
    }

    public void setGsCount(Integer gsCount) {
        this.gsCount = gsCount;
    }

    public String getGsPath() {
        return gsPath;
    }

    public void setGsPath(String gsPath) {
        this.gsPath = gsPath == null ? null : gsPath.trim();
    }

    public String getGsDescribe() {
        return gsDescribe;
    }

    public void setGsDescribe(String gsDescribe) {
        this.gsDescribe = gsDescribe == null ? null : gsDescribe.trim();
    }

    public Integer getEnId() {
        return enId;
    }

    public void setEnId(Integer enId) {
        this.enId = enId;
    }

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId == null ? null : gId.trim();
    }
}