package com.zhongzheng.����;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


public class Test1 {
	
	/*
	 * ������ư����ֱ�ʵ�����¹���
	 * 1�� ����ArrayList��LinkedListʵ����ѧ�м��ϵĲ���������������� ��
	 * 2����Ƴ���ֱ����ArrayList��LinkedList���Ͻ��в��롢ɾ�������ʲ��������� ��
	 * 3���Ա�ArrayList��LinkedList����ͨ��get����������ͨ��Iterator���б��������ܲ��졣
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> al1 = new ArrayList<Integer>();
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		for(int i = 1;i<5;i++) {
			al1.add(i);
		}
		for(int i = 1;i<5;i++) {
			al2.add(i);
		}
		
		
		LinkedList<Integer> ll1 = new LinkedList<Integer>();
		LinkedList<Integer> ll2 = new LinkedList<Integer>();
		for(int i = 1;i<5;i++) {
			ll1.add(i);
		}
		for(int i = 1;i<5;i++) {
			ll2.add(i);
		}
		//����
		al1.retainAll(al2);
		ll1.retainAll(ll2);
		for(Integer x:al1) {
			System.out.println(x);
		}
		//�
		al1.removeAll(al2);
		ll1.removeAll(ll2);
		//����
		al1.addAll(al2);
		ll1.addAll(ll2);
		//��Բ���
		al1.removeAll(al2);
		ll1.removeAll(ll2);                                    
		
		al1 = new ArrayList<Integer>(); 
		ll2 = new LinkedList<Integer>(); 
		                      
		//˳������        
		long befer = System.currentTimeMillis();
		for(int i = 0;i<1000000;i++) {
			al1.add(0, i);
		}
		long after = System.currentTimeMillis();
		System.out.println("˳������"+(after-befer));
		//�������
		befer = System.currentTimeMillis();
		for(int i = 0;i<1000000;i++) {
			ll1.add(0, i);
		}
		after = System.currentTimeMillis();
		System.out.println("�������"+(after-befer));
		
		//˳���ɾ��
		befer = System.currentTimeMillis();
		for(int i = 0;i<100000;i++) {
			al1.remove(i);
		}
		after = System.currentTimeMillis();
		System.out.println("˳���ɾ��"+(after-befer));
		//����ɾ��
		befer = System.currentTimeMillis();
		for(int i = 0;i<100000;i++) {
			ll1.remove(i);
		}
		after = System.currentTimeMillis();
		System.out.println("����ɾ��"+(after-befer));
		
		
		//˳������(ͨ��get��������)
		befer = System.currentTimeMillis();
		for(int i = 0;i<100000;i++) {
			al1.get(i);
		}
		after = System.currentTimeMillis();
		System.out.println("˳������(ͨ��get��������)"+(after-befer));
		//�������(ͨ��get��������)
		befer = System.currentTimeMillis();
		for(int i = 0;i<100000;i++) {
			ll1.get(i);
		}
		after = System.currentTimeMillis();
		System.out.println("�������(ͨ��get��������)"+(after-befer));
		
		

		//˳������(ͨ��Iterator���б���)
		ListIterator<Integer> it = al1.listIterator();
		befer = System.currentTimeMillis();
		while(it.hasNext()) {
			it.next();
		}
		after = System.currentTimeMillis();
		System.out.println("˳������(ͨ��Iterator���б���)"+(after-befer));
		//�������(ͨ��Iterator���б���)
		it = ll1.listIterator(); 
		befer = System.currentTimeMillis();
		while(it.hasNext()) {
			it.next();
		}
		after = System.currentTimeMillis();
		System.out.println("�������(ͨ��Iterator���б���)"+(after-befer));
		
	}

}
