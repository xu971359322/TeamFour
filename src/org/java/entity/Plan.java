package org.java.entity;

import java.util.Date;

public class Plan {
    private Integer pid;

    private String pcontent;

    private Date ptime;

    private String presult;

    private String cid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent == null ? null : pcontent.trim();
    }

    public Date getPtime() {
        return ptime;
    }

    public void setPtime(Date ptime) {
        this.ptime = ptime;
    }

    public String getPresult() {
        return presult;
    }

    public void setPresult(String presult) {
        this.presult = presult == null ? null : presult.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }
}