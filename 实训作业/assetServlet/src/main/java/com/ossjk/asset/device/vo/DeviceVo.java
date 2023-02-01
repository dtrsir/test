package com.ossjk.asset.device.vo;

import java.io.Serializable;
import java.math.BigDecimal;

//数据库逻辑对象
public class DeviceVo implements Serializable {
	
	private  BigDecimal id;
	
	
	private  String dtname;  //dtid
	
	private  String code;  
	
	private  String creatorName;
	

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getDtname() {
		return dtname;
	}

	public void setDtname(String dtname) {
		this.dtname = dtname;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCreatorName() {
		return creatorName;
	}

	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}  
	
	
	
	
	
}
