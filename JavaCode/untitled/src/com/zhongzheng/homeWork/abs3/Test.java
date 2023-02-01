package com.zhongzheng.homeWork.abs3;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Octagon octagon = new Octagon(5, "red", true);
		System.out.println("Area is " + octagon.getArea() + '\n' + "Perimeter is " + octagon.getPerimeter());
		Octagon octagon1 = octagon.clone();
		System.out.println(octagon.compareTo(octagon1));
		
		
		
	}

}
