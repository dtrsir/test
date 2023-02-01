package com.zhongzheng.homeWork.abstract1;


public class Triangle extends GeometricObject {
	private double one,two,three;
	private Exception RuntimeException;
	

	public Triangle() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Triangle(double one, double two, double three, String color, boolean filled) throws Exception {
		super(color, filled);
		this.one = one;
		this.two = two;
		this.three = three;
		if(one + two <= three) {
			throw RuntimeException;
		}
	}

	public Triangle(String color, boolean filled) {
		super(color, filled);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		double p = (one + two + three) / 2;
		return Math.sqrt(p * (p-one) * (p-two) * (p-three));
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return one + two + three;
	}

	@Override
	public String toString() {
		return "Triangle [area=" + this.getArea() + ", perimeter=" + this.getPerimeter() + ", color=" + this.getColor() + ", filled=" + this.isFilled()
				+ "]";
	}
	
	

}
