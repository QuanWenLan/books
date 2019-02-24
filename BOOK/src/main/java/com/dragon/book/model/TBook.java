package com.dragon.book.model;

public class TBook {
	

	@Override
	public String toString() {
		return "TBook [id=" + id + ", isbn=" + isbn + ", sm=" + sm + ", pubId="
				+ pubId + ", cbrq=" + cbrq + ", zz=" + zz + ", typeId="
				+ typeId + ", tsdl=" + tsdl + ", rkrq=" + rkrq + ", status="
				+ status + ", cs=" + cs + ", tPublish=" + tPublish + ", tType="
				+ tType + "]";
	}

	private String id;

	private String isbn;

	private String sm;

	private String pubId;

	private String cbrq;

	private String zz;

	private Integer typeId;

	private String tsdl;

	private String rkrq;

	private Integer status;

	private Integer cs;
	
	private TPublish tPublish;
	
	private TType tType;

	public TPublish gettPublish() {
		return tPublish;
	}

	public void settPublish(TPublish tPublish) {
		this.tPublish = tPublish;
	}

	public TType gettType() {
		return tType;
	}

	public void settType(TType tType) {
		this.tType = tType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

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

	public String getPubId() {
		return pubId;
	}

	public void setPubId(String pubId) {
		this.pubId = pubId == null ? null : pubId.trim();
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

	public String getRkrq() {
		return rkrq;
	}

	public void setRkrq(String rkrq) {
		this.rkrq = rkrq == null ? null : rkrq.trim();
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getCs() {
		return cs;
	}

	public void setCs(Integer cs) {
		this.cs = cs;
	}
}