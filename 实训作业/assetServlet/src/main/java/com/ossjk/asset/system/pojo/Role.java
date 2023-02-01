package com.ossjk.asset.system.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Role implements Serializable {

	/**
	* 
	*/
	private  BigDecimal id;
	/**
	*名字 
	*/
	private  String name;
	/**
	*备注 
	*/
	private  String remarks;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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