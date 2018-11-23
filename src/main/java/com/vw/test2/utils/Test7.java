package com.vw.test2.utils;

public class Test7 {

	private static class Goods {
		int w;
		int v;
		
		public Goods(int w, int v) {
			this.w = w;
			this.v = v;
		}

		public int getW() {
			return w;
		}

		public void setW(int w) {
			this.w = w;
		}

		public int getV() {
			return v;
		}

		public void setV(int v) {
			this.v = v;
		}
	}
	
	public int getMaxValue(Goods[] goods, int c) {
		int dp[][] = new int[goods.length + 1][c + 1];
		for(int i = 0; i < dp.length ; i ++) {
			for(int j = 0; j < dp[0].length; j ++) {
				dp[i][j] = 0;
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		for(int i = 1; i < dp.length; i ++) {
			for(int j = 1; j < dp[0].length; j ++) {
				if(j >= goods[i-1].w) {
					dp[i][j] = Math.max(dp[i-1][j -goods[i-1].w] + goods[i-1].v, dp[i-1][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}
		
		for(int i = 0; i < dp.length ; i ++) {
			for(int j = 0; j < dp[0].length; j ++) {				
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		int max = 0;
		
		for(int i = 0; i < dp.length ; i ++) {
			for(int j = 0; j < dp[0].length; j ++) {				
				if(max < dp[i][j])
					max = dp[i][j];
			}
		}
		
		
		return max;
	}
	
	public int getMaxValue2(Goods[] goods, int c) {
		int dp[][] = new int[goods.length][c];
		
		for(int j = 0; j < dp[0].length; j ++) {
			if(j+1 >= goods[0].w)
				dp[0][j] = goods[0].v;
			else
				dp[0][j] = 0;
		}
		
		for(int i = 0; i < dp.length; i ++) {
			if(1 >= goods[i].w)
				dp[i][0] = goods[i].v;
			else
				dp[i][0] = 0;
		}
		

		
		for(int i = 1; i < dp.length; i ++) {
			for(int j = 1; j < dp[0].length; j ++) {
				if(j + 1 >= goods[i].w)
					dp[i][j] = Math.max(dp[i-1][j-(goods[i].w-1)] + goods[i].v, dp[i-1][j]);
				else
					dp[i][j] = 0;
			}
		}
		
		System.out.println("######");
		
		for(int i = 0; i < dp.length ; i ++) {
			for(int j = 0; j < dp[0].length; j ++) {				
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		
		
		int max = 0;
		for(int i = 0; i < dp.length ; i ++) {
			for(int j = 0; j < dp[0].length; j ++) {				
				if(max < dp[i][j])
					max = dp[i][j];
			}
		}
		
		return max;
	}
	
	public static void main(String[] args) {
		Test7 t = new Test7();
		Goods[] gs = new Goods[] {new Goods(2, 5), new Goods(1, 2), new Goods(4, 10), new Goods(5, 8), new Goods(3, 5)};
		
		int res = t.getMaxValue(gs, 10);
		System.out.println("max: " + res);
		
		res = t.getMaxValue2(gs, 10);
		System.out.println("max: " + res);
		
		
	}
}
