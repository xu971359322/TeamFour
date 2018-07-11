package org.java.entity;

public class Leverclient {
    private Integer lvId;

    private String lvName;

    public Integer getLvId() {
        return lvId;
    }

    public void setLvId(Integer lvId) {
        this.lvId = lvId;
    }

    public String getLvName() {
        return lvName;
    }

    public void setLvName(String lvName) {
        this.lvName = lvName == null ? null : lvName.trim();
    }
}