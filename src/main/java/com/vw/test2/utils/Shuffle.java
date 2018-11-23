package com.vw.test2.utils;

public class Shuffle {

	public void printShuffle(int[] a, int n, int k) {
		if(k == 1) {
			for(int i = 0; i < n; i ++)
				System.out.print(a[i]);
			System.out.println();
		}
		
		for(int i = 0; i < k; i ++) {
			if(i != k-1) {
				a[i]   = a[i] ^ a[k-1];
				a[k-1] = a[i] ^ a[k-1];
				a[i]   = a[i] ^ a[k-1];
			}
//			int tmp = a[i];
//			a[i] = a[k-1];
//			a[k-1] = tmp;
			
			printShuffle(a, n, k-1);
			
			if(i != k-1) {
				a[i]   = a[i] ^ a[k-1];
				a[k-1] = a[i] ^ a[k-1];
				a[i]   = a[i] ^ a[k-1];
			}
//			tmp = a[i];
//			a[i] = a[k-1];
//			a[k-1] = tmp;
		}
	}
	
	public static void main(String[] args) {
		int[] a = new int[] {1, 2, 3, 4};
		Shuffle t = new Shuffle();
		t.printShuffle(a, a.length, a.length);
		
		int i = 10;
		int j = 20;
		i = i ^ j;
		j = i ^ j;
		i = i ^ j;
		
		System.out.println(i);
		System.out.println(j);
	}
}
