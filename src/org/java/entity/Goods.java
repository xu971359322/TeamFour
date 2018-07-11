package org.java.entity;

public class Goods {
    private String gid;

    private String gname;

    private String gtype;

    private Integer glever;

    private Double gprice;

    private String gremark;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid == null ? null : gid.trim();
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname == null ? null : gname.trim();
    }

    public String getGtype() {
        return gtype;
    }

    public void setGtype(String gtype) {
        this.gtype = gtype == null ? null : gtype.trim();
    }

    public Integer getGlever() {
        return glever;
    }

    public void setGlever(Integer glever) {
        this.glever = glever;
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public String getGremark() {
        return gremark;
    }

    public void setGremark(String gremark) {
        this.gremark = gremark == null ? null : gremark.trim();
    }
}