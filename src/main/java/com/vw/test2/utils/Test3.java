package com.vw.test2.utils;

public class Test3 {

	public int getLongest(int[] n) {
		int len = 1;
		for(int i = 1; i < n.length; i ++) {
			if(n[i] > n[i - 1])
				len++;
		}
		
		return len;
	}
	
	public int getLongest2(int[] n) {
		int[] len = new int[n.length];
		len[0] = 1;
		for(int i = 1; i < n.length; i ++) {
			if(n[i] > n[i - 1])
				len[i] = len[i-1] + 1;
			else
				len[i] = len[i-1];
		}
		
		return len[n.length - 1];
	}
	
	public static void main(String[] args) {
		Test3 t = new Test3();
		int[] n = new int[] {1, 2, 3, 3, 3, 1, 1, 5, 4, 5};
		int len = t.getLongest(n);
		System.out.println(len);
		
		len = t.getLongest2(n);
		System.out.println(len);
	}
}
