package com.zhongzheng.homeWork.abstract1;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Triangle triangle = null;
		try {
			triangle = new Triangle(3, 4, 5, "red", false);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			System.out.println(triangle.toString());
		}
		

	}

}
