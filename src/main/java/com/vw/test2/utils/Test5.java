package com.vw.test2.utils;

import java.util.Arrays;

public class Test5 {
	
	public String getMaxSubString(char[] c1, char[] c2) {
		
		int m = c1.length;
		int n = c2.length;
		int[][]dp = new int[m][n];
		for(int j = 0; j < n; j ++)
			dp[0][j] = c1[0] == c2[j]?1:0;
		
		for(int i = 0; i < m; i ++)
			dp[i][0] = c1[i] == c2[0]?1:0;
		
		for(int i = 1; i < m; i ++) {
			for(int j = 1; j < n; j++) {
				if(c1[i] == c2[j])
					dp[i][j] = dp[i-1][j-1] + 1;
				else
					dp[i][j] = 0;
			}
		}
		
		for(int i = 0; i <m ; i ++) {
			for(int j = 0; j <n; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		int max = 0;
		int index = 0;
		for(int i = 0; i < m; i ++) {
			for(int j = 0; j < n; j ++) {
				if(max < dp[i][j]) {
					max = dp[i][j];
					index = i;
				}
			}
		}
		
		System.out.println("max:" + max);
		
		String res = String.valueOf(Arrays.copyOfRange(c1, index - max + 1, index + 1));
		
		return res;
	}
	
	public static void main(String[] args) {
		String str1 = "15780ACUIOU34523";
		String str2 = "12402402304080ACUIOJLADJFA";
		
		Test5 t = new Test5();
		
		String res = t.getMaxSubString(str1.toCharArray(), str2.toCharArray());
		System.out.println(res);
	}

}
