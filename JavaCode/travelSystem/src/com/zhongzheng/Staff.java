package com.zhongzheng;

public class Staff extends Employee {
	private double[] stay = {270,230,200,150};
	private double stays;
	private int day;
	private double stayMoney;
	
	public Staff() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Staff(String name, int place, double traffic, double stays, int day) {
		super(traffic, name, place, day);
		double money;
		if(stays > stay[place]) {
			money = -(0.5 * (stays - stay[place]));
		}else {
			money = 0.7 * (stay[place] - stays);
		}
		this.stayMoney = stays * day;
		this.stays = money * day;
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
