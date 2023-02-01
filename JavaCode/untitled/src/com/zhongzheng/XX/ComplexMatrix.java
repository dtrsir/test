package com.zhongzheng.XX;

import com.zhongzheng.XX.Complex;

public class ComplexMatrix extends GenericMatrix<Complex> {
	public Complex[][] list = new Complex[3][3];

	public ComplexMatrix() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ComplexMatrix(Complex...number) {
		super();
		list = (Complex[][])list;
		int count = 0;
		for(int i = 0;i<list.length;i++) {
			for(int j = 0;j<list[0].length;j++,count++) {
				list[i][j] = number[count];
			}
		}
	}

	@Override
	public Complex add(Complex o1, Complex o2) {
		// TODO Auto-generated method stub
		return o1.add(o2);
	}

	@Override
	public Complex mutiple(Complex o1, Complex o2) {
		// TODO Auto-generated method stub
		return o1.multiply(o2);
	}

	@Override
	public Complex zero() {
		// TODO Auto-generated method stub
		return new Complex();
	}
	

	public static void printResult(Complex[][] c1) {
		for(int i = 0;i<c1.length;i++) {
			for(int j = 0;j<c1[0].length;j++) {
				System.out.println(c1[i][j]);
			}
		}
	}


}
