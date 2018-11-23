package com.vw.test2.utils;

public class Test4 {

	public int maxSubStringLength(char[] c1, char[] c2) {
		
		int[][] dp = new int[c1.length][c2.length];
		for(int j = 0; j < c2.length; j ++)
			dp[0][j] = c1[0] == c2[j]?1:0;
		
		for(int i = 0; i < c1.length; i ++)
			dp[i][0] = c1[i] == c2[0]?1:0;
		
		for(int i = 1; i < c1.length; i ++) {
			for(int j = 1; j < c2.length; j ++) {
				if(c1[i] == c2[j])
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		for(int i = 0; i < c1.length; i ++) {
			for(int j = 0; j < c2.length; j ++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		return dp[c1.length-1][c2.length-1];
	}
	
	public String getSubString(char[] c1, char[] c2) {
		
		int[][] dp = new int[c1.length][c2.length];
		for(int j = 0; j < c2.length; j ++)
			dp[0][j] = c1[0] == c2[j]?1:0;
		
		for(int i = 0; i < c1.length; i ++)
			dp[i][0] = c1[i] == c2[0]?1:0;
		
		for(int i = 1; i < c1.length; i ++) {
			for(int j = 1; j < c2.length; j ++) {
				if(c1[i] == c2[j])
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
			}
		}
		
		int m = c1.length -1;
		int n = c2.length -1;
		
		char[] res = new char[dp[m][n]];
		int index = dp[m][n];
		while(index > 0) {			
			if(m > 0 && dp[m][n] == dp[m-1][n])
				m--;
			else if(n > 0 && dp[m][n] == dp[m][n-1])
				n--;
			else {
				res[--index] = c1[m];
				m--;
				n--;
			}
		}
		
		return String.valueOf(res);		
	}
	
		
	public static void main(String[] args) {
		Test4 t = new Test4();
		String s1 = "1A2C3D4B56";
		String s2 = "B1D23CA45B6A";
		
		int num = t.maxSubStringLength(s1.toCharArray(), s2.toCharArray());		
		System.out.println(num);
		
		String res = t.getSubString(s1.toCharArray(), s2.toCharArray());
		System.out.println(res);
	}
}
