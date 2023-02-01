package com.zhongzheng.栈;

import java.lang.reflect.Array;

public class Stock<E> {
	//这里new一个对象数组来向下转型成需要的类型
	private E[] date = (E[]) new Object[10];
	private int head = 0;
	
	public Stock() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	/*
	 * 当然我们也可以通过反射来创建一个泛型数组
	 * public Stock(class<T> type, int listLenght) { 
	 * 		super(); 
	 * 		date = (E[]) Array.newInstance(type,listLenght); 
	 * }
	 */
	public Stock(int listLenght) {
		super();
		date = (E[]) new Object[listLenght];
	}
	//初始化栈
	public void stockInit() {
		head = 0;
	}
	//自动扩容
	private E[] stockBig(E[] date) {
		E[] date1 = (E[]) new Object[date.length+20];
		System.arraycopy(date, 0, date1, 0, date.length);
		date = date1;
		return date;
	}
	//进栈
	public void push (E elem) {
		if(isFull()) {
			date = stockBig(date);
			System.out.println("栈扩容1次");
		}
		date[head] = elem;
		head++;
	}
	//出栈
	public E pop() {
		if(isEmpty()) {
			System.out.println("栈为空，无法出栈");
			return null;
		}else {
			head--;
			return date[head];
		}
	}
	//判空
	public boolean isEmpty() {
		if(head-1<0) {
			return true;
		}else {
			return false;
		}
	}
	//判满
	public boolean isFull() {
		if(head>date.length-1) {
			return true;
		}else {
			return false;
		}
	}
	//栈深度
	public void stockSize() {
		System.out.print("栈深:");
		System.out.println(head);
	}
	//打印栈
	public void stockPrint() {
		for (int i = 0;i < head;i++) {
			System.out.print(date[i]+"  ");
		}
	}
	//获取栈顶元素
	public E top() {
		return date[head-1];
	}
}
