package com.dragon.book.model;

public class TSysUser {
    private Integer userId;

    private String sm;

    private String bm;

    private String pwd;

    private String lxfs;

    private String dz;

    private Integer isadmin;

    private Integer hmd;

    private String bookId;

    private Integer kjtscs;

    private Integer cs;

    private String grsm;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm == null ? null : sm.trim();
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm == null ? null : bm.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    public String getLxfs() {
        return lxfs;
    }

    public void setLxfs(String lxfs) {
        this.lxfs = lxfs == null ? null : lxfs.trim();
    }

    public String getDz() {
        return dz;
    }

    public void setDz(String dz) {
        this.dz = dz == null ? null : dz.trim();
    }

    public Integer getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(Integer isadmin) {
        this.isadmin = isadmin;
    }

    public Integer getHmd() {
        return hmd;
    }

    public void setHmd(Integer hmd) {
        this.hmd = hmd;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId == null ? null : bookId.trim();
    }

    public Integer getKjtscs() {
        return kjtscs;
    }

    public void setKjtscs(Integer kjtscs) {
        this.kjtscs = kjtscs;
    }

    public Integer getCs() {
        return cs;
    }

    public void setCs(Integer cs) {
        this.cs = cs;
    }

    public String getGrsm() {
        return grsm;
    }

    public void setGrsm(String grsm) {
        this.grsm = grsm == null ? null : grsm.trim();
    }
}