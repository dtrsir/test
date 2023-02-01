package com.ossjk.asset.device.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Device implements Serializable {

	/**
	* 
	*/
	private  BigDecimal id;
	/**
	*组织机构id 
	*/
	private  BigDecimal ogid;
	/**
	*设备类型id 
	*/
	private  BigDecimal dtid;
	/**
	*设备流水号 
	*/
	private  String code;
	/**
	*净残值 
	*/
	private  BigDecimal residual;
	/**
	*原值 
	*/
	private  BigDecimal original;
	/**
	*状态 1-入库、2-出库中、3-出库、4-领用、5-报修 
	*/
	private  BigDecimal status;
	/**
	*生产日期 
	*/
	private  Date proddate;
	/**
	*登记人 
	*/
	private  BigDecimal creator;
	/**
	*登记时间 
	*/
	private  Date createtime;
	/**
	*购买人 
	*/
	private  BigDecimal buyer;
	/**
	*购买日期 
	*/
	private  Date bugdate;
	/**
	*序列号 
	*/
	private  String sno;
	/**
	*创建时间 
	*/
	private  Date crtm;
	/**
	*修改时间 
	*/
	private  Date mdtm;
	
	
	public BigDecimal getId() {
		return id;
	}
	public void setId(BigDecimal id) {
		this.id = id;
	}
	public BigDecimal getOgid() {
		return ogid;
	}
	public void setOgid(BigDecimal ogid) {
		this.ogid = ogid;
	}
	public BigDecimal getDtid() {
		return dtid;
	}
	public void setDtid(BigDecimal dtid) {
		this.dtid = dtid;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public BigDecimal getResidual() {
		return residual;
	}
	public void setResidual(BigDecimal residual) {
		this.residual = residual;
	}
	public BigDecimal getOriginal() {
		return original;
	}
	public void setOriginal(BigDecimal original) {
		this.original = original;
	}
	public BigDecimal getStatus() {
		return status;
	}
	public void setStatus(BigDecimal status) {
		this.status = status;
	}
	public Date getProddate() {
		return proddate;
	}
	public void setProddate(Date proddate) {
		this.proddate = proddate;
	}
	public BigDecimal getCreator() {
		return creator;
	}
	public void setCreator(BigDecimal creator) {
		this.creator = creator;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public BigDecimal getBuyer() {
		return buyer;
	}
	public void setBuyer(BigDecimal buyer) {
		this.buyer = buyer;
	}
	public Date getBugdate() {
		return bugdate;
	}
	public void setBugdate(Date bugdate) {
		this.bugdate = bugdate;
	}
	public String getSno() {
		return sno;
	}
	public void setSno(String sno) {
		this.sno = sno;
	}
	public Date getCrtm() {
		return crtm;
	}
	public void setCrtm(Date crtm) {
		this.crtm = crtm;
	}
	public Date getMdtm() {
		return mdtm;
	}
	public void setMdtm(Date mdtm) {
		this.mdtm = mdtm;
	}

	
	
	
	
	
}
