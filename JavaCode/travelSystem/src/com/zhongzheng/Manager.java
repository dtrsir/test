package com.zhongzheng;

public class Manager extends Employee {
	private double[] stay = {350,300,250,150};
	private double stays;
	private int day;
	private double stayMoney;
	

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, int place, double traffic, double stays, int day) {
		super(traffic, name, place, day);
		double money;
		if(stays > stay[place]) {
			money = -(0.4 * (stays - stay[place]));
		}else {
			money = 0.5 * (stay[place] - stays);
		}
		this.stays = money * day;
		this.stayMoney = stays * day;
		this.day = day;
		// TODO Auto-generated constructor stub
	}
	
	public double getStayMoney() {
		return stayMoney;
	}

	public double getStays() {
		return stays;
	}
	
	

}
