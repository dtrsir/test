package com.zhongzheng.home.集合与映射表;

import java.util.*;


public class CountKeywords {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string  = "this is a string";
		
		Map<String, Integer> map = new TreeMap<String, Integer>();
		
		String[] word = string.split("[ \n\t\r.;:!?(){}]");
		
		for (int i = 0; i < word.length; i++) {
			String key = word[i].toLowerCase();
			
			if(key.length() > 0) {
				if(!map.containsKey(key)) {
					map.get(key);
					map.put(key, 1);
				}else {
					int value = map.get(key);
					value++;
					map.put(key, value);
					
				}
			}
		}
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
		
		for (Map.Entry<String, Integer> entry : entrySet) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}
	
}
