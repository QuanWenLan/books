package com.dragon.book.model;

public class TBook {

    @Override
    public String toString() {
        return "TBook{" +
                "isbn='" + isbn + '\'' +
                ", sm='" + sm + '\'' +
                ", cbsmc='" + cbsmc + '\'' +
                ", cbrq='" + cbrq + '\'' +
                ", zz='" + zz + '\'' +
                ", typeId=" + typeId +
                ", tsdl='" + tsdl + '\'' +
                ", picture='" + picture + '\'' +
                ", jj='" + jj + '\'' +
                '}';
    }

    private String isbn;

    private String sm;

    private String cbsmc;

    private String cbrq;

    private String zz;

    private Integer typeId;

    private String tsdl;

    private String picture;

    private String jj;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm == null ? null : sm.trim();
    }

    public String getCbsmc() {
        return cbsmc;
    }

    public void setCbsmc(String cbsmc) {
        this.cbsmc = cbsmc == null ? null : cbsmc.trim();
    }

    public String getCbrq() {
        return cbrq;
    }

    public void setCbrq(String cbrq) {
        this.cbrq = cbrq == null ? null : cbrq.trim();
    }

    public String getZz() {
        return zz;
    }

    public void setZz(String zz) {
        this.zz = zz == null ? null : zz.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTsdl() {
        return tsdl;
    }

    public void setTsdl(String tsdl) {
        this.tsdl = tsdl == null ? null : tsdl.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public String getJj() {
        return jj;
    }

    public void setJj(String jj) {
        this.jj = jj == null ? null : jj.trim();
    }
}