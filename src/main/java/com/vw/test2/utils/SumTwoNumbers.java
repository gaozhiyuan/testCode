package com.vw.test2.utils;

public class SumTwoNumbers {
	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		ListNode head = null;
		ListNode result = null;
		ListNode p = null;
		int carry = 0;
		while(l1 != null || l2 != null) {
			
			int x = l1 == null? 0 : l1.val;
			int y = l2 == null? 0 : l2.val;
			
			int sum = x + y + carry;
			carry = sum / 10;
			
			result = new ListNode(sum % 10);
			
			if(p == null)
				head = result;
			if(p != null)
				p.next = result;
			p = result;
			
			l1 = l1 == null? l1:l1.next;
			l2 = l2 == null? l2:l2.next;
		}
		
		if(carry > 0) {
			result.next = new ListNode(carry);
		}
		
		return head;
	}
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(2);
		l1.next  = new ListNode(4);
		l1.next.next = new ListNode(3);
		
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
//		l2.next.next.next = new ListNode(9);
//		l2.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next.next.next = new ListNode(9);
//		l2.next.next.next.next.next.next.next.next.next = new ListNode(9);
		
		SumTwoNumbers t = new SumTwoNumbers();
		ListNode head = t.addTwoNumbers(l1, l2);
		
		while(head != null) {
			System.out.print(head.val);
			head = head.next;
		}
	}
}
