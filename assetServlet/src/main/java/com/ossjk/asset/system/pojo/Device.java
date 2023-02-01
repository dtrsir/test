package com.ossjk.asset.system.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Device implements Serializable {

	/**
	* 
	*/
	private BigDecimal id;
	/**
	 * 组织机构id
	 */
	private String ogid;
	/**
	 * 设备类型id
	 */
	private String dtid;
	/**
	 * 设备流水号
	 */
	private String code;
	/**
	 * 净残值
	 */
	private BigDecimal residual;
	/**
	 * 原值
	 */
	private BigDecimal original;
	/**
	 * 状态 1-入库、2-出库中、3-出库、4-领用、5-报修
	 */
	private BigDecimal status;
	/**
	 * 生产日期
	 */
	private Date proddate;
	/**
	 * 登记人
	 */
	private String creator;
	/**
	 * 登记时间
	 */
	private Date createtime;
	/**
	 * 购买人
	 */
	private String buyer;
	/**
	 * 购买日期
	 */
	private Date bugdate;
	/**
	 * 序列号
	 */
	private String sno;
	/**
	 * 创建时间
	 */
	private Date crtm;
	/**
	 * 修改时间
	 */
	private Date mdtm;
	
	public BigDecimal getId() {
		return id;
	}

	public String getOgid() {
		return ogid;
	}

	public String getDtid() {
		return dtid;
	}

	public String getCode() {
		return code;
	}

	public BigDecimal getResidual() {
		return residual;
	}

	public BigDecimal getOriginal() {
		return original;
	}

	public BigDecimal getStatus() {
		return status;
	}

	public Date getProddate() {
		return proddate;
	}

	public String getCreator() {
		return creator;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public String getBuyer() {
		return buyer;
	}

	public Date getBugdate() {
		return bugdate;
	}

	public String getSno() {
		return sno;
	}

	public Date getCrtm() {
		return crtm;
	}

	public Date getMdtm() {
		return mdtm;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public void setOgid(String ogid) {
		this.ogid = ogid;
	}

	public void setDtid(String dtid) {
		this.dtid = dtid;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setResidual(BigDecimal residual) {
		this.residual = residual;
	}

	public void setOriginal(BigDecimal original) {
		this.original = original;
	}

	public void setStatus(BigDecimal status) {
		this.status = status;
	}

	public void setProddate(Date proddate) {
		this.proddate = proddate;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public void setBugdate(Date bugdate) {
		this.bugdate = bugdate;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public void setCrtm(Date crtm) {
		this.crtm = crtm;
	}

	public void setMdtm(Date mdtm) {
		this.mdtm = mdtm;
	}

}