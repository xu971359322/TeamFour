package org.java.entity;

import java.util.Date;

public class Orders {
    private String oid;

    private Date otime;

    private String opath;

    private Integer ostutas;

    private Integer ocount;

    private String cid;

    private String gid;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public String getOpath() {
        return opath;
    }

    public void setOpath(String opath) {
        this.opath = opath == null ? null : opath.trim();
    }

    public Integer getOstutas() {
        return ostutas;
    }

    public void setOstutas(Integer ostutas) {
        this.ostutas = ostutas;
    }

    public Integer getOcount() {
        return ocount;
    }

    public void setOcount(Integer ocount) {
        this.ocount = ocount;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }
}