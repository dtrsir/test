package com.zhongzheng.������¼;

public class Value {
	private int serialNumber;
	private String name;
	private String peopleName;
	private double maney;
	private int number;
	
	public Value() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Value(int serialNumber, String name, String peopleName, double maney, int number) {
		super();
		this.serialNumber = serialNumber;
		this.name = name;
		this.peopleName = peopleName;
		this.maney = maney;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number +  this.number;
	}

	public int getSerialNumber() {
		return serialNumber;
	}

	public String getName() {
		return name;
	}

	public String getPeopleName() {
		return peopleName;
	}

	public double getManey() {
		return maney;
	}

	@Override
	public String toString() {
		return "������¼��" + serialNumber+ '\n' + 
				"��Ʒ���ƣ�" + name + "\n" +
				"��ϵ�ˣ�" + peopleName + '\n' + 
				"���ۣ�" + maney + '\n' + 
				"���������" + number + '\n';
	}
	
	public String nowToString() {
		return "��ǰ������¼��" + serialNumber+ '\n' + 
				"��Ʒ���ƣ�" + name + "\n" +
				"��ϵ�ˣ�" + peopleName + '\n' + 
				"���ۣ�" + maney + '\n' + 
				"���������" + number + '\n';
	}
	
	
	

}
