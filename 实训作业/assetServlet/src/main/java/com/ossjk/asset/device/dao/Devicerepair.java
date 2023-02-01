package com.ossjk.asset.device.dao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Devicerepair implements Serializable {

	/**
	* 
	*/
	private  BigDecimal id;
	/**
	*设备id 
	*/
	private  BigDecimal did;
	/**
	*报修人 
	*/
	private  BigDecimal damager;
	/**
	*报修时间 
	*/
	private  Date damagedate;
	/**
	*报修备注 
	*/
	private  String damageremarks;
	/**
	*维修时间 
	*/
	private  Date repairdate;
	/**
	*维修人 
	*/
	private  BigDecimal repairer;
	/**
	*维修备注 
	*/
	private  String repairremarks;
	/**
	*状态 1-报修、2-维修 
	*/
	private  BigDecimal status;
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
	public BigDecimal getDid() {
		return did;
	}
	public void setDid(BigDecimal did) {
		this.did = did;
	}
	public BigDecimal getDamager() {
		return damager;
	}
	public void setDamager(BigDecimal damager) {
		this.damager = damager;
	}
	public Date getDamagedate() {
		return damagedate;
	}
	public void setDamagedate(Date damagedate) {
		this.damagedate = damagedate;
	}
	public String getDamageremarks() {
		return damageremarks;
	}
	public void setDamageremarks(String damageremarks) {
		this.damageremarks = damageremarks;
	}
	public Date getRepairdate() {
		return repairdate;
	}
	public void setRepairdate(Date repairdate) {
		this.repairdate = repairdate;
	}
	public BigDecimal getRepairer() {
		return repairer;
	}
	public void setRepairer(BigDecimal repairer) {
		this.repairer = repairer;
	}
	public String getRepairremarks() {
		return repairremarks;
	}
	public void setRepairremarks(String repairremarks) {
		this.repairremarks = repairremarks;
	}
	public BigDecimal getStatus() {
		return status;
	}
	public void setStatus(BigDecimal status) {
		this.status = status;
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
