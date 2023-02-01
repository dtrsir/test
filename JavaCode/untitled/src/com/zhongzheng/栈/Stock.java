package com.zhongzheng.ջ;

import java.lang.reflect.Array;

public class Stock<E> {
	//����newһ����������������ת�ͳ���Ҫ������
	private E[] date = (E[]) new Object[10];
	private int head = 0;
	
	public Stock() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	/*
	 * ��Ȼ����Ҳ����ͨ������������һ����������
	 * public Stock(class<T> type, int listLenght) { 
	 * 		super(); 
	 * 		date = (E[]) Array.newInstance(type,listLenght); 
	 * }
	 */
	public Stock(int listLenght) {
		super();
		date = (E[]) new Object[listLenght];
	}
	//��ʼ��ջ
	public void stockInit() {
		head = 0;
	}
	//�Զ�����
	private E[] stockBig(E[] date) {
		E[] date1 = (E[]) new Object[date.length+20];
		System.arraycopy(date, 0, date1, 0, date.length);
		date = date1;
		return date;
	}
	//��ջ
	public void push (E elem) {
		if(isFull()) {
			date = stockBig(date);
			System.out.println("ջ����1��");
		}
		date[head] = elem;
		head++;
	}
	//��ջ
	public E pop() {
		if(isEmpty()) {
			System.out.println("ջΪ�գ��޷���ջ");
			return null;
		}else {
			head--;
			return date[head];
		}
	}
	//�п�
	public boolean isEmpty() {
		if(head-1<0) {
			return true;
		}else {
			return false;
		}
	}
	//����
	public boolean isFull() {
		if(head>date.length-1) {
			return true;
		}else {
			return false;
		}
	}
	//ջ���
	public void stockSize() {
		System.out.print("ջ��:");
		System.out.println(head);
	}
	//��ӡջ
	public void stockPrint() {
		for (int i = 0;i < head;i++) {
			System.out.print(date[i]+"  ");
		}
	}
	//��ȡջ��Ԫ��
	public E top() {
		return date[head-1];
	}
}
