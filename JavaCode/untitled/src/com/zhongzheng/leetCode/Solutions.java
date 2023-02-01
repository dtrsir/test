package com.zhongzheng.leetCode;

import java.util.HashMap;

public class Solutions {
	public int romanToInt(String s) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		int num = 0;
		for(int i = 0;i < s.length();i++) {
			if(map.get(s.charAt(i)).compareTo(map.get(s.charAt(i+1)))<0) {
				num -= map.get(s.charAt(i)); 
			}else {
				num += map.get(s.charAt(i));
			}
		}
		return num;
    }
}
