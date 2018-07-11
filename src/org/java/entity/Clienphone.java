package org.java.entity;

public class Clienphone {
    private Integer cpId;

    private String cpName;

    private String cpGender;

    private String cpPost;

    private String cpTel;

    private String cpPhone;

    private String cpRamark;

    private String cid;

    public Integer getCpId() {
        return cpId;
    }

    public void setCpId(Integer cpId) {
        this.cpId = cpId;
    }

    public String getCpName() {
        return cpName;
    }

    public void setCpName(String cpName) {
        this.cpName = cpName == null ? null : cpName.trim();
    }

    public String getCpGender() {
        return cpGender;
    }

    public void setCpGender(String cpGender) {
        this.cpGender = cpGender == null ? null : cpGender.trim();
    }

    public String getCpPost() {
        return cpPost;
    }

    public void setCpPost(String cpPost) {
        this.cpPost = cpPost == null ? null : cpPost.trim();
    }

    public String getCpTel() {
        return cpTel;
    }

    public void setCpTel(String cpTel) {
        this.cpTel = cpTel == null ? null : cpTel.trim();
    }

    public String getCpPhone() {
        return cpPhone;
    }

    public void setCpPhone(String cpPhone) {
        this.cpPhone = cpPhone == null ? null : cpPhone.trim();
    }

    public String getCpRamark() {
        return cpRamark;
    }

    public void setCpRamark(String cpRamark) {
        this.cpRamark = cpRamark == null ? null : cpRamark.trim();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid == null ? null : cid.trim();
    }
}