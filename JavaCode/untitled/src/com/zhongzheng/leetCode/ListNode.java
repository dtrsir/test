package com.zhongzheng.leetCode;

public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	int tem = 1;
    	int num1 = 0;
    	int num2 = 0;
    	while(l1.next!=null) {
    		num1 += tem*l1.val;
    		tem *= 10;
    		l1.val=l1.next.val;
    		l1.next=l1.next.next;
    	}
    	tem = 1;
    	while(l2.next!=null) {
    		num2 += tem*l2.val;
    		tem *= 10;
    		l2.val=l2.next.val;
    		l2.next=l2.next.next;
    	}
    	ListNode l3 = new ListNode();
    	ListNode listnode;
    	tem = num1+num2;
    	int i = 0;
    	int total = 0;
    	for(int j = 10; total != 0; i++, j *= 10) {
    		total = tem % j;
    		listnode = new ListNode(total, l3);
    		l3 = listnode;
    	}
    	return l3;

    }
}
