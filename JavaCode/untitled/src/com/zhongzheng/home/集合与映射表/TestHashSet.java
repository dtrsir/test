package com.zhongzheng.home.集合与映射表;

import java.util.*;

public class TestHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set = new HashSet<String>();
		
		set.add("d");
		set.add("ds");
		set.add("dsa");
		set.add("dsad");
		set.add("ddsds");
		set.add("dw");
		set.add("dr");
		
		System.out.println(set);
		
		for(String e : set) {
			System.out.println(e);
		}
		
		Set<String> set1 = new LinkedHashSet<String>();
		
		set1.add("1");
		set1.add("2");
		set1.add("3");
		set1.add("4");
		set1.add("5");
		set1.add("6");
		
		System.out.println(set1);
		
		for(String e : set1) {
			System.out.println(e);
		}
		

	}

}
