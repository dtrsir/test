package com.zhongzheng.·ºÐÍ;

import java.util.ArrayList;

public class Test {
	
	public static void main(String[] args) {
		Integer[] a = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(binarySearch(a, (Integer)10));
	}
	
	public static <E extends Comparable<E>> int binarySearch(E[] list, E key){
		int index = list.length/2;
		while(true) {
			if(key.compareTo(list[index])>0) {
				index = (list.length-index)/2+index;
			}else if(key.compareTo(list[index])<0) {
				index = index/2;
			}else {
				return index;
			}
		}
	}

}
