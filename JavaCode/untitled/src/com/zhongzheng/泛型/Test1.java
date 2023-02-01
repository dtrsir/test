package com.zhongzheng.泛型;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


public class Test1 {
	
	/*
	 * 自行设计案例分别实现以下功能
	 * 1） 采用ArrayList、LinkedList实现数学中集合的并、交、补、差操作 。
	 * 2）设计程序分别测试ArrayList、LinkedList集合进行插入、删除、访问操作的性能 。
	 * 3）对比ArrayList、LinkedList集合通过get方法遍历和通过Iterator进行遍历的性能差异。
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
		//交集
		al1.retainAll(al2);
		ll1.retainAll(ll2);
		for(Integer x:al1) {
			System.out.println(x);
		}
		//差集
		al1.removeAll(al2);
		ll1.removeAll(ll2);
		//并集
		al1.addAll(al2);
		ll1.addAll(ll2);
		//相对补集
		al1.removeAll(al2);
		ll1.removeAll(ll2);                                    
		
		al1 = new ArrayList<Integer>(); 
		ll2 = new LinkedList<Integer>(); 
		                      
		//顺序表插入        
		long befer = System.currentTimeMillis();
		for(int i = 0;i<1000000;i++) {
			al1.add(0, i);
		}
		long after = System.currentTimeMillis();
		System.out.println("顺序表插入"+(after-befer));
		//链表插入
		befer = System.currentTimeMillis();
		for(int i = 0;i<1000000;i++) {
			ll1.add(0, i);
		}
		after = System.currentTimeMillis();
		System.out.println("链表插入"+(after-befer));
		
		//顺序表删除
		befer = System.currentTimeMillis();
		for(int i = 0;i<100000;i++) {
			al1.remove(i);
		}
		after = System.currentTimeMillis();
		System.out.println("顺序表删除"+(after-befer));
		//链表删除
		befer = System.currentTimeMillis();
		for(int i = 0;i<100000;i++) {
			ll1.remove(i);
		}
		after = System.currentTimeMillis();
		System.out.println("链表删除"+(after-befer));
		
		
		//顺序表访问(通过get方法遍历)
		befer = System.currentTimeMillis();
		for(int i = 0;i<100000;i++) {
			al1.get(i);
		}
		after = System.currentTimeMillis();
		System.out.println("顺序表访问(通过get方法遍历)"+(after-befer));
		//链表访问(通过get方法遍历)
		befer = System.currentTimeMillis();
		for(int i = 0;i<100000;i++) {
			ll1.get(i);
		}
		after = System.currentTimeMillis();
		System.out.println("链表访问(通过get方法遍历)"+(after-befer));
		
		

		//顺序表访问(通过Iterator进行遍历)
		ListIterator<Integer> it = al1.listIterator();
		befer = System.currentTimeMillis();
		while(it.hasNext()) {
			it.next();
		}
		after = System.currentTimeMillis();
		System.out.println("顺序表访问(通过Iterator进行遍历)"+(after-befer));
		//链表访问(通过Iterator进行遍历)
		it = ll1.listIterator(); 
		befer = System.currentTimeMillis();
		while(it.hasNext()) {
			it.next();
		}
		after = System.currentTimeMillis();
		System.out.println("链表访问(通过Iterator进行遍历)"+(after-befer));
		
	}

}
