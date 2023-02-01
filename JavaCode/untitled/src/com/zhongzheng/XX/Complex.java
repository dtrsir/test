package com.zhongzheng.XX;

public class Complex implements Cloneable,Comparable<Complex> {
	private double realPart;//Êµ²¿
	private double imaginaryPart;//Ðé²¿
	
	public Complex() {
		super();
		realPart = 0;
		imaginaryPart = 0;
		// TODO Auto-generated constructor stub
	}

	public Complex(double a, double b) {
		super();
		this.realPart = a;
		this.imaginaryPart = b;
	}
	
	public Complex(double a) {
		super();
		this.realPart = a;
		imaginaryPart = 0;
	}

	public double getRealPart() {
		return realPart;
	}

	public double getImaginaryPart() {
		return imaginaryPart;
	}
	
	
	public void setRealPart(double realPart) {
		this.realPart = realPart;
	}

	public void setImaginaryPart(double imaginaryPart) {
		this.imaginaryPart = imaginaryPart;
	}

	public Complex add(Complex c1) {
		Complex torget = new Complex();
		torget.setRealPart(realPart + c1.getRealPart());
		torget.setImaginaryPart(imaginaryPart + c1.getImaginaryPart());
		return torget;
	}
	
	public Complex subtract(Complex c1) {
		Complex torget = new Complex();
		torget.setRealPart(realPart - c1.getRealPart());
		torget.setImaginaryPart(imaginaryPart - c1.getImaginaryPart());
		return torget;
	}
	
	public Complex multiply(Complex c1) {
		Complex torget = new Complex();
		torget.setRealPart(realPart * c1.getRealPart() - imaginaryPart * c1.getImaginaryPart());
		torget.setImaginaryPart(imaginaryPart * c1.getRealPart() + realPart * c1.getImaginaryPart());
		return torget;
	}
	
	public Complex divide(Complex c1) {
		Complex torget = new Complex();
		torget.setRealPart((realPart*c1.getRealPart()+imaginaryPart*c1.getImaginaryPart())/(Math.pow(c1.getRealPart(), 2) + Math.pow(c1.getImaginaryPart(), 2)));
		torget.setImaginaryPart((imaginaryPart*c1.getRealPart()-realPart*c1.getImaginaryPart())/(Math.pow(c1.getRealPart(), 2) + Math.pow(c1.getImaginaryPart(), 2)));
		return torget;
	}
	
	public double abs() {
		return Math.sqrt((Math.pow(realPart, 2)+Math.pow(imaginaryPart, 2)));
	}
	
	@Override
	public String toString() {
		if(imaginaryPart==0) {
			return realPart + "";
		}
		return realPart + " + " + imaginaryPart + "i";
	}

	@Override
	public int compareTo(Complex o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
