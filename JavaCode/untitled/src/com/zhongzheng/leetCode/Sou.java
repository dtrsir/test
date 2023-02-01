package com.zhongzheng.leetCode;

public class Sou {
	
	public static void main(String[] args) {
		System.out.println(soulect("*o**o***o***","*o***o**o***"));
		
	}
	
	public static int soulect(String a, String b){
		int star = -1;
		int end = -1;
		for(int i = 0;i < a.length();i++) {
			if(star==-1 && a.charAt(i)!=b.charAt(i)) {
				star = i;
				System.out.println(star);
			}else if(a.charAt(i)!=b.charAt(i)) {
				end = i;
				System.out.println(end);
			}
		}
		return (end-star);
	}

}
