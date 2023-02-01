package com.zhongzheng.XX;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ComplexMatrix cm1 = new ComplexMatrix(new Complex(1,1), new Complex(1,1), new Complex(1,1), new Complex(1,1),
								new Complex(1,1), new Complex(1,1), new Complex(1,1), new Complex(1,1), new Complex(1,1));
		ComplexMatrix cm2 = new ComplexMatrix(new Complex(1,1), new Complex(1,1), new Complex(1,1), new Complex(1,1),
				new Complex(1,1), new Complex(1,1), new Complex(1,1), new Complex(1,1), new Complex(1,1));
		cm1.printResult(cm1.addMatrix(cm1.list, cm2.list));
		cm1.printResult(cm1.mutipleMatrix(cm1.list, cm2.list));
	}
}
