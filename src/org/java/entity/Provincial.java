package org.java.entity;

public class Provincial {
    private Integer pid;

    private String provincial;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getProvincial() {
        return provincial;
    }

    public void setProvincial(String provincial) {
        this.provincial = provincial == null ? null : provincial.trim();
    }
}