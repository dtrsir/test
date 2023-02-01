package com.zhongzheng.homeWork.abs3;

import com.zhongzheng.homeWork.abstract1.GeometricObject;

public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
	private double size;//¼ÙÉè°Ë±ßÏàµÈ

	public Octagon(double size, String color, boolean filled) {
		super(color, filled);
		this.size = size;
	}

	public Octagon() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Octagon(String color, boolean filled) {
		super(color, filled);
		// TODO Auto-generated constructor stub
	}
	
	

	public double getSize() {
		return size;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (2 + 4 / Math.sqrt(2)) * Math.pow(size, 2);
	}

	@Override
	public double getPerimeter() {
		// TODO Auto-generated method stub
		return size * 8;
	}
	
	@Override
	public Octagon clone() {
		Octagon octagon =null;
		try {
			octagon = (Octagon) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return octagon;
	}

	@Override
	public int compareTo(Octagon o) {
		// TODO Auto-generated method stub
		if(o instanceof Octagon) {
			if(this.getSize() > o.getSize()) {
				return 1;
			}else {
				return 0;
			}
		}
		return -1;
	}
	
	
}
