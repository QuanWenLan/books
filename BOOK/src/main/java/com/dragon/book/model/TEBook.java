package com.dragon.book.model;

import java.util.Date;

public class TEBook {
    private String eBookId;

    private String eBookXm;

    private Integer typeId;

    private String wjdz;

    private String ms;

    private Date scsj;

    private String xzsj;

    private String tszl;

    public String geteBookId() {
        return eBookId;
    }

    public void seteBookId(String eBookId) {
        this.eBookId = eBookId == null ? null : eBookId.trim();
    }

    public String geteBookXm() {
        return eBookXm;
    }

    public void seteBookXm(String eBookXm) {
        this.eBookXm = eBookXm == null ? null : eBookXm.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getWjdz() {
        return wjdz;
    }

    public void setWjdz(String wjdz) {
        this.wjdz = wjdz == null ? null : wjdz.trim();
    }

    public String getMs() {
        return ms;
    }

    public void setMs(String ms) {
        this.ms = ms == null ? null : ms.trim();
    }

    public Date getScsj() {
        return scsj;
    }

    public void setScsj(Date scsj) {
        this.scsj = scsj;
    }

    public String getXzsj() {
        return xzsj;
    }

    public void setXzsj(String xzsj) {
        this.xzsj = xzsj == null ? null : xzsj.trim();
    }

    public String getTszl() {
        return tszl;
    }

    public void setTszl(String tszl) {
        this.tszl = tszl == null ? null : tszl.trim();
    }
}