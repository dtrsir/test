package com.ossjk.asset.device.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Devicetype implements Serializable {

	/**
	* 
	*/
	private  BigDecimal id;
	/**
	*名字 
	*/
	private  String name;
	/**
	*品牌 
	*/
	private  String brand;
	/**
	*国际编号 
	*/
	private  String intlcode;
	/**
	*型号 
	*/
	private  String model;
	/**
	*备注 
	*/
	private  String remarks;
	/**
	*使用年限 
	*/
	private  BigDecimal asl;
	/**
	*预计净残值 
	*/
	private  BigDecimal anrv;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getIntlcode() {
		return intlcode;
	}
	public void setIntlcode(String intlcode) {
		this.intlcode = intlcode;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public BigDecimal getAsl() {
		return asl;
	}
	public void setAsl(BigDecimal asl) {
		this.asl = asl;
	}
	public BigDecimal getAnrv() {
		return anrv;
	}
	public void setAnrv(BigDecimal anrv) {
		this.anrv = anrv;
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
