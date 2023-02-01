package com.ossjk.asset.system.vo;

import com.ossjk.asset.system.pojo.Device;

public class DeviceVo extends Device {
	private String uname;
	private String pwd;
	public String getUname() {
		return uname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
}
