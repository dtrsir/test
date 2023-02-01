package com.zhongzheng;

public class Employee {
	private double[] subsidy = {90,70,60,60};
	private double traffic;
	private String name;
	private double placeMoney;
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(double traffic, String name, int place, int day) {
		super();
		this.placeMoney = subsidy[place] * day;
		this.traffic = traffic;
		this.name = name;
		
	}

	public double getTraffic() {
		return traffic;
	}

	public String getName() {
		return name;
	}

	public double getPlaceMoney() {
		return placeMoney;
	}
	
	
	
	
	
	
	
	
	

}
