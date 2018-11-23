package com.vw.test2.utils;

public class Test6 {

	public long getNum(int n) {
		
		if(n < 5)
			return n;
		
		long[] dp = new long[n];
		for(int i = 0; i < 5; i ++)
			dp[i] = i + 1;
				
		for(int i = 4; i < n; i ++) {
			
			dp[i] = dp[i-1] + dp[i-3];
		}
		
		return dp[n - 1];
	}
	
	public long getNum2(int n) {
		if(n < 5)
			return n;
		return getNum2(n-1) + getNum2(n-3);
	}
	
	public long getNum3(int n) {
		if(n < 3)
			return n;
		
		long pre = 3;
		long prepre = 2;
		long preprepre = 1;
		long res = 0;
		
		for(int i = 4; i <= n; i ++) {
			res = pre + preprepre;
			preprepre = prepre;
			prepre = pre;
			pre = res;
		}
		
		return res;
	}
	
	public static void main(String[] args) {
		Test6 t = new Test6();
		long res = t.getNum(100);		
		System.out.println(res);
		
		res = t.getNum3(100);
		System.out.println(res);
	}
}
