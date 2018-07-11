package org.java.entity;

public class Servedetail {
    private Integer sdId;

    private String sdName;

    public Integer getSdId() {
        return sdId;
    }

    public void setSdId(Integer sdId) {
        this.sdId = sdId;
    }

    public String getSdName() {
        return sdName;
    }

    public void setSdName(String sdName) {
        this.sdName = sdName == null ? null : sdName.trim();
    }
}