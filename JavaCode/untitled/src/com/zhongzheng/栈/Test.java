package com.zhongzheng.ջ;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stock<Integer> stock = new Stock<Integer>();
		for (int i = 1; i < 20; i++) {
			stock.push(i);
		}
		System.out.println(stock.pop());
		stock.stockSize();
		stock.stockPrint();

	}

}
