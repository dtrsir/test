package com.zhongzheng;

public class Leader extends Employee {
	private double[] stay = {700,600,500,400};
	private double stays;
	private int day;
	private double stayMoney;

	public Leader() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Leader(String name, int place, double traffic, double stays, int day) {
		super(traffic, name, place, day);
		double money;
		if(stays > stay[place]) {
			money = -(0.2 * (stays - stay[place]));
		}else {
			money = 0.3 * (stay[place] - stays);
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
